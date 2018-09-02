package com.revature.bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.pojos.Account;
import com.revature.pojos.SingleAccount;

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
	
	public void apply() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter you first name: ");
		String firstName = input.nextLine();
		System.out.println("Please enter you last name: ");
		String lastName = input.nextLine();
		System.out.println("Please create a user name: ");
		String userName = input.nextLine();
		System.out.println("Please create a password:  ");
		String password = input.nextLine();
		System.out.println("Please choose an account type Checking/Savings: ");
		String accountType = input.nextLine();
		
		
		userAccounts.add(Register.registerSingle(firstName, lastName, accountType, userName, password, numberOfAccounts));
		input.close();
	}
	
	public List<Account> getPendingAccounts(){
		List<Account> pendingAccounts = new ArrayList<Account>();
		for(int j = 0; j < userAccounts.size(); j++) {
			if(userAccounts.get(j).getAccountStatus() == Account.ACCOUNT_PENDING)
				pendingAccounts.add(userAccounts.get(j));
		}
		return pendingAccounts;
	}
}
