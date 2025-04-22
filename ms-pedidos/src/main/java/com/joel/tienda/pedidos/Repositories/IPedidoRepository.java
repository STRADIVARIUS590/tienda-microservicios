package com.joel.tienda.pedidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joel.tienda.commons.models.entities.Client;
import com.joel.tienda.commons.models.entities.Pedido;

public interface IPedidoRepository extends JpaRepository<Pedido, Long> {}
