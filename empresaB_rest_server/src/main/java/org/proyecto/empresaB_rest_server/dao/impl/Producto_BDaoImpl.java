package org.proyecto.empresaB_rest_server.dao.impl;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


import org.proyecto.empresaB_rest_server.dao.Producto_BDao;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.util.CustomHibernateDaoSupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("producto_BDao")
public class Producto_BDaoImpl extends CustomHibernateDaoSupport implements Producto_BDao {

	
	 @Autowired
	 private SessionFactory sessionFactory;
	
	
	public void save(Producto_B producto_B) {
		//getHibernateTemplate().save(producto_B);
		//this.getSessionFactory().getCurrentSession().save(Producto_B.class);
		//this.getSessionFactory().getCurrentSession().save(producto_B);
		System.out.println("en save productoB");
		this.sessionFactory.getCurrentSession().save(producto_B);
	
	}



	public void update(Producto_B producto_B) {
		getHibernateTemplate().update(producto_B);
		System.out.println("en update productoB");
		System.out.println("nombre productoB productoB: "+ producto_B.getNombre_productoB());
		//this.sessionFactory.getCurrentSession().update(producto_B);
		//this.getSessionFactory().getCurrentSession().update(producto_B);
	}

	public void delete(Producto_B producto_B) {
		getHibernateTemplate().delete(producto_B);
		
	}
	@SuppressWarnings("unchecked")
	public Producto_B findByProducto_BIdProducto_b(String producto_BIdProducto_b) {
		 
/*		List<Producto_B> list = getHibernateTemplate().find(
				"from Producto_B where IDPRODUCTOB = ?",Integer.parseInt(producto_BIdProducto_b)); 
		return (Producto_B)list.get(0);*/
		
		List<Producto_B> list = this.getSessionFactory().getCurrentSession().createCriteria (Producto_B.class ).add(Restrictions.eq("idproductob",Integer.parseInt(producto_BIdProducto_b))).list();
		return (Producto_B)list.get(0);
		
		
	}
	
	@SuppressWarnings("unchecked")
	public Producto_B findByProducto_B_nombre(String producto_B_nombre) {
		List <Producto_B> list = getHibernateTemplate().find(
                "from Producto_B where NOMBRE_PRODUCTOB = ?",producto_B_nombre);
		return (Producto_B)list.get(0);
	}

	@SuppressWarnings("unchecked")
	public List<Producto_B> findAll (){

		  return (List<Producto_B>) this.getSessionFactory().getCurrentSession().createCriteria (Producto_B.class ).list();
   
		
	}

}

