package com.joel.tienda.commons.models.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class PedidoProductoId {
	private Long idPedido;
    private Long idProducto;
    
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

}
