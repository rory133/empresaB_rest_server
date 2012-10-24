package org.proyecto.empresaB_rest_server.bo.impl;

import java.util.List;

import org.proyecto.empresaB_rest_server.bo.Producto_BSeleccionadoBo;
import org.proyecto.empresaB_rest_server.dao.Producto_BSeleccionadoDao;
import org.proyecto.empresaB_rest_server.model.Producto_BSeleccionado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("producto_BSeleccionadoBo")//le decimos a Spring que tiene que manejar este bean
public class Producto_BSeleccionadoBoImpl implements Producto_BSeleccionadoBo{
	
	@Autowired
	Producto_BSeleccionadoDao producto_BSeleccionadoDao;

	public void setProducto_BSeleccionadoDao(Producto_BSeleccionadoDao producto_BSeleccionadoDao) {
		this.producto_BSeleccionadoDao = producto_BSeleccionadoDao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Producto_BSeleccionado producto_BSeleccionado) {
		this.producto_BSeleccionadoDao.save(producto_BSeleccionado);
		
	}

	public void update(Producto_BSeleccionado producto_BSeleccionado) {
		producto_BSeleccionadoDao.update(producto_BSeleccionado);
		
	}

	public void delete(Producto_BSeleccionado producto_BSeleccionado) {
		producto_BSeleccionadoDao.delete(producto_BSeleccionado);
		
	}

	public Producto_BSeleccionado findByProducto_BSeleccionadoIdProducto_b(String Producto_BSeleccionadoIdProducto_b) {
		
		return producto_BSeleccionadoDao.findByProducto_BSeleccionadoIdProducto_b(Producto_BSeleccionadoIdProducto_b);
	}

	public Producto_BSeleccionado findByProducto_BSeleccionado_nombre(String producto_BSeleccionado_nombre) {
		
		return producto_BSeleccionadoDao.findByProducto_BSeleccionado_nombre(producto_BSeleccionado_nombre);
	}
	
	public List<Producto_BSeleccionado> findAll (){
		return producto_BSeleccionadoDao.findAll();
	}

}