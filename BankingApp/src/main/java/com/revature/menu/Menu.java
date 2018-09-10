package com.revature.menu;

import java.util.Scanner;

import com.revature.bank.Bank;
import com.revature.bank.BankActions;
import com.revature.employee.BankAdmin;
import com.revature.employee.Employee;
import com.revature.util.FileManager;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

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
			System.out.println("\r\n" + 
					" __      __       .__                                ___________         _____    __________                __    \r\n" + 
					"/  \\    /  \\ ____ |  |   ____  ____   _____   ____   \\__    ___/___     /  _  \\   \\______   \\_____    ____ |  | __\r\n" + 
					"\\   \\/\\/   // __ \\|  | _/ ___\\/  _ \\ /     \\_/ __ \\    |    | /  _ \\   /  /_\\  \\   |    |  _/\\__  \\  /    \\|  |/ /\r\n" + 
					" \\        /\\  ___/|  |_\\  \\__(  <_> )  Y Y  \\  ___/    |    |(  <_> ) /    |    \\  |    |   \\ / __ \\|   |  \\    < \r\n" + 
					"  \\__/\\  /  \\___  >____/\\___  >____/|__|_|  /\\___  >   |____| \\____/  \\____|__  /  |______  /(____  /___|  /__|_ \\\r\n" + 
					"       \\/       \\/          \\/            \\/     \\/                           \\/          \\/      \\/     \\/     \\/\r\n" + 
					"");
		
			TypeWriter.write("\t1: New Customer \n	2: Returning Customer\n	3: Employee \n	4: Exit \n	Please choose an option: ", 50);
			input = scan.nextInt();
			if(input == 1)
			{
				boolean isValidKey = false;
				while(!isValidKey) {
					TypeWriter.write("\n	Which kind of account would you like to apply for?\n	1: Regular account\n	2: Joint account\n	Please choose an option: ", 50);
					input = scan.nextInt();
					
					if(input == 1 ) {
						bank.addAccount(BankActions.register(bank.getNumberOfAccounts()));
						FileManager.saveAccounts(bank);
						System.out.println("");
						LoggingUtil.logInfo("Account successfully created - Status pending approval\n\n");
						isValidKey = true;
					}
					else if(input == 2) {
						bank.addAccount(BankActions.registerJoint(bank.getNumberOfAccounts()));
						System.out.println("");
						LoggingUtil.logInfo("Joint Account successfully created - Status pending approval\n\n");
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
					TypeWriter.write("\n	Please enter employee id: ", 50);
					int empID = scan.nextInt();
					if(Integer.toString((empID)).charAt(0) == '1'){
						TypeWriter.write("\n	Welcome Teller: "+ empID + "\n", 50);
						bankEmployee = new Employee();
						bankEmployee.setEmployeeID(empID);
						isFinished = true;
					}
					else if(Integer.toString((empID)).charAt(0) == '5') {
						TypeWriter.write("\n	Welcome BankAdmin: "+ empID + "\n", 50);
						bankEmployee = new BankAdmin();
						bankEmployee.setEmployeeID(empID);
						isFinished = true;
					}
					else {
						LoggingUtil.logWarn("Invalid Employee Id - try again.\n\n");
						TypeWriter.write("Invalid Employee Id - try again.\n\n", 50);
						
					}
				}
				bankEmployee.employeeActions(bank);
				FileManager.saveAccounts(bank);
	
			}
			else if(input != 4){
				LoggingUtil.logWarn("Invalid Entry - try again \n\n");
				TypeWriter.write("Invalid Employee Id - try again.\n\n", 50);
			}
			
		}
		scan.close();
	}
}

