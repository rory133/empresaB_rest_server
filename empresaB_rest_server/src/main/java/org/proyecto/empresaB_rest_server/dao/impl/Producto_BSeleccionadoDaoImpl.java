package org.proyecto.empresaB_rest_server.dao.impl;

import java.util.Iterator;
import java.util.List;


import org.proyecto.empresaB_rest_server.dao.Producto_BSeleccionadoDao;
import org.proyecto.empresaB_rest_server.model.Producto_BSeleccionado;
import org.proyecto.empresaB_rest_server.util.CustomHibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

@Repository("Producto_BSeleccionadoDao")
public class Producto_BSeleccionadoDaoImpl extends CustomHibernateDaoSupport implements Producto_BSeleccionadoDao{
	
         @Autowired
	 private SessionFactory sessionFactory;
    
    
      public void save(Producto_BSeleccionado producto_BSeleccionado) {
		
		//System.out.println("productoBseleccionado a guardar en save: "+ producto_BSeleccionado.getIdproductob());
		//System.out.println("productoBseleccionado id productob a guardar en save : "+ producto_BSeleccionado.getIdproductob());
		System.out.println("CANTIDAD productoBseleccionado id productob a guardar en save : "+ producto_BSeleccionado.getCantidad());
		//getHibernateTemplate().save(producto_BSeleccionado);
                
                 this.sessionFactory.getCurrentSession().save(producto_BSeleccionado);
                
                
		//getHibernateTemplate().merge(producto_BSeleccionado);
		//getHibernateTemplate().saveOrUpdate(producto_BSeleccionado);
	
	}



	public void update(Producto_BSeleccionado producto_BSeleccionado) {
		
		//System.out.println("productoBseleccionado a guardar en update: "+ producto_BSeleccionado.getIdproductob());
		//System.out.println("productoBseleccionado id productob a guardar en update: "+ producto_BSeleccionado.getIdproductob());
		System.out.println("CANTIDAD productoBseleccionado id productob a guardar en update : "+ producto_BSeleccionado.getCantidad());
		//getHibernateTemplate().update(producto_BSeleccionado);
		//getHibernateTemplate().merge(producto_BSeleccionado);
                this.sessionFactory.getCurrentSession().merge(producto_BSeleccionado);
	}

	public void delete(Producto_BSeleccionado producto_BSeleccionado) {
		System.out.println("en delete productoSeleccionado: "+producto_BSeleccionado.getIdproductoSeleccionado());
		//getHibernateTemplate().delete(producto_BSeleccionado);
                this.sessionFactory.getCurrentSession().delete(producto_BSeleccionado);
		
	}
	@SuppressWarnings("unchecked")
	public Producto_BSeleccionado findByProducto_BSeleccionadoIdProducto_b(String producto_BSeleccionadoIdProducto_b) {
		/*
		List<Producto_BSeleccionado> list = getHibernateTemplate().find(
                     "from Producto_BSeleccionado where IDPRODUCTOB = ?",Integer.parseInt(producto_BSeleccionadoIdProducto_b));
		return (Producto_BSeleccionado)list.get(0);
                */
		
		System.out.println("EN findByProducto_BSeleccionadoIdProducto_b con idproductoBselecclionado= "+ producto_BSeleccionadoIdProducto_b);
              List <Producto_BSeleccionado> list = sessionFactory.getCurrentSession().createCriteria (Producto_BSeleccionado.class )
                        .add(Restrictions.eq("idproductoSeleccionado",Integer.parseInt(producto_BSeleccionadoIdProducto_b)))
                        .list();
                return (Producto_BSeleccionado) list.get(0);
                
                
                
                
	}
	
