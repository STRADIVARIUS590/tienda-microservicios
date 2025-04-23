package com.cesar.msproducts.mappers;
import com.cesar.msproducts.repository.IProductRepository;
import com.cesar.msproducts.dto.ProductDTO;
import com.joel.tienda.commons.mappers.CommonMapper;
import com.joel.tienda.commons.models.entities.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends CommonMapper<ProductDTO, Producto, IProductRepository> {

    @Override
    public ProductDTO toDto(Producto entity) {
        if (entity == null) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescripcion());
        dto.setPrice(entity.getPrecio());
        dto.setStock(entity.getStock());
        return dto;
    }

    @Override
    public Producto toEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        Producto entity = new Producto();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescripcion(dto.getDescription());
        entity.setPrecio(dto.getPrice());
        entity.setStock(dto.getStock());
        return entity;
    }

}
