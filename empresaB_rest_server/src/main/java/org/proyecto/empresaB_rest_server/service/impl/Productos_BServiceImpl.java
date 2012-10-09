package org.proyecto.empresaB_rest_server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.proyecto.empresaB_rest_server.bo.Producto_BBo;
import org.proyecto.empresaB_rest_server.dao.Producto_BDao;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.service.Productos_BService;
import org.proyecto.empresaB_rest_server.util.CustomHibernateDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;





@Service("productoService")
/*@Transactional(propagation=Propagation.SUPPORTS, readOnly=false)*/
/*@Transactional(propagation=Propagation.SUPPORTS)*/

public class Productos_BServiceImpl implements Productos_BService{
	@Autowired
	private Producto_BBo producto_BBo;
	
	
	
	@Transactional
	public List<Producto_B> getProductos_B(){
		List <Producto_B> list=producto_BBo.findAll();
		return list;
		
	}
	@Transactional
	public void update(Producto_B producto_B) {
		producto_BBo.update(producto_B);
	}
	@Transactional
	public void save(Producto_B producto_B) {
		producto_BBo.save(producto_B);
	}
	public Producto_B findByProducto_BIdProducto_b(String Producto_BIdProducto_b){
		return producto_BBo.findByProducto_BIdProducto_b(Producto_BIdProducto_b);
	}
	public void delete(Producto_B producto_B) {
		producto_BBo.delete(producto_B);
		
	}
	
}