	@SuppressWarnings("unchecked")
	public Producto_BSeleccionado findByProducto_BSeleccionado_nombre(String producto_BSeleccionado_nombre) {
		
            /*
             List <Producto_BSeleccionado> list = getHibernateTemplate().find(
                "from Producto_BSeleccionado where NOMBRE_PRODUCTOB = ?",producto_BSeleccionado_nombre);
		return (Producto_BSeleccionado)list.get(0);
             */   
		System.out.println("EN findByProducto_BSeleccionado_nombre :"+producto_BSeleccionado_nombre);
             List <Producto_BSeleccionado> list = sessionFactory.getCurrentSession().createCriteria (Producto_BSeleccionado.class )
                        .add(Restrictions.eq("NOMBRE_PRODUCTOB",producto_BSeleccionado_nombre))
                        .list();
                return list.get(0);   
                
                
	}
	
/*	@SuppressWarnings("unchecked")
	public Producto_BSeleccionado findByProducto_BSeleccionadoIdProducto_b_y_carro_b(String Producto_BSeleccionadoIdProducto_b, String carro_b){
		System.out.println("carro_b en find: "+carro_b);
		System.out.println("productoseleccionado en find: "+Producto_BSeleccionadoIdProducto_b);
		List <Producto_BSeleccionado> list = getHibernateTemplate().find(
        	"from Producto_BSeleccionado where IDCARRO_B = ?", Integer.parseInt(carro_b));
		if(!list.isEmpty())
		return (Producto_BSeleccionado)list.get(0);
		
		return null;
		
	}*/
	
	@SuppressWarnings("unchecked")
	public Producto_BSeleccionado findByProducto_BSeleccionadoIdProducto_b_y_carro_b(String Producto_BSeleccionadoIdProducto_b, String carro_b){
		System.out.println("carro_b en find-por iddproducto y por idCarro: "+carro_b);
		System.out.println("productoseleccionado en find-por iddproducto y por idCarro: "+Producto_BSeleccionadoIdProducto_b);
		
                
                /*
                List <Producto_BSeleccionado> list = getHibernateTemplate().find(
        	"from Producto_BSeleccionado where IDCARRO_B = ?", Integer.parseInt(carro_b));
		System.out.println("despues de buscar productos find-por iddproducto y por idCarro");
                */
                List <Producto_BSeleccionado> list = sessionFactory.getCurrentSession().createCriteria (Producto_BSeleccionado.class )
                        .add(Restrictions.eq("carro_b.idcarro_b",Integer.parseInt(carro_b)))
                        .list();
                
                
		if(list.isEmpty()){
			return null;
		}
		else{
			
		System.out.println("hay productos seleccionados con ese carro  en find ");
		Iterator<Producto_BSeleccionado> itr = list.iterator();
		while (itr.hasNext()) {
			Producto_BSeleccionado element = itr.next();
			System.out.println("en bucle while id del producto actual : "+element.getIdproductoSeleccionado());
			if(element.getProducto_b().getIdproductob()==Integer.parseInt(Producto_BSeleccionadoIdProducto_b)){
				System.out.println("Se encontro ese producto en find, esta es su id:"+element.getIdproductoSeleccionado());
				return element;
			}
		}

		
		return null;
		
		}
		
	}
	@SuppressWarnings("unchecked")
	public List <Producto_BSeleccionado> findByProducto_BSeleccionadoPorIdcarro_b(String carro_b){
		System.out.println("carro_b en find por id carro: "+carro_b);
		/*
                List <Producto_BSeleccionado> list = getHibernateTemplate().find(
        	"from Producto_BSeleccionado where idcarro_b = ?", Integer.parseInt(carro_b));
		System.out.println("tamaño lista en findByProducto_BSeleccionadoPorIdcarro_b: "+list.size());
                */
                List <Producto_BSeleccionado> lista = sessionFactory.getCurrentSession()
                		.createCriteria (Producto_BSeleccionado.class )
                        .add(Restrictions. eq("carro_b.idcarro_b",Integer.parseInt(carro_b)))
                        .list();
		
	/*	if(list.isEmpty()){
			return null;
		}*/		
		return lista;
		
	
		
	}
	

	@SuppressWarnings("unchecked")
	public List<Producto_BSeleccionado> findAll (){
	      /*	
              List <Producto_BSeleccionado> list = getHibernateTemplate().find("from Producto_BSeleccionado");
		return list;
              */
              return sessionFactory.getCurrentSession().createCriteria (Producto_BSeleccionado.class )
                                     .list();
	}

}

