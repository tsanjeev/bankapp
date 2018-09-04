package com.revature.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import com.revature.account.Account;
import com.revature.account.JointAccount;
import com.revature.account.SingleAccount;
import com.revature.employee.BankAdmin;
import com.revature.employee.Employee;
import com.revature.exception.BankExceptions;
import com.revature.util.FileManager;
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
	
	
	public void applySingle(String firstName, String lastName, String accountType, String userName, String password) {
		
		incrementAccountNumbers();
		userAccounts.add(Register.registerSingle(firstName, lastName, accountType, userName, password, getNumberOfAccounts()));
		LoggingUtil.logInfo("logging off\n\n");
	}
	
	public void applyJoint(String firstName, String lastName, String userName, String password, String secondFirstName, 
			String secondLastName, String secondUserName, String secondPassword, String accountType) {
		incrementAccountNumbers();
		userAccounts.add(Register.registerJoint(firstName, lastName, userName, password, secondFirstName, secondLastName, secondUserName, secondPassword, accountType, getNumberOfAccounts()));
		//jointAcc.add(Register.registerJoint(firstName, lastName, userName, password, secondFirstName, secondLastName, secondUserName, secondPassword, accountType, getNumberJointOfAccounts()));
		LoggingUtil.logInfo("logging off\n\n");
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
			LoggingUtil.logWarn("No pending acounts at this time.\n\n");
		return pendingAccounts;
	}
	
	public void displayAccounts(List<Account> accounts) {
		for(int x = 0; x < accounts.size(); x++) {
			LoggingUtil.logInfo(accounts.get(x).toString() + "\n");
		}
		
	}
	public Account customerLogin(String userName, String password) throws BankExceptions{
		Account user = null;
		for(int x = 0; x < userAccounts.size(); x++) 
		{
			if(userAccounts.get(x) instanceof JointAccount){
				if((userAccounts.get(x)).getFirstUserName().equals(userName) &&
					(( userAccounts.get(x)).getPasswordOne().equals(password)) ||
					(( userAccounts.get(x)).getSecondUserName().equals(userName) 
							&& (( userAccounts.get(x)).getPasswordTwo().equals(password)))){
				//if((userName.equals(userAccounts.get(x).getFirstUserName())&&
					//( password.equals(userAccounts.get(x).getPasswordOne())))){
					
						user = userAccounts.get(x);
				}
			}
			else {
				if(userAccounts.get(x).getUserName().equals(userName) && (userAccounts.get(x).getPassword().equals(password))) {
					user = userAccounts.get(x);
				}
			}
			
		
		if(user == null) {
			//throw new BankExceptions("Username / Password not found.\n\n");
		}
		}
		return user;
}
	
	public void withdraw(Account user, int amount) throws BankExceptions {
		user.withdraw(amount);
		LoggingUtil.logInfo("New balance " + user.getBalance() +"\n\n");
	}
	
	public void deposit(Account user, int amount) throws BankExceptions {
		user.deposit(amount);
		LoggingUtil.logInfo("New balance: " + user.getBalance() +"\n\n");
		
	}
	
	public void transfer(Account transferFrom, Account transferTo, int amount) throws BankExceptions {
		
		if(!transferTo.getAccountStatus().equals(Account.ACCOUNT_APPROVED))
			LoggingUtil.logWarn("Recipient account is not active - transaction cancelled\n\n");
		else {
			transferFrom.transfer(amount, transferTo);
			LoggingUtil.logInfo("Account balance (sender): " +transferFrom.getBalance() + "\n");
			LoggingUtil.logWarn("Account balance (recipient): " + transferTo.getBalance() + "\n\n");
		}
	}
	
	public Account getAccount(int accountNum) throws BankExceptions {
		Account acc = null;
		for(int j = 0; j < userAccounts.size(); j++) {
			if(accountNum == userAccounts.get(j).getAccountNumber())
				acc = userAccounts.get(j);
		}
		if(acc == null)
			throw new BankExceptions("Account not found\n");
		return acc;
	}
}
