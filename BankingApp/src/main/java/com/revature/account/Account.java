package com.revature.account;

import java.io.Serializable;

public class Account implements Serializable {
	
	/**
	 * 
	 */
	public static final String ACCOUNT_APPROVED = "APPROVED";
	public static final String ACCOUNT_DENIED = "DENIED";
	public static final String ACCOUNT_CHECKING = "CHECKING";
	public static final String ACCOUNT_SAVINGS = "SAVINGS";
	public static final String ACCOUNT_PENDING = "PENDING";
	public static final String JOINT_ACCOUNT = "JOINT_ACCOUNT";
	public static final String REGULAR_ACCOUNT = "REGULAR_ACCOUNT";
	public static final String ACCOUNT_CLOSED = "ACCOUNT_CLOSED";
	
	private int balance;
	private int accountNumber;
	private String accountType;
	private String accountStatus;
	private User primary;
	private User secondary;
	
	
	
	private static final long serialVersionUID = 3417438856095899877L;
	
	public Account(int accountNumber, String accountType, String accountStatus, User userOne, User userTwo) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.primary = userOne;
		this.secondary = userTwo;
	}
	
	
	public Account() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", primary=" + primary + ", balance=" + balance
				+ ", accountType=" + accountType + ", accountStatus=" + accountStatus + ", secondary=" + secondary
				+ "]";
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
	
	public String getAccountStatus() {
		// TODO Auto-generated method stub
		return this.accountStatus;
	}	
	public User getSecondary() {
		return secondary;
	}
	public void setSecondary(User secondary) {
		this.secondary = secondary;
	}
	public User getPrimary() {
		return primary;
	}
	public void setPrimary(User primary) {
		this.primary = primary;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public void withdraw(int amount) {
		this.balance -= amount;
	}


	public void setBalance(int int1) {
		// TODO Auto-generated method stub
		this.balance = int1;
		
	}
	
	
	

}