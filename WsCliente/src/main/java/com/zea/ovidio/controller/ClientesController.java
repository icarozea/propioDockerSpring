package com.zea.ovidio.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zea.ovidio.model.Cliente;
import com.zea.ovidio.model.Compras;
import com.zea.ovidio.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(value="onlinestore", description="Servicio que sirve para aplicar operaciones sobre los clientes")
public class ClientesController {

	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(value = "Servicio que retorna todos los clientes que hay en la BD")
	@GetMapping("/")
	public ResponseEntity<List<Cliente>> getAllClientes() {

		List<Cliente> clientes = new ArrayList<Cliente>();

		try {
			clientes = clienteService.obtenerClientes();
			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(clientes, HttpStatus.CONFLICT);
		}
	}
	
	@ApiOperation(value = "Servicio que se conecta a WsProductos por medio de JAX-RS")
	@GetMapping("/{idCliente}")
	public ResponseEntity<List<Compras>> getComprasbyCliente(@PathVariable("idCliente") Integer idCliente) {

		List<Compras> compras = new ArrayList<Compras>();

		try {
			compras = clienteService.getComprasbyCliente(idCliente);
			return new ResponseEntity<>(compras, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(compras, HttpStatus.CONFLICT);
		}
	}

}
