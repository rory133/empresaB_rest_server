package org.proyecto.empresaB_rest_server.dao.impl;


import org.hibernate.criterion.Restrictions;
import org.proyecto.empresaB_rest_server.dao.Cliente_BDao;
import org.proyecto.empresaB_rest_server.model.Cliente_B;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.model.Usuario_B;
import org.proyecto.empresaB_rest_server.util.CustomHibernateDaoSupport;

import java.util.List;

import javax.validation.Validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


//@Repository("Cliente_BDao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("cliente_BDao")
public class Cliente_BDaoImpl extends CustomHibernateDaoSupport implements Cliente_BDao {
	
	



	public void save(Cliente_B cliente_B) {
		getHibernateTemplate().save(cliente_B);
	
	}



	public void update(Cliente_B cliente_B) {
		
		
		//getHibernateTemplate().update(cliente_B);
		getHibernateTemplate().merge(cliente_B);
		
	}

	public void delete(Cliente_B cliente_B) {
		getHibernateTemplate().delete(cliente_B);
		
	}

	@SuppressWarnings("unchecked")
	public Cliente_B findByCliente_BIdCliente_b(String cliente_BIdCliente_b) {
		List<Cliente_B> list = getHibernateTemplate().find(
                     "from Cliente_B where idusuarios_b= ?",Integer.parseInt(cliente_BIdCliente_b));
		return (Cliente_B)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public Usuario_B findByCliente_B_login_usuario_b(String cliente_B_login_usuario_b) {
		System.out.println("login usuario pasado: "+cliente_B_login_usuario_b);
		
		//List<Cliente_B> list = this.getSessionFactory().getCurrentSession().createCriteria (Cliente_B.class ).add(Restrictions.eq("login_usuario_b",cliente_B_login_usuario_b)).list();
		//return (Producto_B)list.get(0);
		
		//List<Cliente_B> list = this.getSessionFactory().getCurrentSession().createCriteria (Cliente_B.class ).add(Restrictions.eq("login_usuario_b",cliente_B_login_usuario_b)).list();
		
		/*List <Cliente_B> list = getHibernateTemplate().find(
               "from Cliente_B where login_usuario_b = ?",cliente_B_login_usuario_b);*/
		
		List <Usuario_B> list= getHibernateTemplate().find(
	 				"from Usuario_B  where login_usuario_b = ?",cliente_B_login_usuario_b);
		System.out.println("tamaño lista encontrada: "+list.size());
		if(list.isEmpty())
			return null;
		return (Usuario_B)list.get(0);
		
	}

	@SuppressWarnings("unchecked")
	public List<Cliente_B> findAll (){
		List <Cliente_B> list = getHibernateTemplate().find("from Cliente_B");
		return list;
	}

}