package com.llanos.api.repository.service;

import com.llanos.api.dto.UserToken;

public interface TokenService {
	
	UserToken generarToken(String user, String pass);

}
