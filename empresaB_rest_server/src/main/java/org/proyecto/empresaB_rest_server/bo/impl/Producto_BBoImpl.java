package org.proyecto.empresaB_rest_server.bo.impl;

import java.util.List;


import org.proyecto.empresaB_rest_server.bo.Producto_BBo;
import org.proyecto.empresaB_rest_server.dao.Producto_BDao;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository("producto_BBo")//le decimos a Spring que tiene que manejar este bean

public class Producto_BBoImpl implements Producto_BBo{
	
	@Autowired
	Producto_BDao producto_BDao;


	
	public void setProducto_BDao(Producto_BDao producto_BDao) {
		this.producto_BDao = producto_BDao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Producto_B producto_B) {
		this.producto_BDao.save(producto_B);
		
	}

	public void update(Producto_B producto_B) {
		producto_BDao.update(producto_B);
		
	}

	public void delete(Producto_B producto_B) {
		producto_BDao.delete(producto_B);
		
	}

	public Producto_B findByProducto_BIdProducto_b(String Producto_BIdProducto_b) {
		
		return producto_BDao.findByProducto_BIdProducto_b(Producto_BIdProducto_b);
	}

	public Producto_B findByProducto_B_nombre(String producto_B_nombre) {
		
		return producto_BDao.findByProducto_B_nombre(producto_B_nombre);
	}

	public List<Producto_B> findAll (){
		return producto_BDao.findAll();
	}

}
