package com.joel.tienda.commons.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "PEDIDO_PRODUCTO")
public class PedidoProducto {
	
	@EmbeddedId
	 private PedidoProductoId id = new PedidoProductoId();

	 @ManyToOne
	 @MapsId("idPedido")
	 @JoinColumn(name = "ID_PEDIDO")
	 private Pedido pedido;

	 @ManyToOne
	 @MapsId("idProducto")
	 @JoinColumn(name = "ID_PRODUCTO")
	 private Producto producto;

	 @Min(1)
	 @Column(name = "CANTIDAD", nullable = false)
	 private Integer cantidad;

	public PedidoProductoId getId() {
		return id;
	}

	public void setId(PedidoProductoId id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	 
}
