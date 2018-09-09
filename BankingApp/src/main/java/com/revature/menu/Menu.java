package com.revature.menu;

import java.util.Scanner;

import com.revature.bank.Bank;
import com.revature.bank.BankActions;
import com.revature.employee.BankAdmin;
import com.revature.employee.Employee;
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
			System.out.println("Welcome to The Bank.\n" );
			System.out.println("1: New Customer\n" );
			System.out.println("2: Returning Customer\n");
			System.out.println("3: Employee\n" );
			System.out.println("4: Exit\n");
			System.out.println("Please choose an option: ");
			input = scan.nextInt();
			if(input == 1)
			{
				boolean isValidKey = false;
				while(!isValidKey) {
					System.out.println("Which kind of account would you like to apply for?\n");
					System.out.println("1: Regular account\n");
					System.out.println("2: Joint account\n");
					System.out.println("Please choose an option: ");
					input = scan.nextInt();
					
					if(input == 1 ) {
						
						bank.addAccount(BankActions.register(bank.getNumberOfAccounts()));
						bank.incrementAccountNumbers();
						FileManager.saveAccounts(bank);
						isValidKey = true;
					}
					else if(input == 2) {
						bank.addAccount(BankActions.registerJoint(bank.getNumberOfAccounts()));
						bank.incrementAccountNumbers();
						FileManager.saveAccounts(bank);
						isValidKey = true;
					}
					else {
						LoggingUtil.logWarn("Invalid Entry - try again\n\n");
					}
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
					System.out.println("Please enter employee id: ");
					int empID = scan.nextInt();
					System.out.println("");
					if(Integer.toString((empID)).charAt(0) == '1'){
						System.out.println("Welcome Teller: "+ empID + "\n");
						bankEmployee = new Employee();
						bankEmployee.setEmployeeID(empID);
						isFinished = true;
					}
					else if(Integer.toString((empID)).charAt(0) == '5') {
						System.out.println("Welcome BankAdmin: "+ empID + "\n");
						bankEmployee = new BankAdmin();
						bankEmployee.setEmployeeID(empID);
						isFinished = true;
					}
					else {
						LoggingUtil.logWarn("Invalid Employee Id - try again.\n\n");
						System.out.println("Invalid Employee Id - try again.\n\n");
						
					}
				}
				bankEmployee.employeeActions(bank);
				FileManager.saveAccounts(bank);
	
			}
			else if(input != 4){
				LoggingUtil.logWarn("Invalid Entry - try again \n\n");
				System.out.println("Invalid Employee Id - try again.\n\n");
			}
			
		}
				
		scan.close();
	}
}

