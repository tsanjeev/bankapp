package com.revature.menu;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.bank.Bank;
import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

public class Menu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank();
		int input = 0;
		
		while(input != 4)
		{
			try {
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
						bank.displayPendingAccounts(bank.getPendingAccounts());
					}
					else if(input == 2) {
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
							LoggingUtil.logInfo("Choose a transaction: \n");
							LoggingUtil.logInfo("1: Depsoit\n");
							LoggingUtil.logInfo("2: Withdraw\n");
							LoggingUtil.logInfo("3: Transfer\n");
							LoggingUtil.logInfo("4: Return to main menu\n");
							input = scan.nextInt();
							if(input == 1) {
								
							}
						}
				
						
					}
					
			} finally {
				
			}
		}
		scan.close();
	}
}
