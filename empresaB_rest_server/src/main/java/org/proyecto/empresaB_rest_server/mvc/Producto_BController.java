package org.proyecto.empresaB_rest_server.mvc;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.proyecto.empresaB_rest_server.bo.Producto_BBo;
import org.proyecto.empresaB_rest_server.bo.impl.Producto_BBoImpl;
import org.proyecto.empresaB_rest_server.exception.GenericException;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.service.Productos_BService;
import org.proyecto.empresaB_rest_server.service.impl.Productos_BServiceImpl;
import org.proyecto.empresaB_rest_server.util.UtilidadesImagen;




@Controller
@RequestMapping("/productos")
public class Producto_BController {

	@Autowired
	private Productos_BServiceImpl productos_BServiceImpl;
	

	
	

	
	@Autowired
	ServletContext context;
	
	
	
	

	
	protected static Logger logger = Logger.getLogger("*en Producto_BController*");
		
	
	
	
	
	
	@RequestMapping(value="/listado",method=RequestMethod.GET)
	public ModelAndView listadoProductos_B(){
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		logger.info("en listadoProductos_B2*");
		
		logger.info("tamaño lista en listado: "+lista.size());
		

	   return new ModelAndView("producto_b/listaProductos","productos", lista);
	}
	
	
	@RequestMapping(value="/listado2",method=RequestMethod.GET, headers={"Accept=application/xml, application/json"})
	public List<Producto_B> listado2Productos_B(){
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		logger.info("en listadoProductos_B2*");

		return lista;
	   //return new ModelAndView("producto_b/listaProductos","productos", lista);
	}
	
	/*@RequestMapping(value = "/add", method = RequestMethod.GET)*/
	@RequestMapping(value="/admin/" ,method = RequestMethod.GET, params="new")
	public ModelAndView addContact() {
		logger.info("metodo get --new-- ");
		return new ModelAndView("producto_b/edit", "producto_b",new Producto_B());
	  }
	
	
	

	//@RequestMapping(method = RequestMethod.POST)
	
	
	//public ModelAndView modProducto_B_form(@Valid @ModelAttribute("producto_b")Producto_B producto_b,  BindingResult  result,@RequestParam(value="image",required=false)MultipartFile image, HttpServletRequest request){
	@RequestMapping(value="/admin/modificarProductoB", method = RequestMethod.POST)
	public ModelAndView modProducto_B_form(@Valid @ModelAttribute("producto_b")Producto_B producto_b,  BindingResult  result,@RequestParam(value="image",required=false)MultipartFile image)throws Exception{

		
		if(result.hasErrors()) {
		logger.info("modificarProducto_B_form ------tiene errores----"+result.toString());
			return new ModelAndView("producto_b/modificar", "producto_b",producto_b).addAllObjects(result.getModel());
		}

	/*		CODIGO DE CUANDO NO MOSTRABA Ñss
		logger.info("modificarProducto_B_form ------NO tiene errores----");
		logger.info("nombre producto a añadir "+ producto_b.getNombre_productoB());
		//productos_BServiceImpl.save(producto_b);
		logger.info("modificarProducto_B_form ");
		String nombre =producto_b.getNombre_productoB();
		//String nombre =new String();
		try {
		logger.info("el nombre insertado en try antes de cambio: "+nombre);
		nombre =new String (producto_b.getNombre_productoB().getBytes("ISO-8859-1"),"UTF-8");
		//nombre =new String (producto_b.getNombre_productoB().getBytes("UTF-8"),"ISO-8859-1");
		//nombre =new String (nombre1.getBytes("ISO-8859-1"),"UTF-8");
		
		logger.info("el nombre insertado en try despue de cambio: "+nombre);
		} catch(UnsupportedEncodingException uee) {
		    uee.printStackTrace();
		}
		
		
		logger.info("el nombre modificado-update fuera try: "+nombre);
		producto_b.setNombre_productoB(nombre);
		
		*/
			if(image.isEmpty())
			productos_BServiceImpl.update(producto_b);
			
			
		try{
			if(!image.isEmpty()){
				
				//byte[] bFile = new byte[image.getBytes().length];
				logger.info("en try antes de validar imagen en modificar ");
				validarImagen (image);
				logger.info("en try despues de validar imagen en modificar ");
				saveImage(producto_b.getIdproductob()+".jpg",image);
				productos_BServiceImpl.update(producto_b);
				//producto_b.setImagen_b(bFile);
/*				logger.info("request.getparametrermap"+request.getParameterMap().toString());

				logger.info("request.getPathInfo()"+ request.getPathInfo());
				logger.info("request.getPathTranslated()" + request.getPathTranslated());*/
				
				logger.info("salvando imagen "+ producto_b.getIdproductob() +"en try ");
			}
			
		}catch (Exception e){
			result.reject(e.getMessage());
		   return new ModelAndView("producto_b/modificar", "producto_b", producto_b).addAllObjects(result.getModel());
		}
		

		
		logger.info("udpdateProducto_B_form ");
		/*
		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		return new ModelAndView("producto_b/listaProductos","productos", lista);
		*/

		return new ModelAndView("redirect:../listado");
	
	
}
	
	
	@RequestMapping(value="/admin/edit",method=RequestMethod.GET)
	public ModelAndView editProducto_B_form(String id){


		Producto_B productob=new Producto_B();
		productob=	productos_BServiceImpl.findByProducto_BIdProducto_b(id);
		
		logger.info("producto pasado a edit-modificar: "+productob.getNombre_productoB());
		
		
		//List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		//return new ModelAndView("producto_b/listaProductos","productos", lista);
		return new ModelAndView("producto_b/modificar", "producto_b",productob);
	
}
	
	
	//@RequestMapping(value="/crearProductoB", method = RequestMethod.POST)
	
