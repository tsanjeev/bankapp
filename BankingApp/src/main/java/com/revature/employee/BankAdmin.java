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
			LoggingUtil.logInfo("1: Retrieve customer information\n");
			LoggingUtil.logInfo("2: Approve or deny pending accounts\n");
			LoggingUtil.logInfo("3: Deposit\n");
			LoggingUtil.logInfo("4: Withdraw\n");
			LoggingUtil.logInfo("5) Transfer\n");
			LoggingUtil.logInfo("6: Return to main menu\n");
			LoggingUtil.logInfo("Please choose an action: ");
			input = scan.nextInt();
			if(input == 1) {
				System.out.println("");
				LoggingUtil.logInfo("Enter account numbuer: ");
				int accountNumber = scan.nextInt();
				try {
						getCustomerInfo((bank.getAccount(accountNumber)));
				} catch (BankExceptions e) {
					LoggingUtil.logWarn("Account not found\n\n");
				} 
			}
			else if(input == 2) {
				boolean isValid = false;
				int accountNum = 0;
				while(!isValid)
				{
					System.out.println("");
					LoggingUtil.logInfo("Pending accounts: \n");
					if(bank.getPendingAccounts().size() >= 1)
					{
						boolean isValidKey = false;
						while(!isValidKey)
						{
							bank.displayAccounts( bank.getPendingAccounts());
							LoggingUtil.logInfo("Choose account to approve or deny\n");
							LoggingUtil.logInfo("Account number: ");
							
							accountNum = scan.nextInt();
							if(accountNum > 0 && accountNum <= bank.getNumberOfAccounts())
								isValidKey = true;
							else
								LoggingUtil.logWarn("Invalid entry - try again\n\n");
						}
						boolean isValidKeyTwo = false;
						while(!isValidKeyTwo) {
							LoggingUtil.logInfo("1: approve\n");
							LoggingUtil.logInfo("2: deny\n");
							LoggingUtil.logInfo("Please choose an action: ");
							input = scan.nextInt();
							if(input == 1 || input == 2)
								isValidKeyTwo = true;
							else
								LoggingUtil.logWarn("Invalid entry - try again\n\n");
						}
						if(input == 1) {
								try {
									approveApplication(bank.getAccount(accountNum));
									LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Approved account # " + accountNum + "\n\n" );
								} catch (BankExceptions e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if(input == 2) {
								try {
									denyApplication(bank.getAccount(accountNum));
									LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Denied account # " + accountNum + "\n\n" );
								} catch (BankExceptions e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						isValid = true;
						}
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



	public void withdraw(Account user, int amount) throws BankExceptions {
		user.withdraw(amount);
		LoggingUtil.logInfo("New balance " + user.getBalance() +"\n\n");
	}
	
	public void deposit(Account user, int amount) throws BankExceptions {
		user.deposit(amount);
		LoggingUtil.logInfo("New balance: " + user.getBalance() +"\n\n");
		
	}
	
	public void transfer(Account transferFrom, Account transferTo, int amount) throws BankExceptions {
		transferFrom.transfer(amount, transferTo);
		LoggingUtil.logInfo("Account balance (sender): " +transferFrom.getBalance() + "\n");
		
	}
}
