package com.revature.bank;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.User;
import com.revature.util.FileManager;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

public class BankHandler {

		static Scanner scan = new Scanner(System.in);
		public static User register(Bank bank) {
			TypeWriter.write("Please create a user name: \n", 0);
			String userName = scan.nextLine();
			TypeWriter.write("Please create a password:  \n", 0);
			String password = scan.nextLine();
			User user = new User(userName, password, bank.getNumberOfCustomer());
			bank.addUser(user);
			LoggingUtil.logInfo("Account Successfully Created\n\n");
			FileManager.saveAccounts(bank);
			return user;
		}
		
		public static User customerLogin(Bank bank, String userName, String password){
			User user = null;
			for(int x = 0; x < bank.getNumberOfCustomer(); x++) 
			{
				if(bank.getUsersList().get(x).getUserName().equals(userName) &&
						bank.getUsersList().get(x).getPassword().equals(password)) {
					return bank.getUsersList().get(x);
				}
			}
			return user;
	}
		
		
		public static Account applyRegular(Bank bank, User user) {
			TypeWriter.write("Checking or Savings account: \n", 0);
			String accountType = scan.nextLine();
			if(accountType.equalsIgnoreCase(Account.ACCOUNT_CHECKING))
				accountType = Account.ACCOUNT_CHECKING;
			else
				accountType = Account.ACCOUNT_SAVINGS;
			Account newAccount = new Account(bank.getNumberOfAccounts(),  accountType, Account.ACCOUNT_PENDING, user, null);
			bank.addAccount(newAccount);
			FileManager.saveAccounts(bank);
			return newAccount;
		}
		
		public void transfer(int amount,  Account accountFrom, Account accountTo) {
			// TODO Auto-generated method stu
			if(amount > accountFrom.getBalance()) {
				LoggingUtil.logError("Invalid withdraw amount - Withdraw cancelled.\n");
			}
			else {
					accountFrom.withdraw(amount);
					accountTo.deposit(amount);
					LoggingUtil.logInfo("Account #" + accountTo.getAccountNumber() + " successfully transferred " + amount + ", new balance: $" + accountFrom.getBalance() +".\n\n");
					LoggingUtil.logInfo("Account #" + accountFrom.getAccountNumber() + " successfully received " + amount + ", new balance: $" + accountFrom.getBalance() +".\n\n");
			}
		}
		
		public static void deposit(Account account, int amount) {
			// TODO Auto-generated method stub
				account.deposit(amount);
				LoggingUtil.logInfo("Account #" + account.getAccountNumber() + " successfully deposited " + amount + ", new balance: $" + account.getBalance() +".\n\n");
		}
		
		public void withdraw(Account account, int amount) {
			// TODO Auto-generated method stub
			if(amount > account.getBalance()) {
				LoggingUtil.logError("Insufficient Funds - Transaction cancelled.\n\n");
				System.out.println("Insufficient Funds - Transaction cancelled.\n\n");
			}
			else {
				account.withdraw(amount);
				LoggingUtil.logInfo("Account #" + account.getAccountNumber() + " successfully withdrew " + amount + ", new balance: $" + account.getBalance() +".\n\n");
				System.out.println("Account #" + account.getAccountNumber() + " successfully withdrew " + amount + ", new balance: $" + account.getBalance() +".\n\n");
			}
				
			
		}
		
		public static Account findAccount(Bank bank, int accNum) {
			Account account = null;
			for(int i = 0; i < bank.getAccountsList().size(); i++) {
				if(bank.getAccountsList().get(i).getAccountNumber() == accNum) {
					return bank.getAccountsList().get(i);
				}
			}
			return account;
		}
}
		/*
		public static void applyJoint(Bank bank, User userOne, User userTwo) {
			TypeWriter.write("Checking or Savings account: ", 50);
			String accountType = scan.nextLine();
			Account newAccount = new Account(bank.getNumberOfAccounts(), accountType, Account.ACCOUNT_PENDING);
			userOne.addAccounts(newAccount);
			userTwo.addAccounts(newAccount);
			bank.addUser(userOne);
			bank.addUser(userTwo);
			FileManager.saveAccounts(bank);
		}*/
		
		


