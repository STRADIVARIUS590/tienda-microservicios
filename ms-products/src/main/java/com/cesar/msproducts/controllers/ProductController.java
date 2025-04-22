package com.cesar.msproducts.controllers;

import com.cesar.msproducts.dto.ProductDTO;
import com.cesar.msproducts.services.ProductService;
import com.joel.tienda.commons.controllers.CommonController;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/productos")
public class ProductController extends CommonController<ProductDTO, ProductService> {

    public ProductController(ProductService service) {
        super(service);
    }
}
