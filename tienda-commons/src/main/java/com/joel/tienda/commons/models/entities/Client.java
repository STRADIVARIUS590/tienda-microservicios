package com.joel.tienda.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "CLIENTE")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    @SequenceGenerator(name = "CLIENTE_SEQ", sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    @Column(name = "ID")
    String id;
	
	@NotBlank
    @Column(name = "NOMBRE", nullable = false)
    String name;
	
	@NotBlank
    @Column(name = "APELLIDO", nullable = false)
    String lastName;
	
	@Email
    @NotBlank
    @Column(name = "EMAIL", nullable = false, unique = true)
    String email;
	
	@NotBlank
    @Pattern(regexp = "\\d{10}")
    @Column(name = "TELEFONO", nullable = false, unique = true)
    String phone;
	
	@Size(max = 100)
    @Column(name = "DIRECCION")
    String address;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
