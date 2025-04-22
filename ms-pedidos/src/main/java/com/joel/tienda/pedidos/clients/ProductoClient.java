package com.joel.tienda.pedidos.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.joel.tienda.commons.models.entities.Producto;

@FeignClient(name = "ms-products")
public interface ProductoClient {
	
	@GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id);

}
