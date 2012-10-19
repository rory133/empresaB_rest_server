package org.proyecto.empresaB_rest_server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "carros_b")
public class ListaCarros_B {
	private List<Carro_B> dataCarro;

	public List<Carro_B> getDataCarro() {
		return dataCarro;
	}

	public void setDataCarro(List<Carro_B> dataCarro) {
		this.dataCarro = dataCarro;
	}
	
	
	

}
