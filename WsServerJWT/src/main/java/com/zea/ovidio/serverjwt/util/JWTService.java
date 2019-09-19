package com.zea.ovidio.serverjwt.util;

import java.io.IOException;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;

public interface JWTService {

	public String create(String username) throws IOException;

}
