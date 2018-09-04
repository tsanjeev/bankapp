package com.revature.menu;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.SingleAccountTransactions;
import com.revature.bank.Bank;
import com.revature.employee.BankAdmin;
import com.revature.employee.Employee;
import com.revature.exception.BankExceptions;
import com.revature.util.FileManager;
import com.revature.util.LoggingUtil;

public class Menu {
	
	

	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		Bank bank = null;
		if(FileManager.initializeBank() != null)
			bank = FileManager.initializeBank();
		else
			bank = new Bank();
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
			System.out.println("");
			if(input == 1)
			{
				scan.nextLine();
				LoggingUtil.logInfo("Please enter your first name: ");
				String firstName = scan.nextLine();
				LoggingUtil.logInfo("Please enter your last name: ");
				String lastName = scan.nextLine();
				LoggingUtil.logInfo("Please create a user name: ");
				String userName = scan.nextLine();
				LoggingUtil.logInfo("Please create a password:  ");
				String password = scan.nextLine();
				LoggingUtil.logInfo("Please choose an account type Checking/Savings: ");
				String accountType = scan.nextLine();
				bank.applySingle(firstName, lastName, accountType, userName, password);
				FileManager.saveAccounts(bank);
				//bank.displayAccounts(bank.getPendingAccounts());
			}
			else if(input == 2) {
				SingleAccountTransactions.performSingleAccountTrans(bank);
				FileManager.saveAccounts(bank);
				
			}
			else if(input == 3){
				boolean isFinished = false;
				Employee bankEmployee = null;
				while(!isFinished)
				{
					LoggingUtil.logInfo("Please enter employee id: ");
					int empID = scan.nextInt();
					System.out.println("");
					if(Integer.toString((empID)).charAt(0) == '1'){
						LoggingUtil.logInfo("Welcome Teller: "+ empID + "\n");
						bankEmployee = new Employee();
						bankEmployee.setEmployeeID(empID);
						isFinished = true;
					}
					else if(Integer.toString((empID)).charAt(0) == '5') {
						LoggingUtil.logInfo("Welcome BankAdmin: "+ empID + "\n");
						bankEmployee = new BankAdmin();
						bankEmployee.setEmployeeID(empID);
						isFinished = true;
					}
					else {
						LoggingUtil.logWarn("Invalid employee id - try again.\n\n");
						
					}
				}
				bankEmployee.employeeActions(bank);
				FileManager.saveAccounts(bank);
	
			}
			
		}
				
		scan.close();
	}
}

