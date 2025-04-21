package com.joel.tienda.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TiendaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaServerApplication.class, args);
	}

}
