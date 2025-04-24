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
import com.joel.tienda.pedidos.repositories.IPedidoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.joel.tienda.pedidos.clients.ProductoClient;
import com.joel.tienda.pedidos.dto.PedidoDTO;
import com.joel.tienda.pedidos.dto.PedidoProductoDTO;
import com.joel.tienda.pedidos.mappers.PedidoMapper;

@Service
public class PedidoService extends CommonService<PedidoDTO, Pedido, PedidoMapper, IPedidoRepository>
implements IPedidoService{

	@Autowired
    private ProductoClient productoClient; // Usar Feign Client en vez de repositorio


    @PersistenceContext
    private EntityManager entityManager;
 
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
        Pedido pedido = repository.findByClienteIdAndEstado(dto.getIdCliente(), "PENDIENTE")
                .orElseGet(() -> {
                    Pedido nuevoPedido = new Pedido();
                    Client client = new Client();
                    client.setId(dto.getIdCliente());
                    nuevoPedido.setCliente(client);
                    nuevoPedido.setEstado("PENDIENTE");
                    nuevoPedido.setProductos(new ArrayList<>());
                    nuevoPedido.setTotal(0.0);
                    return nuevoPedido;
                });

        for (PedidoProductoDTO prodDTO : dto.getProductos()) {
            Producto productoData = productoClient.obtenerProductoPorId(prodDTO.getIdProducto());

            if (productoData == null || productoData.getId() == null) {
                throw new IllegalStateException("Producto no encontrado con ID: " + prodDTO.getIdProducto());
            }

            Producto productoReference = entityManager.getReference(Producto.class, productoData.getId());

            PedidoProducto existente = pedido.getProductos().stream()
                    .filter(pp -> pp.getProducto().getId().equals(productoReference.getId()))
                    .findFirst()
                    .orElse(null);

            if (existente != null) {
                existente.setCantidad(existente.getCantidad() + prodDTO.getCantidad());
            } else {
                PedidoProducto nuevoPP = new PedidoProducto();
                nuevoPP.setProducto(productoReference);
                nuevoPP.setCantidad(prodDTO.getCantidad());
                nuevoPP.setPedido(pedido);
                pedido.getProductos().add(nuevoPP);
            }
        }

        double total = pedido.getProductos().stream()
                .mapToDouble(pp -> {
                    Double precio = pp.getProducto().getPrecio();
                    return precio != null ? precio * pp.getCantidad() : 0.0;
                })
                .sum();
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
