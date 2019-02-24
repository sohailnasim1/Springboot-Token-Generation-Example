/*
 * Stores the username and password
 * 
 * @author Sohail Nasim
 */
package com.sn.auth.security;

import java.io.Serializable;

public class LoginCredentials implements Serializable {

	private static final long serialVersionUID = 1L;

	public LoginCredentials(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	public LoginCredentials() {
		
	}
	
	private String username;
	private String password;
	
	private void setUsername(String username) {
		this.username = username;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
}
