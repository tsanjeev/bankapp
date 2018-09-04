package com.revature.account;

import java.io.Serializable;

import com.revature.exception.BankExceptions;

public class Account implements Serializable {
	
	
	
	/**
	 * 
	 */
	protected int balance;
	protected int accountNumber;
	protected String accountType;
	protected String accountStatus;
	protected String firstName;
	protected String lastName;
	protected String userName;
	protected String password;
	protected boolean isLoggedOn;
	protected String accType;
	
	public void setAccType(String name)
	{
		this.accType = name;
	}
	
	public String getAccType() {
		return accType;
	}
	
	
	private static final long serialVersionUID = 3417438856095899877L;
	public void deposit(int amount) throws BankExceptions {
	}
	public void setBalance(int amount) {
			// TODO Auto-generated method stub
			balance = amount;
	}
	public void withdraw(int balance) throws BankExceptions {
	}
	public void transfer(int amount, Account accNum) throws BankExceptions {
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
	
	public void setFirstName(String firstName) {
	}
	public void setLastName(String lastName) {
	}
	public String getFirstName() {
		return null;
	}
	public String getLastName() {
		return null;
	}
	public String getUserName() {
		return null;
	}
	public void setUserName(String userName) {
	}
	public String getPassword() {
		return null;
	}
	public void setPassword(String password) {
	}
	
	public boolean isLoggedIn() {
		// TODO Auto-generated method stub
		return isLoggedOn;
	}
	public void setLoggedOn(boolean activity) {
		// TODO Auto-generated method stub
		this.isLoggedOn = activity;
	}
	
	public static final String ACCOUNT_APPROVED = "APPROVED";
	public static final String ACCOUNT_DENIED = "DENIED";
	public static final String ACCOUNT_CHECKING = "CHECKING";
	public static final String ACCOUNT_SAVINGS = "SAVINGS";
	public static final String ACCOUNT_PENDING = "PENDING";
	public  String getFirstUserName() {
		return null;
	}
	public String getPasswordOne() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getSecondUserName() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPasswordTwo() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}
