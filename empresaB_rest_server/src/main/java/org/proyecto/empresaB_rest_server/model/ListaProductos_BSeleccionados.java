package org.proyecto.empresaB_rest_server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "listaProductos_bSeleccionados")
public class ListaProductos_BSeleccionados {
	private List<Producto_BSeleccionado> dataProductoBSeleccionado;

	public List<Producto_BSeleccionado> getDataProductoBSeleccionado() {
		return dataProductoBSeleccionado;
	}

	public void setDataProductoBSeleccionado(
			List<Producto_BSeleccionado> dataProductoBSeleccionado) {
		this.dataProductoBSeleccionado = dataProductoBSeleccionado;
	}

	
	
	
}
