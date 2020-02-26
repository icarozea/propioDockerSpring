package com.llanos.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@Autowired
	private DefaultTokenServices tokenServices;


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
	
	@GetMapping("/logout")
	public ResponseEntity<Boolean> logoutPage(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		String tokenValue = authHeader.replace("bearer", "").trim();
		tokenServices.revokeToken(tokenValue);
		tokenServices.setAccessTokenValiditySeconds(1);
		tokenServices.setRefreshTokenValiditySeconds(1);
		return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		
	}

}
