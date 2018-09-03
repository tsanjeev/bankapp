package com.revature.menu;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.SingleAccountTransactions;
import com.revature.bank.Bank;
import com.revature.employee.BankAdmin;
import com.revature.employee.Employee;
import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

public class Menu {

	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank();
		int input = 0;
		
		while(input != 4)
		{
			LoggingUtil.logInfo("Welcome to The Bank.\n" );
			LoggingUtil.logInfo("1: New Customer\n" );
			LoggingUtil.logInfo("2: Returning Customer\n");
			LoggingUtil.logInfo("3: Employee\n" );
			LoggingUtil.logInfo("4: Exit\n");
			LoggingUtil.logInfo("Please choose an option: ");
			
			input = scan.nextInt();
			//LoggingUtil.logInfo("You chose option: "+ Integer.toString(input));
			if(input == 1)
			{
				bank.applySingle();
				bank.displayAccounts(bank.getPendingAccounts());
			}
			else if(input == 2) {
				SingleAccountTransactions.performSingleAccountTrans(bank);
				/*
				boolean isSuccessful = false;
				Account user = null;
				while(!isSuccessful)
				{
					try {
							user = bank.customerLogin();
							isSuccessful = true;
							LoggingUtil.logInfo("Account found.\n");
						
					} catch (BankExceptions e) {
						LoggingUtil.logInfo("1: Try again: \n");
						LoggingUtil.logInfo("2: Exit to main menu\n");
						input = scan.nextInt();
						if(input == 2) {
							isSuccessful = true;
							LoggingUtil.logInfo("Exiting to main menu\n");
						}
					}
				}
				if(!Account.ACCOUNT_APPROVED.equals(user.getAccountStatus())) {
					LoggingUtil.logInfo("Tranasactions for this account are not available at this time.\n");
					LoggingUtil.logInfo("Exiting console.\n");
					input = 4;
				}
				if(Account.ACCOUNT_APPROVED.equals(user.getAccountStatus())) {
					isSuccessful = false;
					while(!isSuccessful)
					{
						LoggingUtil.logInfo("Choose a transaction: \n");
						LoggingUtil.logInfo("1: Depsoit\n");
						LoggingUtil.logInfo("2: Withdraw\n");
						LoggingUtil.logInfo("3: Transfer\n");
						LoggingUtil.logInfo("4: Return to main menu\n");
						input = scan.nextInt();
						if(input == 1) {
							try {
								bank.deposit(user);
								isSuccessful = true;
							}catch (BankExceptions e) {
								LoggingUtil.logInfo("Invalid amount.\n");
							}
						}
						if(input == 2) {
							try {
								
								LoggingUtil.logInfo("Amount: ");
								int withdrawAmount = scan.nextInt();
								bank.withdraw(user , withdrawAmount);
								isSuccessful = true;
							}catch (BankExceptions e) {
								LoggingUtil.logInfo("Invalid amount.\n");
							}
						}if(input == 3) {
							try {
								LoggingUtil.logInfo("Amount: ");
								int transferAmount = scan.nextInt();
								LoggingUtil.logInfo("Account num: ");
								int accNum = scan.nextInt();
								
								bank.transfer(user, bank.getAccount(accNum), transferAmount);
								isSuccessful = true;
							}catch (BankExceptions e) {
								LoggingUtil.logInfo("Invalid amount.\n");
							}
						}
					}
				}*/
			}
			else if(input == 3){
				boolean isFinished = false;
				Employee bankEmployee = null;
				while(!isFinished)
				{
					LoggingUtil.logInfo("Please enter employee id: ");
					input = scan.nextInt();
					if(Integer.toString((input)).charAt(0) == '1'){
						LoggingUtil.logInfo("Welcome Teller: "+ input + "\n");
						bankEmployee = new Employee();
						bankEmployee.setEmployeeID(input);
						isFinished = true;
					}
					else if(Integer.toString((input)).charAt(0) == '5') {
						LoggingUtil.logInfo("Welcome BankAdmin: "+ input + "\n");
						bankEmployee = new BankAdmin();
						bankEmployee.setEmployeeID(input);
						isFinished = true;
					}
					else {
						LoggingUtil.logWarn("Invalid employee id - try again.");
						
					}
				}
				bankEmployee.employeeActions(bank);
				/**
				
				while(!isFinished)
				{
					LoggingUtil.logInfo("1: Retrieve customer information\n");
					LoggingUtil.logInfo("2: Approve or deny pending accounts\n");
					LoggingUtil.logInfo("3: Return to main menu\n");
					LoggingUtil.logInfo("Please choose an action: ");
					input = scan.nextInt();
					if(input == 1) {
						LoggingUtil.logInfo("Enter account numbuer: ");
						int accountNumber = scan.nextInt();
						try {
								bankEmployee.getCustomerInfo(bank.getAccount(accountNumber));
						} catch (BankExceptions e) {
							LoggingUtil.logWarn("Account not found\n");
						} 
					}
					else if(input == 2) {
						LoggingUtil.logInfo("Pending accounts: \n");
						if(bank.getPendingAccounts().size() > 1)
						{
							bank.displayPendingAccounts(bank.getPendingAccounts());
							LoggingUtil.logInfo("Choose account to approve or deny\n");
							LoggingUtil.logInfo("Account number: ");
							int accountNum = scan.nextInt();
							LoggingUtil.logInfo("1: approve\n");
							LoggingUtil.logInfo("2: deny\n");
							LoggingUtil.logInfo("Please choose an action: ");
							input = scan.nextInt();
							if(input == 1) {
								try {
									bankEmployee.approveApplication(bank.getAccount(accountNum));
								} catch (BankExceptions e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if(input == 2) {
								try {
									bankEmployee.denyApplication(bank.getAccount(accountNum));
								} catch (BankExceptions e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							bank.saveAccounts();
						}
					}
					else if(input == 3) {
						isFinished = true;
					}**/
				}
			
		}
				
		scan.close();
	}
}

