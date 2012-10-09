package org.proyecto.empresaB_rest_server.util;

import java.util.Date;
import java.util.Set;

public class ListaPedidos implements Comparable <ListaPedidos> {
	
	Integer IdCliente;
	Integer IdCarro;
	String LoginCliente;
	Boolean pagado;
	Boolean enviado;
	Date fechaPedido;
	Set<ListaProductosSeleccionados> listaProductosSeleccionados;
	
	//ordenamos la lista por IdCarro
	  @Override
	 public int compareTo(ListaPedidos listaPedidos){
		  return this.IdCarro.compareTo(listaPedidos.IdCarro);
	    }
	
	public ListaPedidos() {
	
	}

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

	
	
	public String getLoginCliente() {
		return LoginCliente;
	}

	public void setLoginCliente(String loginCliente) {
		LoginCliente = loginCliente;
	}

	public Boolean getPagado() {
		return pagado;
	}

	public void setPagado(Boolean pagado) {
		this.pagado = pagado;
	}

	public Boolean getEnviado() {
		return enviado;
	}

	public void setEnviado(Boolean enviado) {
		this.enviado = enviado;
	}

	public Set<ListaProductosSeleccionados> getListaProductosSeleccionados() {
		return listaProductosSeleccionados;
	}

	public void setListaProductosSeleccionados(
			Set<ListaProductosSeleccionados> listaProductosSeleccionados) {
		this.listaProductosSeleccionados = listaProductosSeleccionados;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public Integer getIdCarro() {
		return IdCarro;
	}

	public void setIdCarro(Integer idCarro) {
		IdCarro = idCarro;
	}




	

}
