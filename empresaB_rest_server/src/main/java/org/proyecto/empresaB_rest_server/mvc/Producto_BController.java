package org.proyecto.empresaB_rest_server.mvc;



import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;
import org.proyecto.empresaB_rest_server.model.ListaProductos_B;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.service.impl.Productos_BServiceImpl;





@Controller
@RequestMapping("/productos")
public class Producto_BController {

	@Autowired
	private Productos_BServiceImpl productos_BServiceImpl;
	

	
	

	
	@Autowired
	ServletContext context;
	
	
	
	

	
	protected static Logger logger = Logger.getLogger("*en Producto_BController*SERVER####");
		
	
	
	
	
	
//enviamos a cliente la lista de todos los productos
	@RequestMapping(value="/productos",
			method=RequestMethod.GET, 
			headers="Accept=application/xml, application/json")

public @ResponseBody  ListaProductos_B listadoProductos_B(){
	logger.info("enServidor en listadoProductos REST server ####");
	//List<Cliente_B> clientes_b=cliente_BServiceImpl.findAll();

	ListaProductos_B lista=new ListaProductos_B();
	lista.setDataProducto(productos_BServiceImpl.getProductos_B());


   return lista;
}
	
	
//creamos un nuevo producto
	@RequestMapping(value="/admin/producto",
					method = RequestMethod.POST,
					headers="Accept=application/xml, application/json")
	public @ResponseBody String addProducto_B_form(@RequestBody Producto_B producto_b) {
		productos_BServiceImpl.save(producto_b);
		String idPruducto=String.valueOf(producto_b.getIdproductob());
		
		//devolvemos el producto recien creado
		return idPruducto;

	}
//borramos un producto
	@RequestMapping(value="/producto/{id}"
			, method = RequestMethod.DELETE,
			headers="Accept=application/xml, application/json")
	public @ResponseBody void delProducto_B(@PathVariable("id")String  id){
		logger.info("SERVIDOR en delProducto_B DELETE por id  ##### " +id);
		
		Producto_B producto_b= new Producto_B();
		producto_b=productos_BServiceImpl.findByProducto_BIdProducto_b(id);
		
		productos_BServiceImpl.delete(producto_b);
		logger.info("##### borrando producto : ");
	}
	
	
	
//actutalizamos un producto
	@RequestMapping(value="/admin/producto",
					method = RequestMethod.PUT,
					headers="Accept=application/xml, application/json")
	public @ResponseBody String updateProducto_B_form(@RequestBody Producto_B producto_b) {
		productos_BServiceImpl.update(producto_b);
		logger.info("SERVIDOR en updateProducto_B_form se acaba de actualiza producto, con nombre"+producto_b.getNombre_productoB());
		logger.info("SERVIDOR en updateProducto_B_form se acaba de actualiza producto, con cantidad"+producto_b.getCantidad_existencias());
		String idProducto=String.valueOf(producto_b.getIdproductob());
		
		//devolvemos el id delproducto recien actualizado
		return idProducto;
		
		
		
	}
	
//encontramos un producto por su id
	@RequestMapping(value="/producto/{id}"
			, method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	public @ResponseBody Producto_B getProductoPorId(@PathVariable("id")String  id){
		
		logger.info(" en servidor en getProductoPorId  ##### " +id);
		
		Producto_B pruductoTemp= productos_BServiceImpl.findByProducto_BIdProducto_b(id);
		return pruductoTemp;

	}
	

	
}