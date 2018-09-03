package com.revature.account;

import java.util.Scanner;

import com.revature.bank.Bank;
import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

public class SingleAccountTransactions {

	
	public static void performSingleAccountTrans(Bank bank)
	{
		Scanner scan = new Scanner(System.in);
		int input = 0;
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
				LoggingUtil.logInfo("Please choose an option: ");
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
			
		}
	}
}
