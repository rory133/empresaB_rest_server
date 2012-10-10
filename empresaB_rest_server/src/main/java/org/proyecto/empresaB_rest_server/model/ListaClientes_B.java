package org.proyecto.empresaB_rest_server.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clientes_b")
public class ListaClientes_B {

	private List<Cliente_B> clientes_b;

		public ListaClientes_B() {

		}

		public ListaClientes_B(List<Cliente_B> clientes_b) {
			super();
			this.clientes_b = clientes_b;
		}
		
		public List<Cliente_B> getClientes_b() {
			return clientes_b;
		}
		
		public void setClientes_b(List<Cliente_B> clientes_b) {
			this.clientes_b = clientes_b;
		}
		
		
		

	}