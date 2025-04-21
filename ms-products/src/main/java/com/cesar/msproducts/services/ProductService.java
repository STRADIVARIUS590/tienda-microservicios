package com.cesar.msproducts.services;

import com.cesar.msproducts.Repository.IProductRepository;
import com.cesar.msproducts.dto.ProductDTO;
import com.cesar.msproducts.mappers.productMapper;
import com.joel.tienda.commons.models.entities.Producto;
import com.joel.tienda.commons.services.CommonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService extends CommonService<ProductDTO, Producto, productMapper, IProductRepository> implements IProductService {

    @Override
    public List<ProductDTO> listar() {
        List<ProductDTO> dtos = new ArrayList<>();
        this.repository.findAll().forEach(p -> {
            dtos.add(this.mapper.toDto(p));
        });
        return dtos;
    }

    @Override
    public Optional<ProductDTO> obtenerPorId(Long id) {
        Optional<Producto> opt = this.repository.findById(id);
        if(opt.isPresent()) {
            return Optional.of(this.mapper.toDto(opt.get()));
        }
        return Optional.empty();
    }

    @Override
    public ProductDTO insertar(ProductDTO dto) {
        return this.mapper.toDto(this.repository.save(this.mapper.toEntity(dto)));
    }

    @Override
    public ProductDTO editar(ProductDTO dto, Long id ) {
        Optional<Producto> opt =  this.repository.findById(id);
        if(opt.isPresent()) {
            dto.setId(id);
            return this.mapper.toDto(this.repository.save(this.mapper.toEntity(dto)));
        }
        return null;
    }

    @Override
    public ProductDTO eliminar(Long id) {
        Optional<Producto> a = this.repository.findById(id);

        if(a.isPresent()) {
            this.repository.deleteById(id);
            return  this.mapper.toDto(a.get());
        }
        return null;
    }

}
