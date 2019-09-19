package com.zea.ovidio.serverjwt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zea.ovidio.serverjwt.model.User;
import com.zea.ovidio.serverjwt.util.JWTService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private JWTService jwtService;

	@PostMapping("/user")
	public ResponseEntity<User> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

		User user = new User();
		try {
			user.setUser(username);
			user.setToken(jwtService.create(username));
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(user, HttpStatus.CONFLICT);
		}

	}

}
