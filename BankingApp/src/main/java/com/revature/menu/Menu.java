package com.revature.menu;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.bank.Bank;
import com.revature.bank.BankActions;
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
				//scan.nextLine();
				
				boolean isValidKey = false;
				while(!isValidKey) {
					LoggingUtil.logInfo("Which kind of account would you like to apply for?\n");
					LoggingUtil.logInfo("1: Regular account\n");
					LoggingUtil.logInfo("2: Joint account\n");
					LoggingUtil.logInfo("Please choose an option: ");
					input = scan.nextInt();
					if(input == 1 || input ==2) {
						isValidKey = true;
					}
					else {
						LoggingUtil.logWarn("Invalid entry - try again\n\n");
					}
					scan.nextLine();
				}
				if(input == 1) {
				
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
					LoggingUtil.logInfo("Please enter first user's name: ");
					String firstName = scan.nextLine();
					LoggingUtil.logInfo("Please enter first user's last name: ");
					String lastName = scan.nextLine();
					LoggingUtil.logInfo("Please create first user's username: ");
					String userName = scan.nextLine();
					LoggingUtil.logInfo("Please create first user's password: ");
					String password = scan.nextLine();
					LoggingUtil.logInfo("Please enter second user's first name: ");
					String secondFirstName = scan.nextLine();
					LoggingUtil.logInfo("Please enter second user's last name: ");
					String secondLastName = scan.nextLine();
					LoggingUtil.logInfo("Please create second user's username: ");
					String secondUserName = scan.nextLine();
					LoggingUtil.logInfo("Please create second user's password:  ");
					String secondPassword = scan.nextLine();
					LoggingUtil.logInfo("Please choose an account type Checking/Savings: ");
					String accountType = scan.nextLine();
					bank.applyJoint(firstName, lastName, userName, password, secondFirstName, secondLastName, secondUserName, secondPassword, accountType );
					FileManager.saveAccounts(bank);
				}
			}
			else if(input == 2) {
				BankActions.performAccountTrans(bank);
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
			else if(input != 4){
				LoggingUtil.logWarn("Invalid entry - try again \n\n");
			}
			
		}
				
		scan.close();
	}
}

