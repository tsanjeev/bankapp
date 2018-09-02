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
	
		
}
