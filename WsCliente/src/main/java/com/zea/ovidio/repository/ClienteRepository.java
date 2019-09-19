package com.zea.ovidio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zea.ovidio.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
