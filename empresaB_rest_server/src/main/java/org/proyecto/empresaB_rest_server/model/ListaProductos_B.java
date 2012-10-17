package org.proyecto.empresaB_rest_server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "productos_b")
public class ListaProductos_B {
	private List<Producto_B> dataProducto;

	public List<Producto_B> getDataProducto() {
		return dataProducto;
	}

	public void setDataProducto(List<Producto_B> dataProducto) {
		this.dataProducto = dataProducto;
	}

	
}
