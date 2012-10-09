package org.proyecto.empresaB_rest_server.bo;

import java.util.List;

import org.proyecto.empresaB_rest_server.model.Producto_B;



public interface Producto_BBo {
	
	void save(Producto_B producto_B);
	
	void update(Producto_B producto_B);
	
	void delete(Producto_B producto_B);
	
	Producto_B findByProducto_BIdProducto_b(String Producto_BIdProducto_b);
	
	Producto_B findByProducto_B_nombre(String producto_B_nombre);
	
	List<Producto_B> findAll ();

}
