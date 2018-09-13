package com.revature.bank;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.User;
import com.revature.util.FileManager;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

public class AccountServices {

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
		}
		
		
		
		public static void performAccountActions(Bank bank)
		{
			User user = null;
			System.out.println("Please Enter Username: ");
			String userName = scan.nextLine();
			System.out.println("Please Enter Password: ");
			String password = scan.nextLine();
			user = BankHandler.customerLogin(bank, userName, password);
			//System.out.println(user.getAccount(0).toString());
			if(user != null)
			{
				LoggingUtil.logInfo("User "+ user.getUserName() +" found.\n\n");
				BankHandler.displayAllAccounts(bank);
				boolean isDone = false;
				while(!isDone) {
					System.out.println("Please Choose An Option: ");
					System.out.println("[New Account][Deposit][Withdraw][Transfer][Exit]: ");
					String userInput = scan.nextLine();
					switch(userInput.toUpperCase().trim()) {
					
							case "NEW ACCOUNT": 
												
												break;
							case "DEPOSIT":
											
								
							case "WITHDRAW":
												System.out.println("Please Enter Amount For Withdraw: ");
												int amountWithdraw = scan.nextInt();
												System.out.println("Please Enter Account Number: ");
												int accountNumWithdraw = scan.nextInt();
												Account accountOne = BankHandler.findAccount(bank, accountNumWithdraw);
												if(!accountOne.getAccountStatus().equals(Account.ACCOUNT_PENDING))
													BankHandler.withdraw(bank, accountOne, amountWithdraw);
												else {
													LoggingUtil.logWarn("Account: " + accountOne.getAccountNumber() + " - Status Pending - No Transactions Available At This Time\n\n");
												}
													
												break;
								
								case "TRANSFER":
												System.out.println("Please Enter Amount For Transfer: ");
												int amountTransfer = scan.nextInt();
												System.out.println("Please Enter Account Number To Transfer From: ");
												int accountNumFrom = scan.nextInt();
												System.out.println("Please Enter Account Number To Transfer To: ");
												int accountNumTo = scan.nextInt();
												Account accountTwo = BankHandler.findAccount(bank, accountNumTo);
												Account accountThree = BankHandler.findAccount(bank, accountNumFrom);
												if(!accountTwo.getAccountStatus().equals(Account.ACCOUNT_PENDING) && !accountThree.getAccountStatus().equals(Account.ACCOUNT_PENDING))
													BankHandler.transfer(bank, accountNumFrom, accountNumTo, amountTransfer);
												else {
													if(accountTwo.getAccountStatus().equals(Account.ACCOUNT_PENDING))
														LoggingUtil.logWarn("Account: " + accountTwo.getAccountNumber() + " - Status Pending - No Transactions Available At This Time\n\n");
													else
														LoggingUtil.logWarn("Account: " + accountThree.getAccountNumber() + " - Status Pending - No Transactions Available At This Time\n\n");
												}
													
												break;
								case "EXIT":	
												isDone = true;
												break;
								default:
												System.out.println("Invalid Entry\n\n");
		
							}
								
							isDone = true;
							//scan.nextLine();
					}
				}
					
			}*/
		
		}
	

