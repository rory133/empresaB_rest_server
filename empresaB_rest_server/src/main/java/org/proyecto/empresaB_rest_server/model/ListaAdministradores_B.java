package org.proyecto.empresaB_rest_server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "listaAdministradores")
public class ListaAdministradores_B {
	private List<Administrador_B> dataAdministrador;

	public List<Administrador_B> getDataAdministrador() {
		return dataAdministrador;
	}

	public void setDataAdministrador(List<Administrador_B> dataAdministrador) {
		this.dataAdministrador = dataAdministrador;
	}



	

}
