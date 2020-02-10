package com.dbravo.model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRequest {
	private String name;
	 private String email;
	 private String password;
	 private List<Telefono> phones = new ArrayList <Telefono>();


	 // Getter Methods 

	 public String getName() {
	  return name;
	 }

	 public String getEmail() {
	  return email;
	 }

	 public String getPassword() {
	  return password;
	 }

	 // Setter Methods 

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	 public void setPassword(String password) {
	  this.password = password;
	 }

	public List<Telefono> getPhones() {
		return phones;
	}

	public void setPhones(List<Telefono> phones) {
		this.phones = phones;
	}
}
