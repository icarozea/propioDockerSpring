package com.llanos.api.dto;

public class UserToken {

	private Boolean estado;
	private String nombre;
	private String password;
	private String token;

	public UserToken() {
		super();
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserToken [estado=");
		builder.append(estado);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", password=");
		builder.append(password);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}

}
