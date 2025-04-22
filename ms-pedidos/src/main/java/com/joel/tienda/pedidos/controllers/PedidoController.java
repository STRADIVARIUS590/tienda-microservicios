package com.joel.tienda.pedidos.controllers;


import org.springframework.web.bind.annotation.RestController;

import com.joel.tienda.commons.controllers.CommonController;
import com.joel.tienda.pedidos.dto.PedidoDTO;
import com.joel.tienda.pedidos.models.service.PedidoService;

@RestController
//@RequestMapping("/api/pedidos") 
public class PedidoController extends CommonController<PedidoDTO, PedidoService>{

    public PedidoController(PedidoService service) {
        super(service);
        //TODO Auto-generated constructor stub
    }

  
    
}
