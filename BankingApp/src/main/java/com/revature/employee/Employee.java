package com.revature.employee;

import java.io.Serializable;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.bank.Bank;
import com.revature.util.LoggingUtil;

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

	public int getAccountNumber(Account person) {
		return person.getAccountNumber();
	}
	
	public int getBalance(Account person) {
		return person.getBalance();
	}
	
	public String getAccountType(Account person)
	{
		return person.getAccountType();
	}
	
	public void approveApplication(Account person) {
		person.setAccountStatus(Account.ACCOUNT_APPROVED);
	}

	public void denyApplication(Account person) {
		person.setAccountStatus(Account.ACCOUNT_DENIED);
	}
	
	public String getAccountStatus(Account person) {
		return person.getAccountStatus();
	}
	
	public String getUserFirstName(Account person) {
		return person.getFirstName();
	}
	
	public String getUserLastName(Account person) {
		return person.getLastName();
	}
	
	public void getCustomerInfo(Account user) {
		System.out.println(user.toString() +"\n\n");
	}
	
	public void employeeActions(Bank bank) {
		boolean isFinished = false;
		int input = 0;
		while(!isFinished)
		{
			System.out.println("1: Retrieve customer information\n");
			System.out.println("2: Approve or deny pending accounts\n");
			System.out.println("3: Return to main menu\n");
			System.out.println("Please choose an action: ");
			input = scan.nextInt();
			if(input == 1) {
				System.out.println("");
				System.out.println("Enter account numbuer: ");
				int accountNumber = scan.nextInt();
				getCustomerInfo((bank.getAccount(accountNumber))); 
			}
			else if(input == 2) {
				boolean isValid = false;
				int accountNum = 0;
				while(!isValid)
				{
					System.out.println("");
					System.out.println("Pending accounts: \n");
					if(bank.getPendingAccounts().size() >= 1)
					{
						boolean isValidKey = false;
						while(!isValidKey)
						{
							bank.displayAccounts( bank.getPendingAccounts());
							System.out.println("Choose account to approve or deny\n");
							System.out.println("Account number: ");
							
							accountNum = scan.nextInt();
							if(bank.getNumberOfAccounts() > 0 && accountNum <= bank.getNumberOfAccounts())
								isValidKey = true;
							else
								LoggingUtil.logWarn("Invalid entry - try again\n\n");
						}
						boolean isValidKeyTwo = false;
						while(!isValidKeyTwo) {
							System.out.println("1: approve\n");
							System.out.println("2: deny\n");
							System.out.println("Please choose an action: ");
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
				System.out.println("");
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
