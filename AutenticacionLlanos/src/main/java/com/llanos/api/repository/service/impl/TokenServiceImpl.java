package com.llanos.api.repository.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.llanos.api.config.WsProperties;
import com.llanos.api.dto.UserToken;
import com.llanos.api.model.Usuario;
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

	@Override
	public UserToken generarToken(String user, String pass) {
		Usuario usuario = new Usuario();
		UserToken usuarioToken = new UserToken();
		Optional<Usuario> usuarioOp = userRepository.findByUsuario(user);
		if (usuarioOp.isPresent()) {
			usuario = usuarioOp.get();
			if (usuario.getPassword().equals(pass)) {
				usuarioToken.setToken(this.getJWTToken(usuario.getUsuario(), usuario.getRole()));
				usuarioToken.setNombre(usuario.getUsuario());
				usuarioToken.setEstado(Boolean.TRUE);
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
