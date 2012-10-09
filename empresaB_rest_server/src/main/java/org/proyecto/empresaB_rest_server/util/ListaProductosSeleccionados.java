package org.proyecto.empresaB_rest_server.util;

import java.math.BigDecimal;

public class ListaProductosSeleccionados {
	
	String nombreProducto;
	Integer idCarro;
	Integer cantidad;
	Integer idProductoSeleccionado;
	Integer idproducto_b;
	BigDecimal precio_b;
	
	
	
	
	
	
	
	public ListaProductosSeleccionados() {

	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public Integer getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getIdProductoSeleccionado() {
		return idProductoSeleccionado;
	}
	public void setIdProductoSeleccionado(Integer idProductoSeleccionado) {
		this.idProductoSeleccionado = idProductoSeleccionado;
	}
	public Integer getIdproducto_b() {
		return idproducto_b;
	}
	public void setIdproducto_b(Integer idproducto_b) {
		this.idproducto_b = idproducto_b;
	}
	public BigDecimal getPrecio_b() {
		return precio_b;
	}
	public void setPrecio_b(BigDecimal precio_b) {
		this.precio_b = precio_b;
	}
	

	
}
