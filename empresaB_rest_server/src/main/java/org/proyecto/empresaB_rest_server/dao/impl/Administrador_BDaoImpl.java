package org.proyecto.empresaB_rest_server.dao.impl;

import org.proyecto.empresaB_rest_server.dao.Administrador_BDao;
import org.proyecto.empresaB_rest_server.model.Administrador_B;
import org.proyecto.empresaB_rest_server.model.Usuario_B;
import org.proyecto.empresaB_rest_server.util.CustomHibernateDaoSupport;

import java.util.List;

import org.springframework.stereotype.Repository;


//@Repository("Administrador_BDao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("administrador_BDao")
public class Administrador_BDaoImpl extends CustomHibernateDaoSupport implements Administrador_BDao {

	public void save(Administrador_B administrador_B) {
		getHibernateTemplate().save(administrador_B);
	
	}



	public void update(Administrador_B administrador_B) {
		//getHibernateTemplate().update(administrador_B);
		getHibernateTemplate().merge(administrador_B);
		
	}

	public void delete(Administrador_B administrador_B) {
		getHibernateTemplate().delete(administrador_B);
		
	}

	@SuppressWarnings("unchecked")
	public Administrador_B findByAdministrador_BIdAdministrador_b(String administrador_BIdAdministrador_b) {
		List<Administrador_B> list = getHibernateTemplate().find(
                     "from Administrador_B where idusuarios_b = ?",Integer.parseInt(administrador_BIdAdministrador_b));
		return (Administrador_B)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Usuario_B findByAdministrador_B_login_usuario_b(String administrador_B_login_usuario_b) {
/*		List <Administrador_B> list = getHibernateTemplate().find(
                "from Administrador_B where login_usuario_b = ?",administrador_B_login_usuario_b);
		return (Administrador_B)list.get(0);*/
		
		List <Usuario_B> list= getHibernateTemplate().find(
 				"from Usuario_B  where login_usuario_b = ?",administrador_B_login_usuario_b);
		System.out.println("tamaño lista encontrada: "+list.size());
		if(list.isEmpty())
			return null;
		return (Usuario_B)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Administrador_B> findAll (){
		List <Administrador_B> list = getHibernateTemplate().find("from Administrador_B");
		return list;
	}

}
