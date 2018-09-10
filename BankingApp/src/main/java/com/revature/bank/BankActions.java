package com.revature.bank;

import java.util.Scanner;
import com.revature.account.UserAccount;
import com.revature.util.LoggingUtil;
import com.revature.util.TypeWriter;

public class BankActions {

		static Scanner scan = new Scanner(System.in);
		
		public static  UserAccount register(int accNum) {
		TypeWriter.write("\n	Please enter your first name: ", 50);
		String firstName = scan.nextLine();
		TypeWriter.write("	Please enter your last name: ", 50);
		String lastName = scan.nextLine();
		TypeWriter.write("	Please create a user name: ", 50);
		String userName = scan.nextLine();
		TypeWriter.write("	Please create a password:  ", 50);
		String password = scan.nextLine();
		TypeWriter.write("	Please choose an account type Checking/Savings: ", 50);
		String accountType = scan.nextLine();
		
		UserAccount user = new UserAccount();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		if(accountType.equalsIgnoreCase(UserAccount.ACCOUNT_CHECKING))
			accountType = UserAccount.ACCOUNT_CHECKING;
		else
			accountType = UserAccount.ACCOUNT_SAVINGS;
		user.setAccountType(accountType);
		user.setAccountStatus(UserAccount.ACCOUNT_PENDING);
		user.setUserName(userName);
		user.setPassword(password);
		user.setAccountNumber(accNum);
		user.setJointAccount(null);
		user.setAccType(UserAccount.REGULAR_ACCOUNT);
		
		return user;
		}
		
		public static UserAccount registerJoint(int accNum) {
			UserAccount userOne = register(accNum);
			userOne.setAccType(UserAccount.JOINT_ACCOUNT);
			UserAccount userTwo = register(accNum);
			userOne.setJointAccount(userTwo);
			return userOne;
			
		}
	
		public static void performAccountTrans(Bank bank)
		{

		int input = 0;
		boolean isSuccessful = false;
		UserAccount user = null;
		while(!isSuccessful)
		{
			TypeWriter.write("Please enter a username: ", 50);
			String userName = scan.nextLine();
			TypeWriter.write("Please enter a password: ", 50);
			String password = scan.nextLine();
			user = bank.customerLogin(userName, password);
			if(user == null) {
				LoggingUtil.logWarn("Account Username / Password not found.\n\n");
				isSuccessful = true;
			}
			else if(user != null)
			{
				isSuccessful = true;
				LoggingUtil.logInfo("Account found.\n\n");
		
				if(!UserAccount.ACCOUNT_APPROVED.equals(user.getAccountStatus())) {
					LoggingUtil.logWarn("Tranasactions for this account are not available at this time.\n\n");
					input = 4;
				}
				else if(UserAccount.ACCOUNT_APPROVED.equals(user.getAccountStatus())) {
					isSuccessful = false;
					while(!isSuccessful)
					{
						boolean isValidKey = false;
						while(!isValidKey)
						{
							TypeWriter.write("Choose a transaction: \n	1: Depsoit\n	2: Withdraw\n	3: Transfer\n	4: Return to main menu\n	Please choose an option: ", 50);
							input = scan.nextInt();
							if(input > 0 && input <=4)
								isValidKey = true;
							else
								LoggingUtil.logWarn("Invalid key - try again\n\n");
						}
						
						if(input == 1) {
							TypeWriter.write("\n	Deposit amount: ", 50);
							input = scan.nextInt();
							bank.deposit(user, input);
							isSuccessful = true;
						}
						if(input == 2) {
							TypeWriter.write("\n	Withdraw amount: ", 50);
							int withdrawAmount = scan.nextInt();
							bank.withdraw(user , withdrawAmount);
							isSuccessful = true;
						}if(input == 3) {
							TypeWriter.write("\n	Amount: ", 50);
							int transferAmount = scan.nextInt();
							TypeWriter.write("\n	Account num: ", 50);
							int accNum = scan.nextInt();
							
							bank.transfer(user, bank.getAccount(accNum), transferAmount);
							isSuccessful = true;
						}
						if(input == 4)
							isSuccessful = true;
					}
					
				}
			}
		}
	}
}
