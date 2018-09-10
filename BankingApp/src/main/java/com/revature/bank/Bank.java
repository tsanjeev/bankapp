package com.revature.bank;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

import com.revature.account.UserAccount;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866137718288831030L;
	
	List<UserAccount> userAccounts = null;
	private int numberOfAccounts;
	
	
	public Bank() {
		userAccounts = new ArrayList<UserAccount>();
		numberOfAccounts = 0;
	}
	
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}


	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}
	
	public void deleteAccount(int accNum) {
		this.userAccounts.remove(accNum);
		numberOfAccounts--;
	}
	
	public void incrementAccountNumbers() {
		numberOfAccounts++;
	}
	
	public void addAccount(UserAccount acc) {
		userAccounts.add(acc);
		incrementAccountNumbers();
	}
	
	public List<UserAccount> getPendingAccounts(){
		List<UserAccount> pendingAccounts = new ArrayList<UserAccount>();
		for(int j = 0; j < userAccounts.size(); j++) {
			if(userAccounts.get(j).getAccountStatus().equals(UserAccount.ACCOUNT_PENDING))
			{
				pendingAccounts.add(userAccounts.get(j));
				
			}
			
		}
		if(pendingAccounts.size() == 0)
			TypeWriter.write("No pending acounts at this time.\n\n", 50);
		return pendingAccounts;
	}
	
	public void displayAccounts(List<UserAccount> accounts) {
		for(int x = 0; x < accounts.size(); x++) {
			TypeWriter.write("	"+ accounts.get(x).toString() + "\n", 50);
		}
		
	}
	public UserAccount customerLogin(String userName, String password){
		UserAccount user = null;
		for(int x = 0; x < userAccounts.size(); x++) 
		{
			if(UserAccount.REGULAR_ACCOUNT.equals(userAccounts.get(x).getAccType()))
			{
				if(userAccounts.get(x).getUserName().equals(userName) && (userAccounts.get(x).getPassword().equals(password))) {
					return userAccounts.get(x);
				}
			}
			else if (UserAccount.JOINT_ACCOUNT.equals(userAccounts.get(x).getAccType())) {
				if(userAccounts.get(x).getUserName().equals(userName) && (userAccounts.get(x).getPassword().equals(password)) ||
						(userAccounts.get(x).getJointAccount().getUserName().equals(userName)) && 
							userAccounts.get(x).getJointAccount().getPassword().equals(password)){
					
								return userAccounts.get(x);
				}
			}
		}
		return user;
}
	
	public void withdraw(UserAccount user, int amount) {
		user.withdraw(amount);
	}
	
	public void deposit(UserAccount user, int amount) {
		user.deposit(amount);
		
	}
	
	public void transfer(UserAccount transferFrom, UserAccount transferTo, int amount) {
		
		if(!transferTo.getAccountStatus().equals(UserAccount.ACCOUNT_APPROVED)) {
			LoggingUtil.logWarn("Recipient account is not active - transaction cancelled\n\n");
		}
		else {
			transferFrom.transfer(amount, transferTo);
		}
	}
	
	public UserAccount getAccount(int accountNum)  {
		UserAccount acc = null;
		for(int j = 0; j < userAccounts.size(); j++) {
			if(accountNum == userAccounts.get(j).getAccountNumber())
				acc = userAccounts.get(j);
		}	
		return acc;
	}
	
	
}
