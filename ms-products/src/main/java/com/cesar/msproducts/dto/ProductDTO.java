package com.cesar.msproducts.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {

    Long id;
    @NotBlank(message = "El nombre es obligatorio")
    String name;
    @NotBlank(message = "La descripción es obligatoria")
    String description;
    @DecimalMin(value = "0.0", inclusive = true, message = "El precio no puede ser negativo")
    @NotNull
    Double price;
    @Min(value=0, message = "El stock no puede ser negativo")
    @NotNull
    Integer stock;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
