package com.joel.tienda.clientes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.joel.tienda.commons.models.entities.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.deletetAt IS NULL")
    public List<Client> findAllUndeleted();
}
