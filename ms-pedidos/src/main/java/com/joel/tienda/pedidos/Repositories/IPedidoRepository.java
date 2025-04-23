package com.joel.tienda.pedidos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joel.tienda.commons.models.entities.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido, Long> {
	
	Optional<Pedido> findByClienteIdAndEstado(Long idCliente, String estado);
}
