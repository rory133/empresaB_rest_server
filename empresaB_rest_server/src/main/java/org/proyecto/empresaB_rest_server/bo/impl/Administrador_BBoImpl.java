package org.proyecto.empresaB_rest_server.bo.impl;


import java.util.List;

import org.proyecto.empresaB_rest_server.bo.Administrador_BBo;
import org.proyecto.empresaB_rest_server.dao.Administrador_BDao;
import org.proyecto.empresaB_rest_server.model.Administrador_B;
import org.proyecto.empresaB_rest_server.model.Usuario_B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service("administrador_BBo")//le decimos a Spring que tiene que manejar este bean
public class Administrador_BBoImpl implements Administrador_BBo{
	
	@Autowired
	Administrador_BDao administrador_BDao;

	public void setAdministrador_BDao(Administrador_BDao administrador_BDao) {
		this.administrador_BDao = administrador_BDao;
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
	public void save(Administrador_B administrador_B) {
		this.administrador_BDao.save(administrador_B);
		
	}

	public void update(Administrador_B administrador_B) {
		administrador_BDao.update(administrador_B);
		
	}

	public void delete(Administrador_B administrador_B) {
		administrador_BDao.delete(administrador_B);
		
	}

	public Administrador_B findByAdministrador_BIdAdministrador_b(String Administrador_BIdAdministrador_b) {
		
		return administrador_BDao.findByAdministrador_BIdAdministrador_b(Administrador_BIdAdministrador_b);
	}

	public Usuario_B findByAdministrador_B_login_usuario_b(String administrador_B_login_usuario_b) {
		
		return administrador_BDao.findByAdministrador_B_login_usuario_b(administrador_B_login_usuario_b);
	}
	
	public List<Administrador_B> findAll (){
		return administrador_BDao.findAll();
	}

}
