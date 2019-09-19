package com.zea.ovidio.serverjwt.util;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTServiceImpl implements JWTService {

	public static final String SECRET = Base64Utils.encodeToString("Alguna.Clave.Secreta.123456".getBytes());

	public static final long EXPIRATION_DATE = 14000000L;
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";

	@Override
	public String create(String username) throws IOException {

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		Claims claims = Jwts.claims();
		
		claims.put("authorities", new ObjectMapper().writeValueAsString(grantedAuthorities));

		String token = Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE)).compact();


		return TOKEN_PREFIX + " " + token;
	}

}
