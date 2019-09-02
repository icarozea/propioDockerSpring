package com.zea.ovidio.productos.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zea.ovidio.productos.model.Compras;
import com.zea.ovidio.productos.model.Producto;
import com.zea.ovidio.productos.service.ProductosService;

@RestController
@RequestMapping("/productos")
public class ProductosController {

	@Autowired
	private ProductosService productosService;

	@GetMapping("/")
	public ResponseEntity<List<Producto>> getAllProductos() {

		List<Producto> productos = new ArrayList<Producto>();

		try {
			productos = productosService.obtenerProductos();
			return new ResponseEntity<>(productos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(productos, HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/{idCliente}")
	public ResponseEntity<List<Compras>> getComprasbyCliente(@PathVariable("idCliente") Integer idCliente) {

		List<Compras> compras = new ArrayList<Compras>();

		try {
			compras = productosService.getComprasbyCliente(idCliente);
			return new ResponseEntity<>(compras, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(compras, HttpStatus.CONFLICT);
		}
	}

//	@SuppressWarnings("rawtypes")
//	@PostMapping("/save")
//	public ResponseEntity<Respuesta> save(@RequestBody Menus menu) {
//		Respuesta<Menus> respuesta = new Respuesta<Menus>();
//
//		try {
//			menusService.save(respuesta, menu);
//			return new ResponseEntity<>(respuesta, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(respuesta, HttpStatus.CONFLICT);
//		}
//	}

}
