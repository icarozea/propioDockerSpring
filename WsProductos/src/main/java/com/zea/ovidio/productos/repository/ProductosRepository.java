package com.zea.ovidio.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zea.ovidio.productos.model.Producto;

@Repository
public interface ProductosRepository extends JpaRepository<Producto, Integer>{

}
