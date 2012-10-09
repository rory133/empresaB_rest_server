package org.proyecto.empresaB_rest_server.mvc;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class LoginController {
	
	protected static Logger logger = Logger.getLogger("*en loginController*");
 
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	//public String printWelcome(ModelMap model) {
	public ModelAndView printWelcome(ModelMap model) {
/*		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
	
		model.addAttribute("username", name);
		model.addAttribute("message", "Bienvenido a la pagina de empresaB");
		return "hello";*/
		
	
				//PropertyConfigurator.configure();
				
				logger.info("en requestMapping home**");
				ModelAndView mav =new ModelAndView("home");
				//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				//String name = user.getUsername();
				String name = SecurityContextHolder.getContext().getAuthentication().getName();
				
				mav.addObject("username", name);
				
		        String message=new Date().toString();		        
		        mav.addObject("message", message);
		    //  return new ModelAndView("home","message", message);
		        return mav;
	
	}
 

 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "views/login";
 
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "views/login";
 
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}
	
}
