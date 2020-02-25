package com.cpg.onlinetestmanagement.bean;

import java.util.Map;

public class User {

	private Long userId;
	private String userName;
	private String userPassword;
	private Boolean isAdmin;
	private Test userTest;


	public User(String userName, String userPassword, Boolean isAdmin , Test userTest) {
		
		//this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.isAdmin = isAdmin;
		this.userTest = userTest;
	}
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Test getUserTest() {
		return userTest;
	}
	public void setUserTest(Test userTest) {
		this.userTest = userTest;
	}
	
	
}


