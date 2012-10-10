package org.proyecto.empresaB_rest_server.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement(name="cliente_b")
@Entity
@Table(name = "cliente_b")
@PrimaryKeyJoinColumn(name="IDUSUARIOS_B")
public class Cliente_B  extends Usuario_B implements Serializable {
	private static final long serialVersionUID = -5527566244002296042L;
	
	@Column(name = "FECHA_ALTA_B")
	private Date fecha_alta_b;
	 
	
	@Size(min = 2, max = 15, message= "tienes que introducir una direccion")
	@Column(name = "DIRECCION_B")
	private String direccion_b;
	
	@Column(name = "PROVINCIA_B")
	private String provincia_b;
	
	@Pattern(regexp="[0-9]{5}", message="el codigo postal corresponde a 5 numeros") 
	@Column(name = "CODIGOPOSTAL_B")
	private String codigopostal_b;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente_b")
	private Set<Carro_B> carro_b = new HashSet<Carro_B>(0);
	
	
	
	
	
	public Cliente_B() {
	}

	
	
	
	public Date getFecha_alta_b() {
		return fecha_alta_b;
	}
	@XmlElement
	public void setFecha_alta_b(Date fecha_alta_b) {
		this.fecha_alta_b = fecha_alta_b;
	}
	
	
	
	
	public String getDireccion_b() {
		return direccion_b;
	}



	//@XmlElement
	public void setDireccion_b(String direccion_b) {
		this.direccion_b = direccion_b;
	}




	public String getProvincia_b() {
		return provincia_b;
	}



	//@XmlElement
	public void setProvincia_b(String provincia_b) {
		this.provincia_b = provincia_b;
	}




	public String getCodigopostal_b() {
		return codigopostal_b;
	}



	//@XmlElement
	public void setCodigopostal_b(String codigopostal_b) {
		this.codigopostal_b = codigopostal_b;
	}



	//@XmlElement
	public Set<Carro_B> getCarro_b() {
		return carro_b;
	}

	public void setCarro_b(Set<Carro_B> carro_b) {
		this.carro_b = carro_b;
	}

	  
	
}

