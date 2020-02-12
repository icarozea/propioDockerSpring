package com.llanos.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.llanos.api.model.Usuario;

@Repository
public interface UserRepository  extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByUsuario(String usuario);

}
