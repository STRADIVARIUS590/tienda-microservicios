package com.joel.tienda.clientes.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import com.joel.tienda.clientes.dto.ClientDTO;
import com.joel.tienda.clientes.models.service.ClientService;
import com.joel.tienda.commons.controllers.CommonController;
@RestController
// @RequestMapping("/api/clientes")
public class ClientController extends CommonController<ClientDTO, ClientService>{

    public ClientController(ClientService service) {
        super(service);
        //TODO Auto-generated constructor stub
    }
    
}
