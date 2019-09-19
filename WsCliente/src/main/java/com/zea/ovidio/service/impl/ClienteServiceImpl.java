package com.zea.ovidio.service.impl;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zea.ovidio.model.Cliente;
import com.zea.ovidio.model.Compras;
import com.zea.ovidio.repository.ClienteRepository;
import com.zea.ovidio.repository.ProductosRestRepository;
import com.zea.ovidio.service.ClienteService;



@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProductosRestRepository productosRestRepository;

	@Override
	public List<Cliente> obtenerClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		
		return clientes;
	}

	@Override
	public List<Compras> getComprasbyCliente(Integer idCliente) {
		List<Compras> compras = new ArrayList<Compras>();
		try {
			compras = productosRestRepository.getComprasByIdCliente(idCliente);
		} catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compras;
	}

}
