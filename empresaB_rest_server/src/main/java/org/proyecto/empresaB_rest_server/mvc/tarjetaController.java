package org.proyecto.empresaB_rest_server.mvc;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.proyecto.empresaB_rest_server.model.Carro_B;
import org.proyecto.empresaB_rest_server.model.Producto_B;
import org.proyecto.empresaB_rest_server.model.TarjetaCredito;
import org.proyecto.empresaB_rest_server.service.impl.Carro_BServiceImpl;
import org.proyecto.empresaB_rest_server.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/tarjeta")
public class tarjetaController {
	
	@Autowired
	private Carro_B carro_b;
	
	@Autowired
	Carro_BServiceImpl carro_BService;
	
	@Autowired
	private Mail mail;
	
	protected static Logger logger = Logger.getLogger("*en tarjetaController*");
	

	
	@RequestMapping(value="/validarTarjeta", method = RequestMethod.POST)
	public ModelAndView validarTarjeta(@Valid @ModelAttribute("tarjetaCredito")TarjetaCredito tarjetaCredito,  BindingResult  result, @RequestParam(value="idCarro")String  idCarro, HttpSession session)throws Exception{

		carro_b=carro_BService.findByCarro_BIdCarro_b(idCarro);
		
		if(result.hasErrors()) {
			logger.info("validarTarjeta:---tiene errores----"+result.toString());
				
				ModelAndView mav= new ModelAndView("carro_b/datosTarjeta");
				mav.addObject("tarjetaCredito", tarjetaCredito);
				mav.addAllObjects(result.getModel());
				mav.addObject("carro", carro_b);
				return mav;
			}
		carro_b.setPagado(true);
		carro_BService.update(carro_b);
		
		String content="apreciado usuario le informamos que el pago de su pedido numero "+idCarro+" se ha realizado con exito, en breve le informaremos al realziar el envio";
		String subject="pedido: "+idCarro;		
		mail.sendMail( carro_b.getCliente_b().getLogin_usuario_b(), content, carro_b.getCliente_b().getEmail_b(), subject);
		
		
		session.removeAttribute("carro_b");
		ModelAndView mav= new ModelAndView("redirect: ../../../carro/verTodosLosPedidos");
		return mav;
		
  }
}