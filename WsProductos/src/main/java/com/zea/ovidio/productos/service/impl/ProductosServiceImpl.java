package com.zea.ovidio.productos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zea.ovidio.productos.model.Cliente;
import com.zea.ovidio.productos.model.Compras;
import com.zea.ovidio.productos.model.Producto;
import com.zea.ovidio.productos.repository.ComprasRepository;
import com.zea.ovidio.productos.repository.ProductosRepository;
import com.zea.ovidio.productos.service.ProductosService;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	private ProductosRepository productosRepository;

	@Autowired
	private ComprasRepository comprasRepository;

	@Override
	public List<Producto> obtenerProductos() {

		List<Producto> productos = productosRepository.findAll();

		return productos;

	}

	@Override
	public List<Compras> getComprasbyCliente(Integer idCliente) {

		Cliente cliente = new Cliente();
		cliente.setId(idCliente);

		List<Compras> compras = comprasRepository.findByIdCliente(cliente);
		return compras;
	}

}
