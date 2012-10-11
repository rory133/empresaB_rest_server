package org.proyecto.empresaB_rest_server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "listaClientes")
public class ListaClientes_B {


	private List<Cliente_B> dataCliente;

	public List<Cliente_B> getDataCliente() {
		return dataCliente;
	}

	public void setDataCliente(List<Cliente_B> dataCliente) {
		this.dataCliente = dataCliente;
	}



		
		

	}