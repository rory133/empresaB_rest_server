package org.proyecto.empresaB_rest_server.mvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.proyecto.empresaB_rest_server.model.Carro_B;
import org.proyecto.empresaB_rest_server.model.Cliente_B;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.model.Producto_BSeleccionado;
import org.proyecto.empresaB_rest_server.model.TarjetaCredito;
import org.proyecto.empresaB_rest_server.model.Usuario_B;
import org.proyecto.empresaB_rest_server.service.impl.Carro_BServiceImpl;
import org.proyecto.empresaB_rest_server.service.impl.Cliente_BServiceImpl;
import org.proyecto.empresaB_rest_server.service.impl.Producto_BSeleccionadoServiceImpl;
import org.proyecto.empresaB_rest_server.service.impl.Productos_BServiceImpl;
import org.proyecto.empresaB_rest_server.util.ListaPedidos;
import org.proyecto.empresaB_rest_server.util.ListaProductosSeleccionados;
import org.proyecto.empresaB_rest_server.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
@RequestMapping("/carro")
@SessionAttributes("carro_B")
public class CarroController {

	
	@Autowired
	private Carro_B carro_b;
	
	@Autowired
	private Productos_BServiceImpl productos_BServiceImpl;
	
	@Autowired
	private Producto_BSeleccionadoServiceImpl producto_BSeleccionadoService;
	
	@Autowired
	private Cliente_BServiceImpl cliente_BServiceImpl;
	
	@Autowired
	Carro_BServiceImpl carro_BService;
	
	@Autowired
	private TarjetaCredito tarjetaCredito;
	
	
	@Autowired
	private Mail mail;
	
	
	
	protected static Logger logger = Logger.getLogger("*en CarroController*");
	
