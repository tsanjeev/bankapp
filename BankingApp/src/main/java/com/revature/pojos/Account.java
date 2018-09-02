package com.revature.pojos;

import java.io.Serializable;

public interface Account extends Serializable {
	
	public void deposit(int amount);
	public void setBalance(int amount);
	public void withdraw(int balance);
	public int getAccountNumber();
	public void setAccountNumber(int accountNumber);
	public int getBalance();
	public String getAccountType();
	public void setAccountType(String accountType);
	public void setAccountStatus(String status);
	public String getAccountStatus();
	public void setFirstName(String firstName);
	public void setLastName(String lastName);
	public String getFirstName();
	public String getLastName();
	public String getUserName();
	public void setUserName(String userName);
	public String getPassword();
	public void setPassword(String password);
	
	public static final String ACCOUNT_APPROVED = "APPROVED";
	public static final String ACCOUNT_DENIED = "DENIED";
	public static final String ACCOUNT_CHECKING = "CHECKING";
	public static final String ACCOUNT_SAVINGS = "SAVINGS";
	public static final String ACCOUNT_PENDING = "PENDING";
	
		
}
