package org.proyecto.empresaB_rest_server.mvc;


import java.util.Date;
import org.apache.log4j.Logger;
import org.proyecto.empresaB_rest_server.model.Cliente_B;
import org.proyecto.empresaB_rest_server.model.ListaClientes_B;
import org.proyecto.empresaB_rest_server.service.Cliente_BService;
import org.proyecto.empresaB_rest_server.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;





@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
/*	@Autowired
	private Cliente_BServiceImpl cliente_BServiceImpl;*/
	
	@Autowired
	private Cliente_BService cliente_BServiceImpl;

	
	

	@Autowired
	private Mail mail;
	


	
	protected static Logger logger = Logger.getLogger("*en Cliente_B_BController*en servidor#######");
	
	
	
	

	

	//actualizamos un cliente
	@RequestMapping(value="/cliente/{id}",
			method = RequestMethod.PUT,
			headers="Accept=application/xml, application/json")
public @ResponseBody void updateCliente(@PathVariable ("id") String id, @RequestBody Cliente_B cliente_b) {


		logger.info("en servido inicio de updateCliente_B r####### ");

		cliente_BServiceImpl.update(cliente_b);

		logger.info("se envia correo de informacion de actualizacion en servidor####### a"+cliente_b.getNombre_b());
		String content="apreciado usuario se ha procedido a a actualizar sus datos en nuestra base de datos";
		String subject="realizada correctamente actualizació en empresa_b";		
		mail.sendMail(cliente_b.getLogin_usuario_b(), content, cliente_b.getEmail_b(), subject);


}
	
	
	//creamos un nuevo cliente
	@RequestMapping(value="/cliente",
					method = RequestMethod.POST,
					headers="Accept=application/xml, application/json")
	public @ResponseBody void addCliente_B_form(@RequestBody Cliente_B cliente_b) {

		
		logger.info("inicio de addCliente_B en servidor####### ");
	
		
		
		cliente_b.setFecha_alta_b(new Date());
		cliente_b.setAUTHORITY("ROLE_CLIENTE");
		cliente_b.setENABLED(true);
		logger.info("se ha sumado cliente en servidor####### "+cliente_b.getNombre_b());
		cliente_BServiceImpl.save(cliente_b);
		
		logger.info("se envia correo de bienvenida en servidor####### a"+cliente_b.getNombre_b());
		String content="apreciado usuario gracias por darse de alta en nuestra página ahora pordrá realizar los pedidos que desee";
		String subject="realizada correctamente alta en empresa_b";		
		mail.sendMail(cliente_b.getLogin_usuario_b(), content, cliente_b.getEmail_b(), subject);

		
}
	

	
	
	//devolvemos una lista con todos los clientes
@RequestMapping(value="/clientes",
				method=RequestMethod.GET, 
				headers="Accept=application/xml, application/json")
	
	public @ResponseBody  ListaClientes_B listadoClientes_B(){
		logger.info("enServidor en listadoClientes REST server ####");
		//List<Cliente_B> clientes_b=cliente_BServiceImpl.findAll();

		ListaClientes_B lista=new ListaClientes_B();
		lista.setDataCliente(cliente_BServiceImpl.findAll());
	

	   return lista;
	}


	
	
	
	//buscamos y devolvemos un clientes por su login
	@RequestMapping(value="/clienteLogin/{login}",
			method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	public @ResponseBody Cliente_B getClientePorLogin(@PathVariable("login")String  login){
		
		logger.info(" en Servidor en getClientePorLogin por login  ##### " +login);
		
		Cliente_B clientTemp =(Cliente_B)cliente_BServiceImpl.findByCliente_B_login_usuario_b(login);
		if(null!=clientTemp){		
			Integer id=clientTemp.getIdusuarios_b();
			logger.info(" en getClienteHTML por login  #####  el id obtenido con cliente_BServiceImpl.findByCliente_B_login_usuario_b(login).getIdusuarios_b() es "  +id);
			Cliente_B clientTemp2= cliente_BServiceImpl.findByCliente_BIdCliente_b(String.valueOf(id));
			return clientTemp2;
		}
		
		
		
		return null;


	
	}
	//buscamos y devolvemos un clientes por su id
	@RequestMapping(value="/cliente/{id}"
			, method = RequestMethod.GET,
			headers="Accept=application/xml, application/json")
	public @ResponseBody Cliente_B getClientePorId(@PathVariable("id")String  id){
		
		logger.info(" en servidor en getClientePorId  ##### " +id);
		
		Cliente_B clientTemp= cliente_BServiceImpl.findByCliente_BIdCliente_b(id);
		
		logger.info("en getClienteHTML por login  ##### imprimo nombre cliente optendio con cliente_BServiceImpl.findByCliente_BIdCliente_b(id); "+clientTemp.getNombre_b());
		
		
		return clientTemp;

	
	}


	@RequestMapping(value="/cliente/{id}"
			, method = RequestMethod.DELETE,
			headers="Accept=application/xml, application/json")
	public @ResponseBody void delCliente_B_form(@PathVariable("id")String  id){
		logger.info(" en delcliente_B_form DELETE por id  ##### " +id);
		
		Cliente_B cliente_b= new Cliente_B();
		cliente_b= cliente_BServiceImpl.findByCliente_BIdCliente_b(id);
		logger.info(" en getClienteHTML DELETE por id ya encontrado cliente  ##### ");
	
		cliente_BServiceImpl.delete(cliente_b);
		logger.info(" en getClienteHTML DELETE por id ya borrado cliente  ##### ");
		logger.info("##### borrando cliente : ");
	}


}
