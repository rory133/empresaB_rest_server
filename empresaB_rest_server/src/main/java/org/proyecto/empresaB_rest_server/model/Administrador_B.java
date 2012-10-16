package org.proyecto.empresaB_rest_server.model;

import java.io.Serializable;




import javax.persistence.Entity;

import javax.persistence.Column;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"idusuarios_b", "login_usuario_b","nombre_b","apellidos_b","dni_nif_b","email_b","AUTHORITY","ENABLED","password_b","cargo_b","matricula_b"})

@Entity
@Table(name = "administrador_b")
@PrimaryKeyJoinColumn(name="IDUSUARIOS_B")
public class Administrador_B  extends Usuario_B implements Serializable {
	private static final long serialVersionUID = -5527566244002296042L;
	
	@Size(min = 2, max = 15, message= "tienes que introducir un cargo")
	@Column(name = "CARGO_B")
	private String cargo_b;
	
	@Size(min = 2, max = 8, message= "tienes que introducir una matricula")
	@Column(name = "MATRICULA_B")
	private String matricula_b;
	
	
	public Administrador_B() {
	}


	public String getCargo_b() {
		return cargo_b;
	}


	public void setCargo_b(String cargo_b) {
		this.cargo_b = cargo_b;
	}


	public String getMatricula_b() {
		return matricula_b;
	}


	public void setMatricula_b(String matricula_b) {
		this.matricula_b = matricula_b;
	}





	

	  
	  
	
}

