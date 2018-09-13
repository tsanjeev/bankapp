package com.revature.bank;

import java.util.ArrayList;

import com.revature.account.Account;
import com.revature.account.User;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

public class BankHandler {
	
	public static void addAccount(Bank bank, User acc) {
		bank.getUsersList().add(acc);
		bank.incrementNumberOfAccounts();
	}
	
	public static ArrayList<Account> getPendingAccounts(Bank bank){
		ArrayList<Account> pendingAccounts = new ArrayList<Account>();
		for(int j = 0; j < bank.getUsersList().size(); j++) {
			for(int x = 0; x < bank.getUsersList().get(j).getAccounts().size(); x++) {
			if(bank.getUsersList().get(j).getAccounts().get(x).getAccountStatus().equals(Account.ACCOUNT_PENDING)){
				pendingAccounts.add(bank.getUsersList().get(j).getAccounts().get(x));
			}
			
		}
	}
		if(pendingAccounts.size() == 0)
			TypeWriter.write("No pending acounts at this time.\n\n", 0);
		return pendingAccounts;
	}

	
	public static void displayAllAccounts(Bank bank) {
		for(int x = 0; x < bank.getNumberOfCustomers(); x++) {
			for(int j = 0; j < bank.getUsersList().get(x).getAccounts().size(); j++) {
				System.out.println(bank.getUsersList().get(x).getAccounts().get(j).toString());
			}
		}
	}
	
	public static User customerLogin(Bank bank, String userName, String password){
		User user = null;
		for(int x = 0; x < bank.getNumberOfCustomers(); x++) 
		{
			//System.out.println(bank.getUsersList().get(x).toString());
			if(bank.getUsersList().get(x).getUserName().equals(userName) && bank.getUsersList().get(x).getPassword().equals(password)) {
				return bank.getUsersList().get(x);
			}
		}
		return user;
	}
	
	public static Account findAccount(Bank bank, int accountNum) {
		Account account = null;
		for(int x = 0; x < bank.getNumberOfCustomers(); x++) {
			if(bank.getUsersList().get(x).hasAccount(accountNum))
				return bank.getUsersList().get(x).getAccount(accountNum);
		}
		return account;
	}
	
	public static void deposit(Bank bank, Account account, int amount) {
		// TODO Auto-generated method stub
			account.accountDeposit(amount);
			//LoggingUtil.logInfo("Account #" + this.getAccountNumber() + " successfully deposited " + amount + ", new balance: $" + this.balance +".\n\n");		
	}
	
	public static void withdraw(Bank bank, Account account, int amount) {
		// TODO Auto-generated method stub
		if(amount > account.getBalance()) {
			LoggingUtil.logError("Insufficient Funds - Transaction cancelled.\n\n");
			System.out.println("Insufficient Funds - Transaction cancelled.\n\n");
		}
		else {
			account.accountWithdraw(amount);
			//LoggingUtil.logInfo("Account #" + this.getAccountNumber() + " successfully withdrew " + amount + ", new balance: $" + this.balance +".\n\n");
			//System.out.println("Account #" + this.getAccountNumber() + " successfully withdrew " + amount + ", new balance: $" + this.balance +".\n\n");
		}
	}
	
	public static void transfer(Bank bank, int transferFrom, int transferTo, int amount) {
		// TODO Auto-generated method stub
		Account accountFrom = findAccount(bank, transferFrom);
		Account accountTo = findAccount(bank, transferTo);
		if(amount > accountFrom.getBalance()) {
			LoggingUtil.logError("Invalid withdraw amount - Withdraw cancelled.\n");
		}
		else {
				accountFrom.accountWithdraw(amount);
				accountTo.accountDeposit(amount);
				//LoggingUtil.logInfo("Account #" + this.getAccountNumber() + " successfully transferred " + amount + ", new balance: $" + this.balance +".\n\n");
		}
	}
	
}
