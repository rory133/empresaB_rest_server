package org.proyecto.empresaB_rest_server.model;

import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service("tarjetaCredito")
public class TarjetaCredito {
	
	
	@Pattern(regexp="[0-9]{4}", message="numero tarjeta incorrecto")
	String digitos1;
	@Pattern(regexp="[0-9]{4}", message="numero tarjeta incorrecto")
	String digitos2;
	@Pattern(regexp="[0-9]{4}", message="numero tarjeta incorrecto")
	String digitos3;
	@Pattern(regexp="[0-9]{4}", message="numero tarjeta incorrecto")
	String digitos4;
	
	@Pattern(regexp="0[1-9]|1[012]", message="formato de mes incorrecto")
	String mes;
	@Pattern(regexp="(20)[0-9]{2}", message="formato de año incorrecto")	
	String anno;
	
	
	Integer idCarro;
	
	
	
	
	public TarjetaCredito() {

	}
	public String getDigitos1() {
		return digitos1;
	}
	public void setDigitos1(String digitos1) {
		this.digitos1 = digitos1;
	}
	public String getDigitos2() {
		return digitos2;
	}
	public void setDigitos2(String digitos2) {
		this.digitos2 = digitos2;
	}
	public String getDigitos3() {
		return digitos3;
	}
	public void setDigitos3(String digitos3) {
		this.digitos3 = digitos3;
	}
	public String getDigitos4() {
		return digitos4;
	}
	public void setDigitos4(String digitos4) {
		this.digitos4 = digitos4;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}
	public Integer getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	
	
	
	

}
