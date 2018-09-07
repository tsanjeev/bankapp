package com.revature.account;

import java.io.Serializable;

import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

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
	
	private static final long serialVersionUID = 3417438856095899877L;
	public void transfer(int amount, Account account) throws BankExceptions {
		// TODO Auto-generated method stub
		boolean isSuccessful = true;
		try {
			withdraw(amount);
		} catch (BankExceptions e){
			LoggingUtil.logError("Invalid withdraw amount\n");
			isSuccessful = false;
		}
		if(isSuccessful)
			account.deposit(amount);
	}
	public void setBalance(int amount) {
			// TODO Auto-generated method stub
			balance = amount;
	}
	public void deposit(int amount) throws BankExceptions {
		// TODO Auto-generated method stub
		if(amount <= 0)
			throw new BankExceptions("Invalid deposit amount");
		else
			balance += amount;
	}
	
	public void withdraw(int amount) throws BankExceptions {
		// TODO Auto-generated method stub
		if(amount > balance)
			throw new BankExceptions("Insufficient funds\n");
		else
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
