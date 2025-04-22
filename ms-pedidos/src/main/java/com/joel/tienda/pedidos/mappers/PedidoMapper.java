package com.joel.tienda.pedidos.mappers;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.joel.tienda.commons.mappers.CommonMapper;
import com.joel.tienda.commons.models.entities.Pedido;
import com.joel.tienda.pedidos.dto.PedidoDTO;
import com.joel.tienda.pedidos.dto.PedidoProductoDTO;
import com.joel.tienda.pedidos.repositories.IPedidoRepository;
@Component
public class PedidoMapper extends CommonMapper<PedidoDTO, Pedido, IPedidoRepository> {  
    
    @Override
    public PedidoDTO toDto(Pedido entity) {
        if (entity == null) return null;
        PedidoDTO dto = new PedidoDTO();
        dto.setId(entity.getIdPedido());
        dto.setIdCliente(entity.getCliente().getId());
        dto.setTotal(entity.getTotal());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setEstado(entity.getEstado());
        if (entity.getProductos() != null) {
            dto.setProductos(entity.getProductos().stream().map(pp -> {
                PedidoProductoDTO ppDTO = new PedidoProductoDTO();
                ppDTO.setIdProducto(pp.getProducto().getId());
                ppDTO.setCantidad(pp.getCantidad());
                return ppDTO;
            }).collect(Collectors.toList()));
        }
        return dto;
    }

    @Override
    public Pedido toEntity(PedidoDTO dto) {
        if (dto == null) return null;
        Pedido entity = new Pedido();
        entity.setIdPedido(dto.getId());
        // cliente se setea en el servicio
        entity.setTotal(dto.getTotal());
        entity.setFechaCreacion(dto.getFechaCreacion());
        entity.setEstado(dto.getEstado());
        return entity;
    }
    
}
