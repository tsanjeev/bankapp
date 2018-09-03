package com.revature.account;

import java.io.Serializable;

public class SingleAccount implements Account,  Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482258227837614516L;
	private int balance;
	private int accountNumber;
	private String accountType;
	private String accountStatus;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private boolean isLoggedOn;
	
	public void deposit(int amount) {
		// TODO Auto-generated method stub
		balance += amount;
		
	}
	public void setBalance(int amount) {
		// TODO Auto-generated method stub
		balance = amount;
		
	}
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		balance -= amount;
		
	}
	public int getAccountNumber() {
		// TODO Auto-generated method stub
		return this.accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		// TODO Auto-generated method stub
		this.accountNumber = accountNumber;
		
	}
	public int getBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}
	public String getAccountType() {
		// TODO Auto-generated method stub
		return this.accountType;
	}
	public void setAccountType(String accountType) {
		// TODO Auto-generated method stub
		this.accountType = accountType;
	}
	public void setAccountStatus(String status) {
		// TODO Auto-generated method stub
		this.accountStatus = status;
		
	}
	
	
	@Override
	public String toString() {
		return "SingleAccount [balance=" + balance + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", password=" + password + ", isLoggedOn=" + isLoggedOn + "]";
	}
	public String getAccountStatus() {
		// TODO Auto-generated method stub
		return this.accountStatus;
	}
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
		
	}
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
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
	public boolean isLoggedIn() {
		// TODO Auto-generated method stub
		return isLoggedOn;
	}
	public void setLoggedOn(boolean activity) {
		// TODO Auto-generated method stub
		this.isLoggedOn = activity;
	}
	
	

}
