package com.revature.employee;

import java.io.Serializable;
import java.util.Scanner;

import com.revature.account.UserAccount;
import com.revature.bank.Bank;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2918143209529064807L;
	protected int employeeID;
	protected String position;
	Scanner scan;
	
	public Employee() {
		scan = new Scanner(System.in);
		this.position = "Teller";
	}
	
	
	
	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}

	public void setEmployeeID(int ID) {
		this.employeeID = ID;
	}
	
	public int getEmployeeID() {
		return this.employeeID;
	}

	public int getAccountNumber(UserAccount person) {
		return person.getAccountNumber();
	}
	
	public int getBalance(UserAccount person) {
		return person.getBalance();
	}
	
	public String getAccountType(UserAccount person)
	{
		return person.getAccountType();
	}
	
	public void approveApplication(UserAccount person) {
		person.setAccountStatus(UserAccount.ACCOUNT_APPROVED);
	}

	public void denyApplication(UserAccount person) {
		person.setAccountStatus(UserAccount.ACCOUNT_DENIED);
	}
	
	public String getAccountStatus(UserAccount person) {
		return person.getAccountStatus();
	}
	
	public String getUserFirstName(UserAccount person) {
		return person.getFirstName();
	}
	
	public String getUserLastName(UserAccount person) {
		return person.getLastName();
	}
	
	public void getCustomerInfo(UserAccount user) {
		if(user == null) {
			LoggingUtil.logWarn("Account not found\n\n");
		}
		else
			System.out.println(user.toString() +"\n\n");
	}
	
	public void getAllCustomerInfo(Bank bank) {
		if(bank.getNumberOfAccounts() > 0) {
			for(int i = 0; i < bank.getNumberOfAccounts(); i++)
				TypeWriter.write("	"+ bank.getAccount(i).toString() + "\n", 50);
			System.out.println("");
		}
		else {
			System.out.println("\n	No accounts to retrieve\n\n");
			
		}
	}
	
	public void employeeActions(Bank bank) {
		boolean isFinished = false;
		int input = 0;
		while(!isFinished)
		{
			TypeWriter.write("	1: Retrieve customer information\n	2: Approve or deny pending accounts\n	3: Return to main menu\n	Please choose an action: ", 50);
			input = scan.nextInt();
			if(input == 1) {
				
				getAllCustomerInfo(bank); 
			}
			else if(input == 2) {
				boolean isValid = false;
				int accountNum = 0;
				while(!isValid)
				{
					TypeWriter.write("\n	Pending accounts: \n", 50);
					if(bank.getPendingAccounts().size() >= 1)
					{
						boolean isValidKey = false;
						while(!isValidKey)
						{
							bank.displayAccounts( bank.getPendingAccounts());
							TypeWriter.write("	Choose account to approve or deny\n	Account number: ", 50);
							
							accountNum = scan.nextInt();
							if(bank.getNumberOfAccounts() > 0 && accountNum <= bank.getNumberOfAccounts())
								isValidKey = true;
							else
								LoggingUtil.logWarn("Invalid entry - try again\n\n");
						}
						boolean isValidKeyTwo = false;
						while(!isValidKeyTwo) {
							TypeWriter.write("	1: approve\n	2: deny\n	Please choose an action: ", 50);
							input = scan.nextInt();
							if(input == 1 || input == 2)
								isValidKeyTwo = true;
							else {
								LoggingUtil.logWarn("Invalid entry - try again\n\n");
							}
						}
						if(input == 1) {
								approveApplication(bank.getAccount(accountNum));
								LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Approved account # " + accountNum + "\n\n");
							}
							else if(input == 2) {
								denyApplication(bank.getAccount(accountNum));
								LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Denied account # " + accountNum + "\n\n");
							}
						
						}isValid = true;
				}
			}
			else if(input == 3) {
				isFinished = true;
			}
			else {
				LoggingUtil.logWarn("Invalid Entry - try again\n\n");
			}
		}
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + "]";
		
	}
}
