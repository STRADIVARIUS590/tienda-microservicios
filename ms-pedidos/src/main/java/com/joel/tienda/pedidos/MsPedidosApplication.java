package com.joel.tienda.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EntityScan({"com.joel.tienda.commons.models.entities"}) // Escanear entidades de otro microservicio
public class MsPedidosApplication {



	public static void main(String[] args) {
		SpringApplication.run(MsPedidosApplication.class, args);
	}

}
