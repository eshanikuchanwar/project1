package com.birlasoft.customerportal.model;
/*
 * AdminLogin ValueObject class
 * constructor default and parameterized
 * getter and setter
 */

public class adminLoginVO {
	private String userName;
	
	private String password;
	
	public adminLoginVO() {
		super();
		
	}

	public adminLoginVO(String userName, String password) {
		super();
		this.userName = userName;
		
		this.password = password;
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

	@Override
	public String toString() {
		return "adminLoginVO [userName=" + userName + ", password=" + password + "]";
	}
	
	
	

}
