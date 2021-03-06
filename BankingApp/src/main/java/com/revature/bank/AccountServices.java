package com.revature.bank;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.User;
import com.revature.dao.AccountDAOImp;
import com.revature.dao.JunctionDAOImp;
import com.revature.dao.UserDAOImp;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

public class AccountServices {
	static Scanner scan = new Scanner(System.in);
	public static User register() {
		TypeWriter.write("Please create a user name: \n", 0);
		String userName = scan.nextLine();
		TypeWriter.write("Please create a password:  \n", 0);
		String password = scan.nextLine();
		User user = new User(userName, password, 0);
		return user;
	}
	
	public static User customerLogin(String userName, String password){
		UserDAOImp ud = new UserDAOImp();
		return ud.getUserByCred(userName, password);
}
	
	
	public static Account applyRegular(User user) throws Exception {
		TypeWriter.write("Checking or Savings account: \n", 0);
		String accountType = scan.nextLine();
		if(accountType.trim().equalsIgnoreCase(Account.ACCOUNT_CHECKING))
			accountType = Account.ACCOUNT_CHECKING;
		else
			accountType = Account.ACCOUNT_SAVINGS;
		Account newAccount = new Account(0,  accountType, Account.ACCOUNT_PENDING, user, null);
		AccountDAOImp ad = new AccountDAOImp();
		ad.accountInsert(newAccount);
		JunctionDAOImp jd = new JunctionDAOImp();
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
	
	public static void deposit(Account account, int amount) throws Exception {
		// TODO Auto-generated method stub
			AccountDAOImp ad = new AccountDAOImp();
			account = ad.getAccountById(account.getAccountNumber());
			account.deposit(amount);
			ad.accountUpdate(account, account.getAccountNumber());
			LoggingUtil.logInfo("Account #" + account.getAccountNumber() + " successfully deposited " + amount + ", new balance: $" + account.getBalance() +".\n\n");
	}
	
	public void withdraw(Account account, int amount) throws Exception {
		// TODO Auto-generated method stub
		if(amount > account.getBalance()) {
			LoggingUtil.logError("Insufficient Funds - Transaction cancelled.\n\n");
			System.out.println("Insufficient Funds - Transaction cancelled.\n\n");
		}
		else {
			AccountDAOImp ad = new AccountDAOImp();
			account = ad.getAccountById(account.getAccountNumber());
			account.withdraw(amount);
			ad.accountUpdate(account, account.getAccountNumber());
			LoggingUtil.logInfo("Account #" + account.getAccountNumber() + " successfully withdrew " + amount + ", new balance: $" + account.getBalance() +".\n\n");
			System.out.println("Account #" + account.getAccountNumber() + " successfully withdrew " + amount + ", new balance: $" + account.getBalance() +".\n\n");
		}
			
		
	}
	
	public static Account getAccountById(int accountNum) throws Exception {
		AccountDAOImp ad = new AccountDAOImp();
		Account newAccount = ad.getAccountById(accountNum);
		return newAccount;
	}
	
	public void displayAccount(int accountNum) {
		
	}
	
	public void displayAllUserAccounts(User user) {
		
	}
	/*
	public static Account findAccount(Bank bank, int accNum) {
		Account account = null;
		for(int i = 0; i < bank.getAccountsList().size(); i++) {
			if(bank.getAccountsList().get(i).getAccountNumber() == accNum) {
				return bank.getAccountsList().get(i);
			}
		}
		return account;
	}
	*/
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

