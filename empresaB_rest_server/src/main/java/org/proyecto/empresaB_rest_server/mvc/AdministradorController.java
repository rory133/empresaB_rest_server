package org.proyecto.empresaB_rest_server.mvc;


import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.proyecto.empresaB_rest_server.model.Administrador_B;
import org.proyecto.empresaB_rest_server.model.Cliente_B;
import org.proyecto.empresaB_rest_server.model.ListaAdministradores_B;
import org.proyecto.empresaB_rest_server.model.ListaClientes_B;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.model.Usuario_B;
import org.proyecto.empresaB_rest_server.service.impl.Administrador_BServiceImpl;
import org.proyecto.empresaB_rest_server.service.impl.Productos_BServiceImpl;
import org.proyecto.empresaB_rest_server.util.ListaProvincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/administradores")
public class AdministradorController {
	
	@Autowired
	private Administrador_BServiceImpl administrador_BServiceImpl;
	
	
	@Autowired
	ServletContext context;
	
	


	
	protected static Logger logger = Logger.getLogger("*en Administrador_B_BControlleren servidor#######*");
	
	
	

	
	
	
	
	@RequestMapping(value="/administrador",
			method = RequestMethod.POST,
			headers="Accept=application/xml, application/json")
	public @ResponseBody void addCliente_B_form(@RequestBody Administrador_B administrador_b) {


		logger.info("addAdministrador_B_form ");
		
		administrador_b.setAUTHORITY("ROLE_ADMIN");
		administrador_b.setENABLED(true);
		administrador_BServiceImpl.save(administrador_b);
		
		logger.info("se ha sumado administrador en servidor####### "+administrador_b.getNombre_b());
		administrador_BServiceImpl.save(administrador_b);




	}


	//devolvemos una lista con todos los administradores
@RequestMapping(value="/administradores",
				method=RequestMethod.GET, 
				headers="Accept=application/xml, application/json")
	
	public @ResponseBody  ListaAdministradores_B listadoAdministradores_B(){
		logger.info("enServidor en listadoAdministradores REST server ####");
		

		ListaAdministradores_B lista=new ListaAdministradores_B();
		lista.setDataAdministrador(administrador_BServiceImpl.findAll());
	

	   return lista;
	}


//buscamos y devolvemos un administrador por su id
	@RequestMapping(value="/administrador/{id}"
			, method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	public @ResponseBody Administrador_B getAdministradorPorId(@PathVariable("id")String  id){
		
		logger.info(" en servidor en getAdministradoPorId  ##### " );
		
		Administrador_B adminTemp=administrador_BServiceImpl.findByAdministrador_BIdAdministrador_b(id);		
		
		return adminTemp;	
	
	}


	//buscamos y devolvemos un administrador por su login
		@RequestMapping(value="/administradorLogin/{login}"
				, method = RequestMethod.GET,
				headers="Accept=application/xml, application/json")
		public @ResponseBody Usuario_B getAdministradorPorLogin(@PathVariable("login")String  login){
			
			logger.info(" en servidor en getAdministradoPorLogin #####: "+login );
			
					
			Usuario_B usuarioTemp=administrador_BServiceImpl.findByAdministrador_B_login_usuario_b(login);
			logger.info(" en servidor en getAdministradoPorLogin usuarioTemp.getLogin_usuario_b() #####: "+usuarioTemp.getLogin_usuario_b() );
			return usuarioTemp;	
		
		}

	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView editAdministrador_B_form(String id){


	
		Administrador_B administrador_b= new Administrador_B();
		administrador_b= administrador_BServiceImpl.findByAdministrador_BIdAdministrador_b(id);
					
		logger.info("producto pasado a edit-modificar: "+administrador_b.getNombre_b());
		
		
		//List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		//return new ModelAndView("producto_b/listaProductos","productos", lista);
		return new ModelAndView("administrador_b/modificar", "administrador_b",administrador_b);
	
}

	
	//actualizamos un cliente
	@RequestMapping(value="/administrador/{id}",
			method = RequestMethod.PUT,
			headers="Accept=application/xml, application/json")
public @ResponseBody void updateCliente(@PathVariable ("id") String id, @RequestBody Administrador_B administrador_b) {


		logger.info("en servido inicio de updateAdministrador_B en servidor####### ");
		administrador_b.setAUTHORITY("ROLE_ADMIN");
		administrador_b.setENABLED(true);
		administrador_BServiceImpl.update(administrador_b);



}
	
	//borrar administrador
	@RequestMapping(value="/administrador/{id}"
			, method = RequestMethod.DELETE,
			headers="Accept=application/xml, application/json")
	public @ResponseBody void delAdministrador_B_form(@PathVariable("id")String  id){
		logger.info(" en deladministrador_B_form DELETE por id  ##### " +id);
		
		Administrador_B administrador_b= new Administrador_B();
		administrador_b= administrador_BServiceImpl.findByAdministrador_BIdAdministrador_b(id);
		logger.info(" en getClienteHTML DELETE por id ya encontrado cliente  ##### ");
		administrador_BServiceImpl.delete(administrador_b);
			
		logger.info("##### borrando administrador : ");
	}	
	
	

	

}