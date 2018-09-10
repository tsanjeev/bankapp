package com.revature.employee;

import java.io.Serializable;

import com.revature.account.UserAccount;
import com.revature.bank.Bank;
import com.revature.util.FileManager;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

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
				TypeWriter.write("	1: Retrieve customer information\n	2: Delete acount\n	3: Approve or deny pending accounts\n	4: Deposit\n	5: Withdraw\n	6: Transfer\n	7: Return to main menu\n	Please choose an action: ", 50);
				input = scan.nextInt();
				if(input > 0 && input <= 7)
					isInputValid = true;
				else
					LoggingUtil.logWarn("Invalid Entry - try again\n\n");
			}
			if(input == 1) {
				getAllCustomerInfo(bank); 
			}
			else if(input == 2) {
				TypeWriter.write("\n	Choose account # to delete: ", 50);
				input = scan.nextInt();
				if(input < bank.getNumberOfAccounts()) {
					bank.deleteAccount(input);
					FileManager.saveAccounts(bank);
					LoggingUtil.logInfo(toString() + "deleted account #" + input +".\n\n");
				}
				else {
					LoggingUtil.logWarn("Invalid Entry - try again\n\n");
				}
			}
			else if(input == 3) {
				boolean isValid = false;
				int accountNum = 0;
				while(!isValid)
				{
					TypeWriter.write("/n	Pending accounts: \n", 50);
					if(bank.getPendingAccounts().size() >= 1)
					{
						boolean isValidKey = false;
						while(!isValidKey)
						{
							bank.displayAccounts( bank.getPendingAccounts());
							TypeWriter.write("\n	Choose account to approve or deny\n	Account number: ", 50);
							
							accountNum = scan.nextInt();
							if(accountNum > 0 && accountNum <= bank.getNumberOfAccounts())
								isValidKey = true;
							else
								LoggingUtil.logWarn("Invalid entry - try again\n\n");
						}
						boolean isValidKeyTwo = false;
						while(!isValidKeyTwo) {
							TypeWriter.write("	1: approve\n	2: deny\n	Please choose an action: ", 50);
							if(input == 1 || input == 2)
								isValidKeyTwo = true;
							else
								LoggingUtil.logWarn("Invalid entry - try again\n\n");
						}
						if(input == 1) {
								approveApplication(bank.getAccount(accountNum));
								LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Approved account # " + accountNum + "\n\n" );
								TypeWriter.write("	"+ getPosition()+": " + getEmployeeID() + " - Approved account # " + accountNum + "\n\n", 50);
							}
							else if(input == 2) {
								denyApplication(bank.getAccount(accountNum));
								LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Denied account # " + accountNum + "\n\n" );
								TypeWriter.write("	"+ getPosition()+": " + getEmployeeID() + " - Denied account # " + accountNum + "\n\n", 50);
							}
						isValid = true;
						}
				}
			}
			else if(input == 4) {
				TypeWriter.write("\n	Deposit amount: ", 50);
				int amount = scan.nextInt();
				TypeWriter.write("\n	Account to deposit to: ", 50);
				int accNum = scan.nextInt();
				UserAccount user = null;
				user = bank.getAccount(accNum);
				bank.deposit(user, amount);
			}
			else if(input == 5) {
				TypeWriter.write("\n	Withdraw amount: ", 50);
				int amount = scan.nextInt();
				TypeWriter.write("\n	Account to withdraw from: ", 50);
				int accNum = scan.nextInt();
				UserAccount user = null;
				user = bank.getAccount(accNum);
				bank.withdraw(user, amount);
			}
			else if(input == 6) {
				TypeWriter.write("\n	Transfer amount: ", 50);
				int amount = scan.nextInt();
				TypeWriter.write("\n	Account to transfer from: ", 50);
				int transferFrom = scan.nextInt();
				TypeWriter.write("\n	Account to transfer to: ", 50);
				int transferTo = scan.nextInt();
				UserAccount userOne = null;
				UserAccount userTwo = null;
				userOne = bank.getAccount(transferFrom);
				userTwo = bank.getAccount(transferTo);
				
				bank.transfer(userOne, userTwo, amount);
			}
			else if(input == 7) {
				isFinished = true;
			}
			else {
				LoggingUtil.logWarn("Invalid Entry - try again\n\n");
			}
		}
	}
}
