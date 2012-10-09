package org.proyecto.empresaB_rest_server.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service("mail")
public class Mail {
	
	@Autowired
	JavaMailSender mailSender;
	//private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

/*	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}*/
	
	public void sendMail(String dear, String content, String to, String subject) {

		//SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setFrom("noreply@empresaB.com");
		message.setSubject(subject);
/*		message.setText(String.format(
				simpleMailMessage.getText(), dear, content));*/
		message.setText(dear+", "+ content);
		

		mailSender.send(message);
		
	}
	
	
}