	@RequestMapping(value="/sumaProducto", method = RequestMethod.GET)
	public ModelAndView sumaProducto(@RequestParam(value="cantidad")String cantidad, @RequestParam(value="idProducto")String  idProducto, HttpSession session) throws Exception{
	//	carro_BService.save(carro_b);
		
		logger.info("session.getAttribute('carro_b')-al entrar: " + session.getAttribute("carro_b"));

		/*
		result.addError(new ObjectError("loginInvalido", "Este usuario ya existe"));
		
		if(result.hasErrors()) {
			logger.info("addCliente_B_form ------tiene errores----"+result.toString());
			logger.info("errores: "+result.toString());
			return new ModelAndView("redirect:../../productos/listado").addAllObjects(result.getModel());
			// return new ModelAndView("cliente_b/edit", "cliente_b",new Cliente_B()).addAllObjects(result.getModel());

			}*/
		
		if (session.getAttribute("carro_b")==null){
			logger.info("if (carro_b.getIdcarro_b()==null)");
			Carro_B carro_b =new Carro_B();
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			logger.info("usuario user user.getUsername() : "+user.getUsername());
			Usuario_B usuario= new Usuario_B();
			usuario= cliente_BServiceImpl.findByCliente_B_login_usuario_b(user.getUsername());
			Cliente_B cliente= new Cliente_B();
			cliente=(Cliente_B)usuario;
			carro_b.setCliente_b(cliente);
			carro_b.setFecha_b(new Date());
			carro_b.setEnviado(false);
			carro_b.setPagado(false);
			logger.info("antes de salvar carroooooo ");
			carro_BService.save(carro_b);
			session.setAttribute("carro_b", carro_b);
			logger.info("if (carro_b.getIdcarro_b()==null) despues    :  " +carro_b.getIdcarro_b() );
		}
		
		carro_b=(Carro_B)session.getAttribute("carro_b");
		logger.info("imprimo el id del carro: "+carro_b.getIdcarro_b());
		logger.info("imprimo la fecha del carro: "+carro_b.getFecha_b());
		//Carro_B carro_b=new Carro_B(new Date(),)
		logger.info("session.getAttributeNames().toString()"+session.getAttributeNames().toString());
		logger.info("session.getAttribute('carro_b'): " + session.getAttribute("carro_b"));
		logger.info("session Id:"+session.getId());
		logger.info("cantidad Recibida"+ cantidad);
		
		logger.info("idproducto Recibido"+ idProducto);
		logger.info("usuario de la sesion : "+session.getAttribute("user"));
		logger.info("carro de la sesion : "+session.getAttribute("carro"));
		
		
		logger.info("datos carro id"+carro_b.getIdcarro_b());
		
		
		
		

		
	
		
		Producto_B producto=new Producto_B();
		producto=productos_BServiceImpl.findByProducto_BIdProducto_b(idProducto);
		
		
		
		Producto_BSeleccionado producto_BSeleccionado=new Producto_BSeleccionado();
		
		producto_BSeleccionado.setProducto_b(producto);
		producto_BSeleccionado.setCarro_b(carro_b);	
		producto_BSeleccionado.setCantidad(Integer.parseInt(cantidad));
		//producto_BSeleccionado.setIdproductob(producto.getIdproductob());
		
		
		/*
		producto.getProductos_b_seleccionados().add(producto_BSeleccionado);
		productos_BServiceImpl.update(producto);
		
		*/
		
		logger.info("carro_b.getIdcarro_b():"+carro_b.getIdcarro_b());
		Producto_BSeleccionado producto_BSeleccionado_test=new Producto_BSeleccionado();
		logger.info("Producto_BSeleccionado producto_BSeleccionado_test=new Producto_BSeleccionado();");
		producto_BSeleccionado_test=producto_BSeleccionadoService.findByProducto_BSeleccionadoIdProducto_b_y_carro_b(String.valueOf(producto.getIdproductob()),String.valueOf( carro_b.getIdcarro_b()));
		
		logger.info("producto_BSeleccionado_test=producto_BSeleccionadoService.findByProducto_BSeleccionadoIdProducto_b_y_carro_b.....");
		if (null!=producto_BSeleccionado_test){
			//controlamos que el pedido no exceda la cantidad de existencias. aqui se tiene en cuenta los que se habian pedido antes
			if ((producto_BSeleccionado_test.getCantidad()+producto.getCantidad_existencias())<(Integer.parseInt(cantidad))){
		     	List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
				ModelAndView mav= new ModelAndView("producto_b/listaProductos");
				mav.addObject("productos", lista);
				mav.addObject("errordeCantidad","no puede pedir mas cantidad que las existencias");
				mav.addObject("productoPedido",idProducto);
				return mav;
				}
			
			
		//logger.info("producto_BSeleccionado_test idproducto="+producto_BSeleccionado_test.getIdproductob());
		logger.info("producto_BSeleccionado_test idcarro="+producto_BSeleccionado_test.getCarro_b().getIdcarro_b());
		logger.info("producto_BSeleccionado cantidad" +producto_BSeleccionado.getCantidad());
		logger.info("producto_BSeleccionado id producto" +producto_BSeleccionado.getProducto_b().getIdproductob());
		logger.info("producto_BSeleccionado id " +producto_BSeleccionado.getIdproductoSeleccionado());
		logger.info("producto_BSeleccionado id " +producto_BSeleccionado.getCarro_b().getIdcarro_b());
		logger.info("producto_BSeleccionado_test id " +producto_BSeleccionado_test.getIdproductoSeleccionado());
		//actualizacomos el valor de existencia
		producto.setCantidad_existencias(producto.getCantidad_existencias()+producto_BSeleccionado_test.getCantidad()-Integer.parseInt(cantidad));
		productos_BServiceImpl.update(producto);
		//actualizacomos producto_BSeleccionado
		producto_BSeleccionado.setIdproductoSeleccionado(producto_BSeleccionado_test.getIdproductoSeleccionado());
		producto_BSeleccionadoService.update(producto_BSeleccionado);
		
		}else{
			//controlamos que el pedido no exceda la cantidad de existencias.
			
			logger.info("producto_cantidad de existencias::::::::"+producto.getCantidad_existencias());
			logger.info("producto_cantidad pedidas::::::::"+Integer.parseInt(cantidad));
			if (producto.getCantidad_existencias()<(Integer.parseInt(cantidad))){
		     	List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
				ModelAndView mav= new ModelAndView("producto_b/listaProductos");
				mav.addObject("productos", lista);
				mav.addObject("errordeCantidad","no puede pedir mas cantidad que las existencias");
				mav.addObject("productoPedido",idProducto);
				return mav;
				}
			//actualizacomos el valor de existencia
		producto.setCantidad_existencias(producto.getCantidad_existencias()-Integer.parseInt(cantidad));
		productos_BServiceImpl.update(producto);	
		//salvamos producto_BSeleccionado
		producto_BSeleccionadoService.save(producto_BSeleccionado);
		//producto_BSeleccionadoService.update(producto_BSeleccionado);
		
		}
		carro_b.getProducto_BSeleccionado().add(producto_BSeleccionado);
		//carro_BService.update(carro_b);
		logger.info("carro_b.getProducto_BSeleccionado().size()="+carro_b.getProducto_BSeleccionado().size());
		
	/*	
		Set<Producto_BSeleccionado> listaProductos = new HashSet<Producto_BSeleccionado>(0);
		listaProductos.addAll(carro_b.getProducto_BSeleccionado());
		logger.info("tamaño elemento de listaproductos"+listaProductos.size());
		
	*/
	
		List<Producto_BSeleccionado> listaProductosRecibida=producto_BSeleccionadoService.findByProducto_BSeleccionadoPorIdcarro_b(String.valueOf( carro_b.getIdcarro_b()));
		logger.info("tamaño lista productosSeleccionados en esteCarro"+listaProductosRecibida.size());
		Set<ListaProductosSeleccionados> listaProductos=new HashSet<ListaProductosSeleccionados>(0);
		Iterator<Producto_BSeleccionado> itr =listaProductosRecibida.iterator();
		while (itr.hasNext()) {
			Producto_BSeleccionado element = itr.next();
			ListaProductosSeleccionados lista = new ListaProductosSeleccionados();
			lista.setCantidad(element.getCantidad());
			lista.setIdCarro(element.getCarro_b().getIdcarro_b());
			lista.setIdproducto_b(element.getProducto_b().getIdproductob());
			lista.setIdProductoSeleccionado(element.getIdproductoSeleccionado());
			lista.setNombreProducto(element.getProducto_b().getNombre_productoB());
			lista.setPrecio_b(element.getProducto_b().getPrecio_b());
			listaProductos.add(lista);
			
		}
		
		
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		ModelAndView mav= new ModelAndView("producto_b/listaProductos");
		mav.addObject("productos", lista);
		mav.addObject("productosSeleccionados",listaProductos);
		return mav;
		//return new ModelAndView("redirect:../../productos/listado");
	}
	@RequestMapping(value="/verCarro", method = RequestMethod.GET)
	public ModelAndView verCarro( HttpSession session) throws Exception{
		if (session.getAttribute("carro_b")==null){
			logger.info("en ver Carro, e carro esta vacio");
			ModelAndView mav= new ModelAndView("producto_b/listaProductos");
			List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
			mav.addObject("errorCarroVacio","¡¡¡el carro esta vacio, aun no ha seleccionado ningun producto!!!");
			mav.addObject("productos", lista);		
			return mav;

		}
		
		Set<ListaProductosSeleccionados> listaProductos=new HashSet<ListaProductosSeleccionados>(0);
		List<Producto_BSeleccionado> listaProductosRecibida=producto_BSeleccionadoService.findByProducto_BSeleccionadoPorIdcarro_b(String.valueOf( carro_b.getIdcarro_b()));
		if (!listaProductosRecibida.isEmpty()){
		//logger.info("tamaño lista productosSeleccionados en esteCarro"+listaProductosRecibida.size());
		
		Iterator<Producto_BSeleccionado> itr =listaProductosRecibida.iterator();
		while (itr.hasNext()) {
			Producto_BSeleccionado element = itr.next();
			ListaProductosSeleccionados lista = new ListaProductosSeleccionados();
			lista.setCantidad(element.getCantidad());
			lista.setIdCarro(element.getCarro_b().getIdcarro_b());
			lista.setIdproducto_b(element.getProducto_b().getIdproductob());
			lista.setIdProductoSeleccionado(element.getIdproductoSeleccionado());
			lista.setNombreProducto(element.getProducto_b().getNombre_productoB());
			lista.setPrecio_b(element.getProducto_b().getPrecio_b());
			listaProductos.add(lista);
			
		}
		
		}else listaProductos=null;
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		ModelAndView mav= new ModelAndView("carro_b/verCarroActual");
		mav.addObject("productos", lista);
		mav.addObject("productosSeleccionados",listaProductos);
		return mav;
	}
	
