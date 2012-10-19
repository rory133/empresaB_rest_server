package org.proyecto.empresaB_rest_server.mvc;

import org.apache.log4j.Logger;
import org.proyecto.empresaB_rest_server.model.Carro_B;
import org.proyecto.empresaB_rest_server.model.ListaProductos_BSeleccionados;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.model.Producto_BSeleccionado;
import org.proyecto.empresaB_rest_server.service.impl.Producto_BSeleccionadoServiceImpl;
import org.proyecto.empresaB_rest_server.service.impl.Productos_BServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/productoBSeleccionado")
public class Producto_BSeleccionadoController {
	
	
	protected static Logger logger = Logger.getLogger("*en Producto_BSeleccionadoController*SERVER####");
	
	
	@Autowired
	private Producto_BSeleccionadoServiceImpl producto_BSeleccionadoService;
	
	
	
	//creamos un nuevo productoSeleccionado
	@RequestMapping(value="/producto_b_seleccionado",
					method = RequestMethod.POST,
					headers="Accept=application/xml, application/json")
	public @ResponseBody void addProducto_BSeleccionado_form(@RequestBody Producto_BSeleccionado producto_BSeleccionado) {
		logger.info("salvamos un productoBSeleccionado REST server ####");
		
		producto_BSeleccionadoService.save(producto_BSeleccionado);
		

	}
	
	
	//borramos un productoSeleccionado
		@RequestMapping(value="/producto_b_seleccionado/{id}"
				, method = RequestMethod.DELETE,
				headers="Accept=application/xml, application/json")
		public @ResponseBody void delProducto_BSeleccionado(@PathVariable("id")String  id){
			logger.info(" en delProducto_BSeleccionado DELETE por id SERVIDOR ##### " +id);
			
			Producto_BSeleccionado producto_bSeleccionado= new Producto_BSeleccionado();
			producto_bSeleccionado=producto_BSeleccionadoService.findByProducto_BSeleccionadoIdProducto_b(id);
			producto_BSeleccionadoService.delete(producto_bSeleccionado);
			
		}
		
	
		//actualizamos un productoSeleccionado
		@RequestMapping(value="/producto_b_seleccionado",
						method = RequestMethod.PUT,
						headers="Accept=application/xml, application/json")
		public @ResponseBody String updateProducto_B_form(@RequestBody Producto_BSeleccionado producto_BSeleccionado) {
		
			logger.info(" en updateProducto_B_form PUT SERVIDOR ##### ");
			producto_BSeleccionadoService.update(producto_BSeleccionado);
			String idPruductoSeleccionado=String.valueOf(producto_BSeleccionado.getProducto_b().getIdproductob());
			
			//devolvemos el id delproductoBseleccionado recien actualizado
			return idPruductoSeleccionado;

		}
		
		//encontramos un productoSeleccionado por su id
		@RequestMapping(value="/producto_b_seleccionado/{id}"
				, method = RequestMethod.GET,
				headers="Accept=application/xml, application/json")
		public @ResponseBody Producto_BSeleccionado getProductoBSeleccionadoPorId(@PathVariable("id")String  id){
			
			logger.info(" en getProductoBSeleccionadoPorId GET {id} SERVIDOR ##### ");
			
			Producto_BSeleccionado pruductoTemp=producto_BSeleccionadoService.findByProducto_BSeleccionadoIdProducto_b(id);
			return pruductoTemp;

		}
	
		//encontramos un productoSeleccionado por su id y el id del carro
		@RequestMapping(value="/producto_b_seleccionadoIDProductoIdCarro/{id}/{idCarro}"
				, method = RequestMethod.GET,
				headers="Accept=application/xml, application/json")
		public @ResponseBody Producto_BSeleccionado getProductoBSeleccionadoPorIdProductoIdCarro(@PathVariable("id")String  id,@PathVariable("idCarro")String  idCarro){
			
			logger.info(" en getProductoBSeleccionadoPorIdProductoIdCarro GET {id,idCarro} SERVIDOR ##### id "+ id +" idCarro : "+ idCarro);
			Producto_BSeleccionado pruductoTemp=producto_BSeleccionadoService.findByProducto_BSeleccionadoIdProducto_b_y_carro_b(id, idCarro);
			return pruductoTemp;

		}
		
		//encontramos lo productosSeleccionados por el id del carro
		@RequestMapping(value="/producto_b_seleccionadoIdCarro/{idCarro}"
				, method = RequestMethod.GET,
				headers="Accept=application/xml, application/json")
		public @ResponseBody ListaProductos_BSeleccionados getProductosBSeleccionadosPorIdCarro(@PathVariable("idCarro")String  idCarro){
			ListaProductos_BSeleccionados lista = new ListaProductos_BSeleccionados();
			logger.info(" en getProductosBSeleccionadosPorIdCarro {idCarro} SERVIDOR ##### idCarro : "+idCarro);
			logger.info(" tamañao lista productos selceecionados {idCarro} SERVIDOR ##### idCarro : "+producto_BSeleccionadoService.findByProducto_BSeleccionadoPorIdcarro_b(idCarro));
			lista.setDataProductoBSeleccionado(producto_BSeleccionadoService.findByProducto_BSeleccionadoPorIdcarro_b(idCarro));
			return lista;

		}

}
