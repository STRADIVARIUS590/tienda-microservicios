package com.joel.tienda.pedidos.dto;

import java.util.Date;
import java.util.List;

public class PedidoDTO {

	private Long id;

    private Long idCliente;

    private Double total;

    private Date fechaCreacion;

    private String estado;

    private List<PedidoProductoDTO> productos;

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

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<PedidoProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(List<PedidoProductoDTO> productos) {
		this.productos = productos;
	}

   
}
