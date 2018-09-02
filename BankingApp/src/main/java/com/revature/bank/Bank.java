package com.revature.bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.SingleAccount;
import com.revature.util.LoggingUtil;

public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866137718288831030L;
	List<Account> userAccounts;
	private int numberOfAccounts;
	
	
	public Bank() {
		userAccounts = new ArrayList<Account>();
		setNumberOfAccounts(0);
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
	
	public void applySingle() {
		Scanner scan = new Scanner(System.in);
		LoggingUtil.logInfo("Please enter your first name: ");
		String firstName = scan.nextLine();
		LoggingUtil.logInfo("You entered: "+ firstName);
		LoggingUtil.logInfo("Please enter your last name: ");
		String lastName = scan.nextLine();
		LoggingUtil.logInfo("You entered: "+ lastName);
		LoggingUtil.logInfo("Please create a user name: ");
		String userName = scan.nextLine();
		LoggingUtil.logInfo("You entered "+ userName);
		LoggingUtil.logInfo("Please create a password:  ");
		String password = scan.nextLine();
		LoggingUtil.logInfo("You entered "+ password);
		LoggingUtil.logInfo("Please choose an account type Checking/Savings: ");
		String accountType = scan.nextLine();
		LoggingUtil.logInfo("You entered "+ accountType);
		
		incrementAccountNumbers();
		userAccounts.add(Register.registerSingle(firstName, lastName, accountType, userName, password, numberOfAccounts));
		scan.close();
	}
	
	public void applyJoint() {
		
	}
	
	public List<Account> getPendingAccounts(){
		List<Account> pendingAccounts = new ArrayList<Account>();
		for(int j = 0; j < userAccounts.size(); j++) {
			if(userAccounts.get(j).getAccountStatus() == Account.ACCOUNT_PENDING)
				pendingAccounts.add(userAccounts.get(j));
		}
		return pendingAccounts;
	}
	
	public void displayPendingAccounts(List<Account> accounts) {
		for(int x = 0; x < accounts.size(); x++) {
			LoggingUtil.logInfo(accounts.get(x).toString());
		}
	}
	
	public void withdraw(Account user, int amount) {
		
	}
	
	public void deposit(Account user, int amount) {
		
	}
	
	public void transfer(Account transferTo, Account transferFrom, int amount) {
		
	}
}
