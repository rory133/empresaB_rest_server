package org.proyecto.empresaB_rest_server.service;

import java.util.List;

import org.proyecto.empresaB_rest_server.model.Producto_B;



public interface Productos_BService {
	
	public List<Producto_B> getProductos_B();
	public void save(Producto_B producto_B);
	public Producto_B findByProducto_BIdProducto_b(String Producto_BIdProducto_b);
	public void update(Producto_B producto_B);
	void delete(Producto_B producto_B);

}
