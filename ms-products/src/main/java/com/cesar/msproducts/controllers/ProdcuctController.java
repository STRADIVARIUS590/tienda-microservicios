package com.cesar.msproducts.controllers;

import com.cesar.msproducts.dto.ProductDTO;
import com.cesar.msproducts.services.ProductService;
import com.joel.tienda.commons.controllers.CommonController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/productos")
public class ProdcuctController extends CommonController<ProductDTO, ProductService> {

    public ProdcuctController(ProductService service) {
        super(service);
    }
}
