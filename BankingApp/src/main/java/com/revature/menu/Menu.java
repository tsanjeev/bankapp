package com.revature.menu;

import java.util.Scanner;

import com.revature.bank.Bank;
import com.revature.util.LoggingUtil;

public class Menu {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Bank bank = new Bank();
		int input = 0;
		
		while(input != 4)
		{
			try {
					LoggingUtil.logInfo("Welcome to The Bank." );
					LoggingUtil.logInfo("1: New Customer" );
					LoggingUtil.logInfo("2: Returning Customer");
					LoggingUtil.logInfo("3: Employee" );
					LoggingUtil.logInfo("4: Exit");
					LoggingUtil.logInfo("Please choose an option: ");
					input = scan.nextInt();
					LoggingUtil.logInfo("You chose option: "+ Integer.toString(input));
					if(input == 1)
					{
						bank.applySingle();
						bank.displayPendingAccounts(bank.getPendingAccounts());
					}
					
			} finally {
				scan.close();
			}
		}
		
	}
}
