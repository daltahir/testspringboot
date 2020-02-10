package com.dbravo.model;



public class Mensaje {
private String mensaje;
private UsuarioResponse usuario;

public String getMensaje() {
	return mensaje;
}

public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}

public UsuarioResponse getUsuario() {
	return usuario;
}

public void setUsuario(UsuarioResponse usuario) {
	this.usuario = usuario;
}


}
