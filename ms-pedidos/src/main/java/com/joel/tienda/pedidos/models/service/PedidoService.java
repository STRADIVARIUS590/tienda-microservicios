package com.joel.tienda.pedidos.models.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joel.tienda.commons.models.entities.Client;
import com.joel.tienda.commons.models.entities.Pedido;
import com.joel.tienda.commons.models.entities.PedidoProducto;
import com.joel.tienda.commons.models.entities.Producto;
import com.joel.tienda.commons.services.CommonService;
import com.joel.tienda.pedidos.Repositories.IPedidoRepository;
import com.joel.tienda.pedidos.clients.ProductoClient;
import com.joel.tienda.pedidos.dto.PedidoDTO;
import com.joel.tienda.pedidos.dto.PedidoProductoDTO;
import com.joel.tienda.pedidos.mappers.PedidoMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class PedidoService extends CommonService<PedidoDTO, Pedido, PedidoMapper, IPedidoRepository>
implements IPedidoService{

	@Autowired
    private ProductoClient productoClient; // Usar Feign Client en vez de repositorio
	
	 @PersistenceContext
	    private EntityManager entityManager; // Inyección del EntityManager

	@Override
    @Transactional(readOnly = true)
    public List<PedidoDTO> listar() {
        List<PedidoDTO> lista = new ArrayList<>();
        repository.findAll()
            .stream()
            .filter(p -> !p.getEstado().equalsIgnoreCase("CANCELADO")) // No mostrar cancelados
            .forEach(pedido -> lista.add(mapper.toDto(pedido)));
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PedidoDTO> obtenerPorId(Long id) {
        Optional<Pedido> opt = repository.findById(id);
        if (opt.isPresent() && !opt.get().getEstado().equalsIgnoreCase("CANCELADO")) {
            return opt.map(mapper::toDto);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public PedidoDTO insertar(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        Client client = new Client();
        client.setId(dto.getIdCliente());
        pedido.setCliente(client);
        pedido.setEstado("PENDIENTE");

        double total = 0;
        List<PedidoProducto> productos = new ArrayList<>();
        for (PedidoProductoDTO prodDTO : dto.getProductos()) {
            Producto producto = productoClient.obtenerProductoPorId(prodDTO.getIdProducto());

            // Asegúrate de que el producto sea válido
            if (producto == null || producto.getId() == null) {
                throw new IllegalStateException("Producto no encontrado con ID: " + prodDTO.getIdProducto());
            }

            // Si el producto está gestionado por Hibernate, lo obtenemos mediante entityManager
            producto = entityManager.find(Producto.class, producto.getId());
            if (producto == null) {
                throw new IllegalStateException("Producto no encontrado en la base de datos.");
            }

            PedidoProducto pp = new PedidoProducto();
            pp.setProducto(producto);
            pp.setCantidad(prodDTO.getCantidad());
            pp.setPedido(pedido);

            productos.add(pp);

            // Sumamos el precio * cantidad al total
            total += producto.getPrecio() * prodDTO.getCantidad();
        }

        pedido.setProductos(productos);
        pedido.setTotal(total);

        Pedido saved = repository.save(pedido);
        return mapper.toDto(saved);
    }

    @Override
    @Transactional
    public PedidoDTO editar(PedidoDTO dto, Long id) {
        Optional<Pedido> opt = repository.findById(id);
        if (opt.isPresent()) {
            Pedido pedido = opt.get();

            // Validamos si el pedido ya está entregado o cancelado
            if (pedido.getEstado().equalsIgnoreCase("ENTREGADO") || pedido.getEstado().equalsIgnoreCase("CANCELADO")) {
                throw new IllegalStateException("El pedido ya fue entregado o cancelado y no puede ser editado.");
            }

            // Solo permitir cambiar el estado
            pedido.setEstado(dto.getEstado());
            Pedido actualizado = repository.save(pedido);
            return mapper.toDto(actualizado);
        }
        return null;
    }

    @Override
    @Transactional
    public PedidoDTO eliminar(Long id) {
        Optional<Pedido> opt = repository.findById(id);
        if (opt.isPresent()) {
            Pedido pedido = opt.get();

            // Validamos si ya está cancelado
            if (pedido.getEstado().equalsIgnoreCase("CANCELADO")) {
                throw new IllegalStateException("El pedido ya está cancelado.");
            }

            // Cambiar a estado cancelado
            pedido.setEstado("CANCELADO");
            Pedido cancelado = repository.save(pedido);
            return mapper.toDto(cancelado);
        }
        return null;
    }


}
