package com.llanos.api.repository.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.llanos.api.config.WsProperties;
import com.llanos.api.dto.UserToken;
import com.llanos.api.model.UserContractor;
import com.llanos.api.repository.UserRepository;
import com.llanos.api.repository.service.TokenService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private WsProperties wsproperties;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserToken generarToken(String user, String pass) {
		UserContractor usuario = new UserContractor();
		UserToken usuarioToken = new UserToken();
		List<UserContractor> usuariosBD = userRepository.findByEmail(user);
		if (usuariosBD.size()>0) {
			usuario = usuariosBD.get(0);
			
			if (BCrypt.checkpw(pass, usuario.getPassword())) {
				usuarioToken.setToken(this.getJWTToken(usuario.getName(), "ADMIN"));
				usuarioToken.setNombre(usuario.getName().toString());
				usuarioToken.setEstado(Boolean.TRUE);
			}else {
				throw new RuntimeException("Error el password no concide");
			}

		}
		return usuarioToken;
	}

	private String getJWTToken(String username, String role) {

		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_".concat(role));
		Long now = System.currentTimeMillis();
		String token = Jwts.builder().setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(now + wsproperties.getExpiration() * 1000)).signWith(SignatureAlgorithm.HS512,
						Base64Utils.encodeToString(wsproperties.getSecret().getBytes()).getBytes())
				.compact();

		return wsproperties.getPrefix().concat(" ").concat(token);
	}

}
