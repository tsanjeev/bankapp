package com.revature.bank;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import com.revature.account.Account;
import com.revature.util.LoggingUtil;

public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866137718288831030L;
	
	List<Account> userAccounts = null;
	private int numberOfAccounts;
	
	
	public Bank() {
		userAccounts = new ArrayList<Account>();
		numberOfAccounts = 0;
	}
	
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}


	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}
	
	public void incrementAccountNumbers() {
		numberOfAccounts++;
	}
	
	public void addAccount(Account acc) {
		userAccounts.add(acc);
	}
	
	public List<Account> getPendingAccounts(){
		List<Account> pendingAccounts = new ArrayList<Account>();
		for(int j = 0; j < userAccounts.size(); j++) {
			if(userAccounts.get(j).getAccountStatus().equals(Account.ACCOUNT_PENDING))
			{
				pendingAccounts.add(userAccounts.get(j));
				
			}
			
		}
		if(pendingAccounts.size() == 0)
			System.out.println("No pending acounts at this time.\n\n");
		return pendingAccounts;
	}
	
	public void displayAccounts(List<Account> accounts) {
		for(int x = 0; x < accounts.size(); x++) {
			System.out.println(accounts.get(x).toString() + "\n");
		}
		
	}
	public Account customerLogin(String userName, String password){
		Account user = null;
		for(int x = 0; x < userAccounts.size(); x++) 
		{
			if(Account.REGULAR_ACCOUNT.equals(userAccounts.get(x).getAccType()))
			{
				if(userAccounts.get(x).getUserName().equals(userName) && (userAccounts.get(x).getPassword().equals(password))) {
					return userAccounts.get(x);
				}
			}
			else if (Account.JOINT_ACCOUNT.equals(userAccounts.get(x).getAccType())) {
				if(userAccounts.get(x).getUserName().equals(userName) && (userAccounts.get(x).getPassword().equals(password)) ||
						(userAccounts.get(x).getJointAccount().getUserName().equals(userName)) && 
							userAccounts.get(x).getJointAccount().getPassword().equals(password)){
					
								return userAccounts.get(x);
				}
			}
		}
		return user;
}
	
	public void withdraw(Account user, int amount) {
		user.withdraw(amount);
	}
	
	public void deposit(Account user, int amount) {
		user.deposit(amount);
		
	}
	
	public void transfer(Account transferFrom, Account transferTo, int amount) {
		
		if(!transferTo.getAccountStatus().equals(Account.ACCOUNT_APPROVED)) {
			LoggingUtil.logWarn("Recipient account is not active - transaction cancelled\n\n");
		}
		else {
			transferFrom.transfer(amount, transferTo);
		}
	}
	
	public Account getAccount(int accountNum)  {
		Account acc = null;
		for(int j = 0; j < userAccounts.size(); j++) {
			if(accountNum == userAccounts.get(j).getAccountNumber())
				acc = userAccounts.get(j);
		}
		//if(acc == null)
			
		return acc;
	}
}
