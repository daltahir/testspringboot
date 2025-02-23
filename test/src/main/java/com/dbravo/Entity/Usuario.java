package com.dbravo.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 8217323921524913270L;
	
	public Usuario() {
		id = UUID.randomUUID().toString();
	}
	
	
	@Id
	private String id;
	@Column(name = "name", nullable = false)
	 private String name;
	
	@Column(name = "email", nullable = false, unique=true)
	 private String email;
	
	@Column(name = "password", nullable = false)
	 private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = true)
	@CreatedDate
	 private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@Column(name = "modified", nullable = true)
	 private Date modified;
	
	
	@Column(name = "last_login", nullable = true)
	 private Date last_login;
	
	@Column(name = "token", nullable = true)
	 private String token;
	
	@Column(name = "isactive", nullable = true)
	 private boolean isactive;

	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
