package com.employee.management.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_login_credentials")
public class User {

	@Id
	private String username;
	@Column(name="keyvalue")
	private String password;
	private boolean isActive=true;
	private String roles;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String keyvalue) {
		this.password = keyvalue;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [Username=" + username + ", keyvalue=" + password + ", isActive=" + isActive + ", roles=" + roles
				+ "]";
	}
	
	
}
