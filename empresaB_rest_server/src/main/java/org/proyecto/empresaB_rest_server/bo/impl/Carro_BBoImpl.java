package org.proyecto.empresaB_rest_server.bo.impl;

import java.util.List;

import org.proyecto.empresaB_rest_server.bo.Carro_BBo;
import org.proyecto.empresaB_rest_server.dao.Carro_BDao;
import org.proyecto.empresaB_rest_server.model.Carro_B;
import org.proyecto.empresaB_rest_server.model.Producto_BSeleccionado;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("carro_BBo")//le decimos a Spring que tiene que manejar este bean
public class Carro_BBoImpl implements Carro_BBo{
	
	@Autowired
	Carro_BDao carro_BDao;

	public void setCarro_BDao(Carro_BDao carro_BDao) {
		this.carro_BDao = carro_BDao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Carro_B carro_B) {
		this.carro_BDao.save(carro_B);
		
	}

	public void update(Carro_B carro_B) {
		carro_BDao.update(carro_B);
		
	}

	public void delete(Carro_B carro_B) {
		carro_BDao.delete(carro_B);
		
	}

	public Carro_B findByCarro_BIdCarro_b(String Carro_BIdCarro_b) {
		
		return carro_BDao.findByCarro_BIdCarro_b(Carro_BIdCarro_b);
	}

	public List<Producto_BSeleccionado> findByTodosCarro_BIdCarro_b(String carro_BIdCarro_b){
		
		return carro_BDao.findByTodosCarro_BIdCarro_b(carro_BIdCarro_b);
	}
	
	public List<Carro_B>findByTodosCarro_BIdCliente_b(String carro_BIdCliente_b){
		
		return carro_BDao.findByTodosCarro_BIdCliente_b(carro_BIdCliente_b);
	}
	
	public List<Carro_B> findAll (){
		return carro_BDao.findAll();
	}

}
