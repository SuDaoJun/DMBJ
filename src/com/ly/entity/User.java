package com.ly.entity;

public class User {
	private String id;
	private String username;
	private String password;
	private String date;
	private String content;


	public User(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", date=" + date + ", content=" + content + "]";
	}

	
	
	
	
	
	
}