	@RequestMapping(value="/eliminarProductoCarro", method = RequestMethod.GET)
	public ModelAndView eliminarProductoCarro(@RequestParam(value="idProductoSeleccionado")String  idProductoSeleccionado,@RequestParam(value="idProducto")String  idProducto, @RequestParam(value="cantidad")String cantidad,  HttpSession session) throws Exception{
		//eliminar el producto
		Producto_BSeleccionado producto_BSeleccionado=new Producto_BSeleccionado();
		producto_BSeleccionado=producto_BSeleccionadoService.findByProducto_BSeleccionadoIdProducto_b_y_carro_b(idProducto, String.valueOf(carro_b.getIdcarro_b()));
		producto_BSeleccionadoService.delete(producto_BSeleccionado);
		
		//sumamos cantidad a existencias del producto
		Producto_B producto=new Producto_B();
		producto=productos_BServiceImpl.findByProducto_BIdProducto_b(idProducto);
		producto.setCantidad_existencias(producto.getCantidad_existencias()+Integer.parseInt(cantidad));
		productos_BServiceImpl.update(producto);
		
		
		
		//devolvemos vista a verCarroActual
		
/*		
		List<Producto_BSeleccionado> listaProductosRecibida=producto_BSeleccionadoService.findByProducto_BSeleccionadoPorIdcarro_b(String.valueOf( carro_b.getIdcarro_b()));
		logger.info("tamaño lista productosSeleccionados en esteCarro"+listaProductosRecibida.size());
		Set<ListaProductosSeleccionados> listaProductos=new HashSet<ListaProductosSeleccionados>(0);
		Iterator<Producto_BSeleccionado> itr =listaProductosRecibida.iterator();
		while (itr.hasNext()) {
			Producto_BSeleccionado element = itr.next();
			ListaProductosSeleccionados lista = new ListaProductosSeleccionados();
			lista.setCantidad(element.getCantidad());
			lista.setIdCarro(element.getCarro_b().getIdcarro_b());
			lista.setIdproducto_b(element.getProducto_b().getIdproductob());
			lista.setIdProductoSeleccionado(element.getIdproductoSeleccionado());
			lista.setNombreProducto(element.getProducto_b().getNombre_productoB());
			listaProductos.add(lista);
			
		}
		
		
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		ModelAndView mav= new ModelAndView("carro_b/verCarroActual");
		mav.addObject("productos", lista);
		mav.addObject("productosSeleccionados",listaProductos);
		return mav;*/
		
		return new ModelAndView("redirect: verCarro");
	}
	
