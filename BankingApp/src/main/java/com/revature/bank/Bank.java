package com.revature.bank;

import java.util.ArrayList;
import java.io.*;

import com.revature.account.Account;
import com.revature.account.User;

public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866137718288831030L;
	
	ArrayList<Account> accountsList = null;
	ArrayList<User> userList = null;
	private int numberOfCustomers;
	private int numberOfAccounts;
	
	
	public Bank() {
		accountsList = new ArrayList<Account>();
		userList = new ArrayList<User>();
		numberOfCustomers = 0;
		numberOfAccounts = 0;
	}
	
	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}
	
	public void incrementNumberOfAccounts() {
		numberOfAccounts++;
	}
	
	public void addAccount(Account acc) {
		accountsList.add(acc);
		incrementNumberOfAccounts();
	}
	
	public void addUser(User user) {
		userList.add(user);
		incrementNumberOfCustomers();
	}
	
	public void displayAllAccounts() {
		for(int j = 0; j < accountsList.size(); j++) {
			System.out.println(accountsList.get(j).toString());
		}
		System.out.println("");
		if(numberOfAccounts == 0) {
			System.out.println("No Accounts At This Time.\n\n");
		}
	}
	
	public void displayAllUsers() {
		for(int j = 0; j < userList.size(); j++) {
			System.out.println(userList.get(j).toString());
		}
		System.out.println("");
		if(numberOfCustomers == 0) {
			System.out.println("No Users At This Time.\n\n");
		}
	}
	
	public void displayPending() {
		for(int i = 0; i < getAccountsList().size(); i++) {
			if(Account.ACCOUNT_PENDING.equals(getAccountsList().get(i).getAccountStatus())) {
				System.out.println(getAccountsList().get(i));
			}
		}
	}
	
	public void displayUsersAccounts(User user) {
		for(int i = 0; i < getAccountsList().size(); i++) {
			if(user.equals(getAccountsList().get(i).getPrimary()) || user.equals(getAccountsList().get(i).getSecondary())) {
				System.out.println(getAccountsList().get(i).toString());
			}
		}
	}
	
	public void displayAccount(int accountNum) {
		for(int i = 0; i < getAccountsList().size(); i++) {
			if(getAccountsList().get(i).getAccountNumber() == accountNum) {
				System.out.println(getAccountsList().get(i).toString() + "\n");
			}
		}
	}
	
	public Account getAccount(int accountNum) {
		Account account= null;
		for(int i = 0; i < getAccountsList().size(); i++) {
			if(getAccountsList().get(i).getAccountNumber() == accountNum) {
				return getAccountsList().get(i);
			}
		}
		return account;
	}
	
	public int getNumberOfCustomer() {
		return numberOfCustomers;
	}

	public void setNumberOfCustomer(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}
	
	public void incrementNumberOfCustomers() {
		numberOfCustomers++;
	}
	
	public ArrayList<User> getUsersList(){
		return userList;
	}
	
	public ArrayList<Account> getAccountsList(){
		return accountsList;
	}
}