	//public ModelAndView addProducto_B_form(@Valid @ModelAttribute("producto_b")Producto_B producto_b, BindingResult  result,@RequestParam(value="image",required=false)MultipartFile image, HttpServletRequest request){
	@RequestMapping(value="/admin/crearProductoB",method = RequestMethod.POST)
	public ModelAndView addProducto_B_form(@Valid @ModelAttribute("producto_b")Producto_B producto_b, BindingResult  result,@RequestParam(value="image",required=false)MultipartFile image) throws Exception{


		logger.info("inicio de addProducto_B_form");
		if(result.hasErrors()) {
		logger.info("addProducto_B_form ------tiene errores----"+result.toString());
		logger.info("errores: "+result.toString());
		 return new ModelAndView("producto_b/edit", "producto_b",new Producto_B()).addAllObjects(result.getModel());

		}

		/*				CODIGO DE CUANDO NO MOSTRABA LAS Ñs---
		logger.info("addProducto_B_form ------NO tiene errores----");
		logger.info("nombre producto a añadir "+ producto_b.getNombre_productoB());
		//productos_BServiceImpl.save(producto_b);
		logger.info("addProducto_B_form ");
		
		
		String nombre =producto_b.getNombre_productoB();
		try {
		logger.info("el nombre insertado en try antes de cambio"+nombre);
		nombre =new String (producto_b.getNombre_productoB().getBytes("ISO-8859-1"),"UTF-8");
		
		logger.info("el nombre insertado en try despue de cambio"+nombre);
		} catch(UnsupportedEncodingException uee) {
		    uee.printStackTrace();
		}
		logger.info("el nombre insertado en add-save fuera try"+nombre);
		producto_b.setNombre_productoB(nombre);
		*/
		
		if(image.isEmpty())
		productos_BServiceImpl.save(producto_b);
		
		

		
		try{
			if(!image.isEmpty()){
				productos_BServiceImpl.save(producto_b);
				//byte[] bFile = new byte[image.getBytes().length];
				logger.info("antes de validar imagen en addProducto_B_form");
				validarImagen (image);
				logger.info("despues de validar imagen en addProducto_B_form");
				logger.info("salvando imagen "+ producto_b.getIdproductob() +"en try ");
				saveImage(producto_b.getIdproductob()+".jpg",image);
				
				//producto_b.setImagen_b(bFile);
/*				logger.info("request.getparametrermap"+request.getParameterMap().toString());

				logger.info("request.getPathInfo()"+ request.getPathInfo());
				logger.info("request.getPathTranslated()" + request.getPathTranslated());*/
				
				logger.info("salvando imagen "+ producto_b.getIdproductob() +"en try ");
			}
			
		}catch (Exception e){
			result.reject(e.getMessage()+"aqui");
			return new ModelAndView("producto_b/edit", "producto_b",new Producto_B()).addAllObjects(result.getModel());

		}
		

		
		logger.info("addProducto_B_form ");
		
		
		
/*		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		return new ModelAndView("producto_b/listaProductos","productos", lista);*/
		return new ModelAndView("redirect:../listado");
		
		
	
}
	
	@RequestMapping(value="/admin/borrar",method=RequestMethod.GET)
	public ModelAndView delProducto_B_form(String id){

		logger.info("en borrar producto con id: "+id);
		Producto_B productob=new Producto_B();
		productob=	productos_BServiceImpl.findByProducto_BIdProducto_b(id);
		
		logger.info("borrando producto : "+productob.getNombre_productoB());
		productos_BServiceImpl.delete(productob);
		
/*		List<Producto_B> lista =productos_BServiceImpl.getProductos_B();
		return new ModelAndView("producto_b/listaProductos","productos", lista);*/
		return new ModelAndView("redirect:../listado");
		//return new ModelAndView("producto_b/modificar", "producto_b",productob);
	
}
	

   //private void saveImage(String filename, MultipartFile image)throws RuntimeException{
	private void saveImage(String filename, MultipartFile image)throws GenericException{
	
	try{
		
		//File file = new File(context.getRealPath("/")+"WEB-INF\\resources\\imagenes\\"+ filename);
		
		File file = new File("C:\\imagenes\\empresaB_rest_server\\"+ filename);
		logger.info("context.getRealPath(/)+/resources/imagenes/::::::::::::::::"+file);
		
		
		
		
		FileUtils.writeByteArrayToFile(file,image.getBytes());
		logger.info("salvando imagen en trye de saveimage "+ file.getName() +"en try ");
	}catch (IOException e){
		//throw new RuntimeException ("no se puede cargar la imagen");
		throw new GenericException("Oppss...System error, please visit it later");
		}
	}
   
	
	
	
   private void validarImagen (MultipartFile image){
	   if((image.getContentType().equals("image/jpeg"))||(image.getContentType().equals("image/pjpeg"))
			   ||(image.getContentType().equals("image/jpg"))||(image.getContentType().equals("image/x-png"))){
		   logger.info("tipo imagen :"+ image.getContentType());
	   }
	   else{
		   logger.info("tipo imagen :"+ image.getContentType());
		   throw new GenericException("la imagen no es jpg");
		   
	   }
	   
	 }

	
}