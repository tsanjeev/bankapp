package com.revature.account;

import java.io.Serializable;

import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

public class SingleAccount extends Account implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482258227837614516L;
	private String accType;
	
	public void deposit(int amount) throws BankExceptions {
		// TODO Auto-generated method stub
		if(amount <= 0)
			throw new BankExceptions("Invalid deposit amount");
		else
			this.balance += amount;
	}
	
	public void withdraw(int amount) throws BankExceptions {
		// TODO Auto-generated method stub
		if(amount > this.balance)
			throw new BankExceptions("Insufficient funds\n");
		else
			balance -= amount;
		
	}
	
	public void setAccType(String name)
	{
		this.accType = name;
	}
	
	public String getAccType() {
		return accType;
	}
	
	@Override
	public String toString() {
		return "SingleAccount [balance=" + balance + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", password=" + password + ", isLoggedOn=" + isLoggedOn + "]";
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
	
	
	

}
