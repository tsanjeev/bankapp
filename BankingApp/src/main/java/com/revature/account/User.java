package com.revature.account;

import java.io.Serializable;

public class User implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482258227837614516L;
	
	private String userName;
	private String password;
	private int customerId;

	public User() {
		
	}
	
	
	public User(String userName, String password, int customerId) {
		this.userName = userName;
		this.password = password;
		this.customerId = customerId;
	}
	
	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "User [customerId=" + customerId + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
}
