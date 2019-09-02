package com.zea.ovidio.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zea.ovidio.productos.model.Cliente;
import com.zea.ovidio.productos.model.Compras;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Cliente>{
	
	public List<Compras> findByIdCliente(Cliente cliente);

}