	@RequestMapping(value="/verTodosLosPedidos", method = RequestMethod.GET)
	public ModelAndView verTodosLosPedidos( HttpSession session) throws Exception{
		
		logger.info("en /carro/verTodos/LosPedidos");
		//Set<ListaPedidos> listaCarrosAMostrar=new HashSet<ListaPedidos>(0);
		//Set<ListaPedidos> listaCarrosAMostrar=new HashSet<ListaPedidos>();
		//SortedSet<ListaPedidos> listaCarrosAMostrar=new TreeSet<ListaPedidos>();
		//que sea una lista ordenada
		Set<ListaPedidos> listaCarrosAMostrar=new TreeSet<ListaPedidos>();
	
		
		List<Carro_B> listaCarros =carro_BService.findAll();
		
		
		logger.info("tamaño lista carro: "+listaCarros.size());
		
		Iterator<Carro_B> iterCarro =listaCarros.iterator();
		
		
		
		while (iterCarro.hasNext()) {
			ListaPedidos listaCarrosPedidos = new ListaPedidos();
			Carro_B elementoCarro = iterCarro.next();
			listaCarrosPedidos.setIdCliente(elementoCarro.getCliente_b().getIdusuarios_b());
			listaCarrosPedidos.setLoginCliente(elementoCarro.getCliente_b().getLogin_usuario_b());
			listaCarrosPedidos.setPagado(elementoCarro.getPagado());
			listaCarrosPedidos.setEnviado(elementoCarro.getEnviado());
			listaCarrosPedidos.setIdCarro(elementoCarro.getIdcarro_b());
			listaCarrosPedidos.setFechaPedido(elementoCarro.getFecha_b());
			logger.info("iprimo el login del usuario desde listaCarrospedidos: "+listaCarrosPedidos.getLoginCliente());
			List<Producto_BSeleccionado> listaProductosCarro=producto_BSeleccionadoService.findByProducto_BSeleccionadoPorIdcarro_b(String.valueOf(elementoCarro.getIdcarro_b()));
			logger.info("iprimo el tamaño de la lista de productos de cada carro: "+listaProductosCarro.size());
			Iterator<Producto_BSeleccionado> itr =listaProductosCarro.iterator();
			Set<ListaProductosSeleccionados> listaProductos=new HashSet<ListaProductosSeleccionados>(0);
			while (itr.hasNext()) {
				Producto_BSeleccionado element = itr.next();
				ListaProductosSeleccionados lista = new ListaProductosSeleccionados();
				lista.setCantidad(element.getCantidad());
				lista.setIdCarro(element.getCarro_b().getIdcarro_b());
				lista.setIdproducto_b(element.getProducto_b().getIdproductob());
				lista.setIdProductoSeleccionado(element.getIdproductoSeleccionado());
				lista.setNombreProducto(element.getProducto_b().getNombre_productoB());
				lista.setPrecio_b(element.getProducto_b().getPrecio_b());
				listaProductos.add(lista);			
			}
			listaCarrosPedidos.setListaProductosSeleccionados(listaProductos);
			listaCarrosAMostrar.add(listaCarrosPedidos);
		}
		
		
		ModelAndView mav= new ModelAndView("carro_b/verPedidos");
		mav.addObject("TodosLosPedidos", listaCarrosAMostrar);
		return mav;
		
	}
	
