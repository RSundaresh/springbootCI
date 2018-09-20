package com.samples.jwtauth.dto;

public class UserCountInfo {
	
	private String username;
	private Long idcount;
	private String passwd;
	
	public UserCountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserCountInfo(String username, Long idcount, String password) {
		super();
		this.username = username;
		this.idcount = idcount;
		this.passwd = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getIdcount() {
		return idcount;
	}
	public void setIdcount(Long idcount) {
		this.idcount = idcount;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String password) {
		this.passwd = password;
	}
	}
