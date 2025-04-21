package com.joel.tienda.commons.models.entities;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(idPedido, idProducto);
	}
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoProductoId)) return false;
        PedidoProductoId that = (PedidoProductoId) o;
        return Objects.equals(idPedido, that.idPedido) &&
               Objects.equals(idProducto, that.idProducto);
    }

}