	@RequestMapping(value="/verDetallesCarro", method = RequestMethod.GET)
	public ModelAndView verDetallesCarro( @RequestParam(value="idCarro")String  idCarro) throws Exception{
		
		Set<ListaProductosSeleccionados> listaProductos=new HashSet<ListaProductosSeleccionados>(0);
		List<Producto_BSeleccionado> listaProductosRecibida=producto_BSeleccionadoService.findByProducto_BSeleccionadoPorIdcarro_b(idCarro);
		if (!listaProductosRecibida.isEmpty()){
		//logger.info("tamaño lista productosSeleccionados en esteCarro"+listaProductosRecibida.size());
		
		Iterator<Producto_BSeleccionado> itr =listaProductosRecibida.iterator();
		while (itr.hasNext()) {
			Producto_BSeleccionado element = itr.next();
			ListaProductosSeleccionados lista = new ListaProductosSeleccionados();
			lista.setCantidad(element.getCantidad());
			lista.setIdCarro(element.getCarro_b().getIdcarro_b());
			lista.setIdproducto_b(element.getProducto_b().getIdproductob());
			lista.setIdProductoSeleccionado(element.getIdproductoSeleccionado());
			lista.setNombreProducto(element.getProducto_b().getNombre_productoB());
			lista.setPrecio_b(element.getProducto_b().getPrecio_b());
			listaProductos.add(lista);
			
		}
		
		}else listaProductos=null;
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		ModelAndView mav= new ModelAndView("carro_b/verDetallesCarro");
		mav.addObject("productos", lista);
		mav.addObject("productosSeleccionados",listaProductos);
		return mav;
	}
	@RequestMapping(value="/borrarCarro", method = RequestMethod.GET)
	public ModelAndView borrarCarro( @RequestParam(value="idCarro")String  idCarro) throws Exception{
		
		
		carro_b=carro_BService.findByCarro_BIdCarro_b(idCarro);
		carro_BService.delete(carro_b);


		ModelAndView mav= new ModelAndView("redirect: verTodosLosPedidos");
	

		return mav;
	}
	
	@RequestMapping(value="/cambioEstadoCarroPagado", method = RequestMethod.GET)
	public ModelAndView cambioEstadoCarroPagado( @RequestParam(value="idCarro")String  idCarro) throws Exception{
		
		
		carro_b=carro_BService.findByCarro_BIdCarro_b(idCarro);
		if(carro_b.getPagado())
		  carro_b.setPagado(false);
		else carro_b.setPagado(true);
		carro_BService.update(carro_b);


		ModelAndView mav= new ModelAndView("redirect: verTodosLosPedidos");
	

		return mav;
	}
	@RequestMapping(value="/cambioEstadoCarroEnviado", method = RequestMethod.GET)
	public ModelAndView cambioEstadoCarroEnviado( @RequestParam(value="idCarro")String  idCarro) throws Exception{
		
		
		carro_b=carro_BService.findByCarro_BIdCarro_b(idCarro);
		if(carro_b.getEnviado())
		  carro_b.setEnviado(false);
		else{ carro_b.setEnviado(true);
		String content="apreciado usuario le informamos que el pago de su pedido numero "+idCarro+" ha sido enviado, en breve recibirá información de la agencia de transportes";
		String subject="pedido: "+idCarro;		
		mail.sendMail( carro_b.getCliente_b().getLogin_usuario_b(), content, carro_b.getCliente_b().getEmail_b(), subject);
		
		}
		carro_BService.update(carro_b);


		ModelAndView mav= new ModelAndView("redirect: verTodosLosPedidos");
	

		return mav;
	}
	@RequestMapping(value="/pagarCarro", method = RequestMethod.GET)
	public ModelAndView pagarCarro( @RequestParam(value="idCarro")String  idCarro,@RequestParam(value="total")String  total) throws Exception{
		
		
		carro_b=carro_BService.findByCarro_BIdCarro_b(idCarro);



		ModelAndView mav= new ModelAndView("carro_b/datosTarjeta");
		mav.addObject("tarjetaCredito", tarjetaCredito);
		mav.addObject("idCarro", carro_b);
		mav.addObject("total", total);
		return mav;
	}
}

	

