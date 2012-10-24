package org.proyecto.empresaB_rest_server.bo.impl;

import java.util.List;

import org.proyecto.empresaB_rest_server.bo.Cliente_BBo;
import org.proyecto.empresaB_rest_server.dao.Cliente_BDao;
import org.proyecto.empresaB_rest_server.model.Cliente_B;
import org.proyecto.empresaB_rest_server.model.Usuario_B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("cliente_BBo")//le decimos a Spring que tiene que manejar este bean
public class Cliente_BBoImpl implements Cliente_BBo{
	
	@Autowired
	Cliente_BDao cliente_BDao;

	public void setCliente_BDao(Cliente_BDao cliente_BDao) {
		this.cliente_BDao = cliente_BDao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Cliente_B cliente_B) {
		this.cliente_BDao.save(cliente_B);
		
	}

	public void update(Cliente_B cliente_B) {
		cliente_BDao.update(cliente_B);
		
	}

	public void delete(Cliente_B cliente_B) {
		cliente_BDao.delete(cliente_B);
		
	}

	public Cliente_B findByCliente_BIdCliente_b(String Cliente_BIdCliente_b) {
		
		return cliente_BDao.findByCliente_BIdCliente_b(Cliente_BIdCliente_b);
	}

	public Usuario_B findByCliente_B_login_usuario_b(String cliente_B_login_usuario_b) {
		
		return cliente_BDao.findByCliente_B_login_usuario_b(cliente_B_login_usuario_b);
	}
	
	public List<Cliente_B> findAll (){
		return cliente_BDao.findAll();
	}

}

