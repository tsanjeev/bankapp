package com.revature.employee;

import java.io.Serializable;

import com.revature.account.Account;
import com.revature.bank.Bank;
import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

public class BankAdmin extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6228681121064269783L;

	@Override
	public String toString() {
		return "BankAdmin [employeeID=" + employeeID + "]";
	}
	
	public BankAdmin() {
		this.position = "BankAdmin";
	}
	
	@Override
	public void employeeActions(Bank bank) {
		// TODO Auto-generated method stub
		boolean isFinished = false;
		int input = 0;
		while(!isFinished)
		{
			boolean isInputValid = false;
			while(!isInputValid)
			{
				System.out.println("1: Retrieve customer information\n");
				System.out.println("2: Approve or deny pending accounts\n");
				System.out.println("3: Deposit\n");
				System.out.println("4: Withdraw\n");
				System.out.println("5) Transfer\n");
				System.out.println("6: Return to main menu\n");
				System.out.println("Please choose an action: ");
				input = scan.nextInt();
				if(input > 0 && input <= 6)
					isInputValid = true;
				else
					LoggingUtil.logWarn("Invalid Entry - try again\n\n");
			}
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
							if(accountNum > 0 && accountNum <= bank.getNumberOfAccounts())
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
							else
								LoggingUtil.logWarn("Invalid entry - try again\n\n");
						}
						if(input == 1) {
								approveApplication(bank.getAccount(accountNum));
								LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Approved account # " + accountNum + "\n\n" );
								System.out.println(getPosition()+": " + getEmployeeID() + " - Approved account # " + accountNum + "\n\n");
							}
							else if(input == 2) {
								denyApplication(bank.getAccount(accountNum));
								LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Denied account # " + accountNum + "\n\n" );
								System.out.println(getPosition()+": " + getEmployeeID() + " - Denied account # " + accountNum + "\n\n" );
							}
						isValid = true;
						}
				}
			}
			else if(input == 3) {
				System.out.println("");
				System.out.println("Deposit amount: ");
				int amount = scan.nextInt();
				System.out.println("Account to deposit to: ");
				int accNum = scan.nextInt();
				Account user = null;
				user = bank.getAccount(accNum);
				bank.deposit(user, amount);
			}
			else if(input == 4) {
				System.out.println("");
				System.out.println("Withdraw amount: ");
				int amount = scan.nextInt();
				System.out.println("Account to withdraw from: ");
				int accNum = scan.nextInt();
				Account user = null;
				user = bank.getAccount(accNum);
				bank.withdraw(user, amount);
			}
			else if(input == 5) {
				System.out.println("");
				System.out.println("Withdraw amount: ");
				int amount = scan.nextInt();
				System.out.println("Account to transfer from: ");
				int transferFrom = scan.nextInt();
				System.out.println("Account to transfer to: ");
				int transferTo = scan.nextInt();
				Account userOne = null;
				Account userTwo = null;
				userOne = bank.getAccount(transferFrom);
				userTwo = bank.getAccount(transferTo);
				
				bank.transfer(userOne, userTwo, amount);
			}
			else if(input == 6) {
				isFinished = true;
				System.out.println("");
			}
			else {
				LoggingUtil.logWarn("Invalid Entry - try again\n\n");
			}
		}
	}



	public void withdraw(Account user, int amount){
		user.withdraw(amount);
	}
	
	public void deposit(Account user, int amount){
		user.deposit(amount);		
	}
	
	public void transfer(Account transferFrom, Account transferTo, int amount){
		transferFrom.transfer(amount, transferTo);
	}
}
