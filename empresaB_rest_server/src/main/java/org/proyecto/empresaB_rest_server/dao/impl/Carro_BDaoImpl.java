package org.proyecto.empresaB_rest_server.dao.impl;

import org.proyecto.empresaB_rest_server.dao.Carro_BDao;
import org.proyecto.empresaB_rest_server.model.Carro_B;
import org.proyecto.empresaB_rest_server.model.Producto_BSeleccionado;
import org.proyecto.empresaB_rest_server.util.CustomHibernateDaoSupport;
import java.util.List;
import org.springframework.stereotype.Repository;


//@Repository("Carro_BDao")


// le decimos a Spring que es una clase DAO y que se inyectará el objeto SessionFactory
//de Hibernate con la anotacion @Autowired
@Repository("carro_BDao")
public class Carro_BDaoImpl extends CustomHibernateDaoSupport implements Carro_BDao {

	public void save(Carro_B carro_B) {
		System.out.println("datos carro cliente:"+carro_B.getCliente_b().getNombre_b());
		System.out.println("datos carro IdCliente:"+carro_B.getCliente_b().getIdusuarios_b());
		System.out.println("datos carro fecha:"+carro_B.getFecha_b());
		System.out.println("datos carro pagado:"+carro_B.getPagado());
		System.out.println("datos carro enviado:"+carro_B.getEnviado());
		System.out.println("datos carro tamaño productos seleccionado"+carro_B.getProducto_BSeleccionado().size());
		
		getHibernateTemplate().save(carro_B);
		System.out.println("salvado carro");
	
	}



	public void update(Carro_B carro_B) {
		getHibernateTemplate().update(carro_B);
		
	}

	public void delete(Carro_B carro_B) {
		getHibernateTemplate().delete(carro_B);
		
	}
	
	@SuppressWarnings("unchecked")
	public Carro_B findByCarro_BIdCarro_b(String carro_BIdCarro_b) {
		List<Carro_B> list = getHibernateTemplate().find(
                     "from Carro_B where idcarro_b = ?",Integer.parseInt(carro_BIdCarro_b));
		return (Carro_B)list.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto_BSeleccionado>findByTodosCarro_BIdCarro_b(String carro_BIdCarro_b) {
		List<Producto_BSeleccionado> list = getHibernateTemplate().find(
                    "from Producto_BSeleccionado where idcarro_b = ?",Integer.parseInt(carro_BIdCarro_b));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Carro_B>findByTodosCarro_BIdCliente_b(String carro_BIdCliente_b) {
		List<Carro_B> list = getHibernateTemplate().find(
                    "from Carro_B where idcliente = ?",Integer.parseInt(carro_BIdCliente_b) );
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Carro_B> findAll(){
		System.out.println("en finAll de Carrodaoimpl");
		List <Carro_B> list = getHibernateTemplate().find("from Carro_B order by idcarro_b");
	
		return list;
	}

}
