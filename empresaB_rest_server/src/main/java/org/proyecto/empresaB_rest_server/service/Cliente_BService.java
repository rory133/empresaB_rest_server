package org.proyecto.empresaB_rest_server.service;

import java.util.List;

import org.proyecto.empresaB_rest_server.model.Cliente_B;
import org.proyecto.empresaB_rest_server.model.Usuario_B;

public interface Cliente_BService {
	
	void save(Cliente_B cliente_B);	
	void update(Cliente_B cliente_B);	
	void delete(Cliente_B cliente_B);	
	Cliente_B findByCliente_BIdCliente_b(String Cliente_BIdCliente_b);
	Usuario_B findByCliente_B_login_usuario_b(String cliente_B_login_usuario_b);
	List<Cliente_B> findAll ();

}
