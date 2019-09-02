package com.zea.ovidio.productos.service;

import java.util.List;

import com.zea.ovidio.productos.model.Compras;
import com.zea.ovidio.productos.model.Producto;

public interface ProductosService {
	
	List<Producto> obtenerProductos();
	
	List<Compras> getComprasbyCliente(Integer idCliente);
}
