package com.beopentit.hackathon.security.config;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {
	
	public User() {
		
	}
	
    public User(int i, String username, String password, String email) {
		this.id=i;
    	this.userName=username;
		this.password=password;
		this.email=email;
	}
	@Id
    private int id;
    private String userName;
    private String password;
    private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
