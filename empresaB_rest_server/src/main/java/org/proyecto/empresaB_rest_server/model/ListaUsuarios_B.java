package org.proyecto.empresaB_rest_server.model;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuarios_b")
public class ListaUsuarios_B {

	private List<Usuario_B> dataUsuario;

	public List<Usuario_B> getDataUsuario() {
		return dataUsuario;
	}

	public void setDataUsuario(List<Usuario_B> dataUsuario) {
		this.dataUsuario = dataUsuario;
	}




	
}