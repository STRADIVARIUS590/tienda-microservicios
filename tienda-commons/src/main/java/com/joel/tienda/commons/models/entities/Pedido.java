package com.joel.tienda.commons.models.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PEDIDO")
public class Pedido {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_SEQ")
    @SequenceGenerator(name = "PEDIDO_SEQ", sequenceName = "PEDIDO_SEQ", allocationSize = 1)
    @Column(name = "ID_PEDIDO")
    private Long id;

    @NotNull
    @Column(name = "ID_CLIENTE", nullable = false)
    private Long idCliente;

    @DecimalMin(value = "0.0", inclusive = true)
    @Column(name = "TOTAL", nullable = false)
    private Double total;

    @Column(name = "FECHA_CREACION", nullable = false)
    private LocalDate fechaCreacion = LocalDate.now();

    @Column(name = "ESTADO", nullable = false)
    private String estado = "PENDIENTE";

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoProducto> productos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<PedidoProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<PedidoProducto> productos) {
		this.productos = productos;
	}
    
}
