package com.dbravo.model;

import java.util.Date;
import java.util.UUID;

import com.dbravo.Entity.Usuario;

public class UsuarioResponse {
private String id;
private Date created;
private Date modified;
private Date last_login;
private String token;
private boolean isactive;

public UsuarioResponse(Usuario usuario) {
	this.id=usuario.getId();
	this.isactive=usuario.getIsactive();
	this.created=usuario.getCreated();
	this.modified=usuario.getModified();
	this.last_login=usuario.getLast_login();
	this.token=usuario.getToken();
			
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public Date getModified() {
	return modified;
}
public void setModified(Date modified) {
	this.modified = modified;
}
public Date getLast_login() {
	return last_login;
}
public void setLast_login(Date last_login) {
	this.last_login = last_login;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}
public boolean getIsactive() {
	return isactive;
}
public void setIsactive(boolean isactive) {
	this.isactive = isactive;
}
}
