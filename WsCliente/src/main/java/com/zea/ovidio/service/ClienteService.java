package com.zea.ovidio.service;

import java.util.List;

import com.zea.ovidio.model.Cliente;
import com.zea.ovidio.model.Compras;

public interface ClienteService {
	
	List<Cliente> obtenerClientes();
	
	List<Compras> getComprasbyCliente(Integer idCliente);
}
