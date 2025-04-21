package com.cesar.msproducts.Repository;

import com.joel.tienda.commons.models.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Producto, Long> {
}
