package com.revature.pojos;

public class SingleAccount implements Account{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482258227837614516L;
	private int balance;
	private int accountNumber;
	private String accountType;
	
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
	

}
