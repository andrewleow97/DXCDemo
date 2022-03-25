package com.mvc.bean;

public class LoginEmployee {
	private String username;
	private String password;
	private String role; // manager or user
	
	public LoginEmployee() {
		
	}
	
	public LoginEmployee(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public void setRole(String newRole) {
		this.role = newRole;
	}
}
