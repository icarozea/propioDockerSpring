package com.llanos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.llanos.api.dto.UserToken;
import com.llanos.api.repository.service.TokenService;

/**
 * 
 * ###############################################################
 * 
 * @author Ovidio Zea
 * @Date 10/02/2020
 * @Company llanosOil
 * @Text Clase encargada de servir como controlador al servicio de Unidad de
 *       negocio
 * @Class AutenticationController
 * @Name_Proyect AutenticacionLlanos
 *               ################################################################
 */
@RestController
@RequestMapping("/oauth")
@CrossOrigin(origins = "*")

public class AutenticationController {

	@Autowired
	private TokenService tokenService;


	@PostMapping("/")
	public ResponseEntity<UserToken> save(@RequestParam("user") String user, @RequestParam("pass") String pass) {
		UserToken userToken = new UserToken();

		try {
			userToken = tokenService.generarToken(user, pass);
			return new ResponseEntity<>(userToken, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(userToken, HttpStatus.CONFLICT);
		}
	}

}
