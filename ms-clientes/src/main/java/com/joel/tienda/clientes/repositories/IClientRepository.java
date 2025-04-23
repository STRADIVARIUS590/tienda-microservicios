package com.joel.tienda.clientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joel.tienda.commons.models.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {}
