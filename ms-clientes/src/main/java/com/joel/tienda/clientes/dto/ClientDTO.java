package com.joel.tienda.clientes.dto;

import java.time.LocalDate;

public class ClientDTO {

    Long id;
    String name;
    String lastName;
    String email;
    String phone;
    String address;
    LocalDate deletetAt;


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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDeletetAt() {
        return deletetAt;
    }

    public void setDeletetAt(LocalDate deletetAt) {
        this.deletetAt = deletetAt;
    }
}
