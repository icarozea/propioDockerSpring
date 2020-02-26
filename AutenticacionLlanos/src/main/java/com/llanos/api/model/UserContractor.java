package com.llanos.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "usuario")
public class UserContractor {

	@Id
	// @JsonIgnore
	@Field("_id")
	private String id;

	@Field("nombre")
	private String name;

	@Field("direccion")
	private String address;

	@Field("numeroDocumento")
	private String document;

	@Field("teelefono")
	private String phone;

	@Field("email")
	private String email;

	@Field("idempresa")
	@JsonIgnore
	private String company;

	@Field("password")
	private String password;

	@Field("estado")
	private String state;

	@Field("id_rol")
	@JsonIgnore
	private String id_rol;

	private String idContratista;

	public UserContractor() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getId_rol() {
		return id_rol;
	}

	public void setId_rol(String id_rol) {
		this.id_rol = id_rol;
	}

	public String getIdContratista() {
		return idContratista;
	}

	public void setIdContratista(String idContratista) {
		this.idContratista = idContratista;
	}

}
