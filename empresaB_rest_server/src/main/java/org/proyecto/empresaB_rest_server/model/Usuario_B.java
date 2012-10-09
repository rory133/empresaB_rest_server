package org.proyecto.empresaB_rest_server.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;


/*@Entity
@Table(name = "usuario_b")*/

@Entity
@Table(name = "usuario_b")
@Inheritance(strategy=InheritanceType.JOINED)
 public class Usuario_B implements Serializable {
	
	private static final long serialVersionUID = -5527566244002296042L;
	
  public Usuario_B() {

	}


  
  @Id
  @Column(name = "IDUSUARIOS_B")
  @GeneratedValue
  private Integer idusuarios_b;
  
  
  @Pattern(regexp="[0-9]{8}[A-Za-z]?", message="formato incorrecto del DNI o NIF") 
  @Column(name = "DNI_NIF_B")
  private String dni_nif_b;
  
  
  
  @NotNull
  @Size(min = 4, max = 15, message= "el login tiene que tener entre 4 y 15 caracteres")
  @Column(name = "LOGIN_USUARIO_B")
  private String login_usuario_b;
  
  
  @NotNull
  @Size(min = 4, max = 15, message= "el password tiene que tener entre 4 y 10 caracteres")
  @Column(name = "PASSWORD_B")
  private String password_b;
  
  @Size(min = 2, max = 45, message= "el nombre tiene que tener al menos dos caracteres")
  @NotNull ( message= "el nombre de cliente no puede estar vacio")
  @Column(name = "NOMBRE_B")
  private String nombre_b;
  
  @Size(min = 2, max = 45, message= "el apellido tiene que tener al menos dos caracteres")
  @NotNull ( message= "el apellido no puede estar vacio")
  @Column(name = "APELLIDOS_B")
  private String apellidos_b;
  
  
  @NotNull
  @Size(min = 5, max = 45, message= "se debe incluir un email")
  @Email (message="formato de email invalido")
  @Column(name = "EMAIL_B")
  private String email_b;

  
  @Column(name = "AUTHORITY")
  private String AUTHORITY;
  
  
  
  @Column(name = "ENABLED")
  private Boolean ENABLED;
  




	public Integer getIdusuarios_b() {
		return idusuarios_b;
	}
	
	public void setIdusuarios_b(Integer idusuarios_b) {
		this.idusuarios_b = idusuarios_b;
	}
	
	public String getDni_nif_b() {
		return dni_nif_b;
	}
	
	public void setDni_nif_b(String dni_nif_b) {
		this.dni_nif_b = dni_nif_b;
	}
	

	
	public String getLogin_usuario_b() {
		return login_usuario_b;
	}

	public void setLogin_usuario_b(String login_usuario_b) {
		this.login_usuario_b = login_usuario_b;
	}

	public String getPassword_b() {
		return password_b;
	}

	public void setPassword_b(String password_b) {
		this.password_b = password_b;
	}

	public String getNombre_b() {
		return nombre_b;
	}
	
	public void setNombre_b(String nombre_b) {
		this.nombre_b = nombre_b;
	}
	
	public String getApellidos_b() {
		return apellidos_b;
	}
	
	public void setApellidos_b(String apellidos_b) {
		this.apellidos_b = apellidos_b;
	}
	
	public String getEmail_b() {
		return email_b;
	}
	
	public void setEmail_b(String email_b) {
		this.email_b = email_b;
	
	}
	
	public String getAUTHORITY() {
	return AUTHORITY;
	}

	public void setAUTHORITY(String aUTHORITY) {
		AUTHORITY = aUTHORITY;
	}

	public Boolean getENABLED() {
		return ENABLED;
	}

	public void setENABLED(Boolean eNABLED) {
		ENABLED = eNABLED;
	}


}

