package com.joel.tienda.clientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.joel.tienda.commons.model.entity"}) // Escanear entidades de otro microservicio
public class MsClientesApplication {



	public static void main(String[] args) {
		SpringApplication.run(MsClientesApplication.class, args);
	}

}
