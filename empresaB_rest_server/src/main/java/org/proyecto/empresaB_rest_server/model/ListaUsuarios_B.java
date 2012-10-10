package org.proyecto.empresaB_rest_server.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "usuarios_b")
public class ListaUsuarios_B {
	
	private List<Usuario_B> usuarios_b;

	public ListaUsuarios_B() {

	}

	public ListaUsuarios_B(List<Usuario_B> usuarios_b) {
		super();
		this.usuarios_b = usuarios_b;
	}
	//@XmlElement(name = "usuario_b")
	public List<Usuario_B> getUsuarios_b() {
		return usuarios_b;
	}

	public void setUsuarios_b(List<Usuario_B> usuarios_b) {
		this.usuarios_b = usuarios_b;
	}
	
	
	

}
