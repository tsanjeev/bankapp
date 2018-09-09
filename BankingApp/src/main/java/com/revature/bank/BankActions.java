package com.revature.bank;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.UserAccount;
import com.revature.util.LoggingUtil;

public class BankActions {

		static Scanner scan = new Scanner(System.in);
		
		public static  Account register(int accNum) {
		System.out.println("Please enter your first name: ");
		String firstName = scan.nextLine();
		System.out.println("Please enter your last name: ");
		String lastName = scan.nextLine();
		System.out.println("Please create a user name: ");
		String userName = scan.nextLine();
		System.out.println("Please create a password:  ");
		String password = scan.nextLine();
		System.out.println("Please choose an account type Checking/Savings: ");
		String accountType = scan.nextLine();
		
		Account user = new UserAccount();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		if(accountType.equalsIgnoreCase(Account.ACCOUNT_CHECKING))
			accountType = Account.ACCOUNT_CHECKING;
		else
			accountType = Account.ACCOUNT_SAVINGS;
		user.setAccountType(accountType);
		user.setAccountStatus(Account.ACCOUNT_PENDING);
		user.setUserName(userName);
		user.setPassword(password);
		user.setAccountNumber(accNum);
		user.setJointAccount(null);
		user.setAccType(Account.REGULAR_ACCOUNT);
		LoggingUtil.logInfo("Account successfully created - Status pending approval\n");
		return user;
		}
		
		public static Account registerJoint(int accNum) {
			System.out.println("Please enter your first name: ");
			String firstName = scan.nextLine();
			System.out.println("Please enter your last name: ");
			String lastName = scan.nextLine();
			System.out.println("Please create a user name: ");
			String userName = scan.nextLine();
			System.out.println("Please create a password:  ");
			String password = scan.nextLine();
			System.out.println("Please choose an account type Checking/Savings: ");
			String accountType = scan.nextLine();
			
			Account user = new UserAccount();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			if(accountType.equalsIgnoreCase(Account.ACCOUNT_CHECKING))
				accountType = Account.ACCOUNT_CHECKING;
			else
				accountType = Account.ACCOUNT_SAVINGS;
			user.setAccountType(accountType);
			user.setAccountStatus(Account.ACCOUNT_PENDING);
			user.setUserName(userName);
			user.setPassword(password);
			user.setAccountNumber(accNum);
			
			user.setAccType(Account.JOINT_ACCOUNT);
			
			System.out.println("Please enter 2nd user's first name: ");
			String firstNameTwo = scan.nextLine();
			System.out.println("Please enter 2nd user's last name: ");
			String lastNameTwo = scan.nextLine();
			System.out.println("Please create 2nd user name: ");
			String userNameTwo = scan.nextLine();
			System.out.println("Please create 2nd password:  ");
			String passwordTwo = scan.nextLine();
			
			Account userTwo = new UserAccount();
			userTwo.setFirstName(firstNameTwo);
			userTwo.setLastName(lastNameTwo);
			userTwo.setAccountType(accountType);
			userTwo.setAccountStatus(Account.ACCOUNT_PENDING);
			userTwo.setUserName(userNameTwo);
			userTwo.setPassword(passwordTwo);
			userTwo.setAccountNumber(accNum);
			userTwo.setAccType(Account.JOINT_ACCOUNT);
			userTwo.setJointAccount(null);
			
			user.setJointAccount(userTwo);
			LoggingUtil.logInfo("Joint Account successfully created - Status pending approval\n");
			return user;
			
		}
	
		public static void performAccountTrans(Bank bank)
		{
		Scanner scan = new Scanner(System.in);
		int input = 0;
		boolean isSuccessful = false;
		Account user = null;
		while(!isSuccessful)
		{
			
			System.out.println("Please enter a username: ");
			String userName = scan.nextLine();
			System.out.println("Please enter a password: ");
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
		
				if(!Account.ACCOUNT_APPROVED.equals(user.getAccountStatus())) {
					LoggingUtil.logWarn("Tranasactions for this account are not available at this time.\n\n");
					input = 4;
				}
				else if(Account.ACCOUNT_APPROVED.equals(user.getAccountStatus())) {
					isSuccessful = false;
					while(!isSuccessful)
					{
						boolean isValidKey = false;
						while(!isValidKey)
						{
							System.out.println("Choose a transaction: \n");
							System.out.println("1: Depsoit\n");
							System.out.println("2: Withdraw\n");
							System.out.println("3: Transfer\n");
							System.out.println("4: Return to main menu\n");
							System.out.println("Please choose an option: ");
							input = scan.nextInt();
							if(input > 0 && input <=4)
								isValidKey = true;
							else
								LoggingUtil.logWarn("Invalid key - try again\n\n");
						}
						
						if(input == 1) {
							System.out.println("");
							System.out.println("Deposit amount: ");
							input = scan.nextInt();
							bank.deposit(user, input);
							isSuccessful = true;
						}
						if(input == 2) {
							System.out.println("");
							System.out.println("Withdraw amount: ");
							int withdrawAmount = scan.nextInt();
							bank.withdraw(user , withdrawAmount);
							isSuccessful = true;
						}if(input == 3) {
							System.out.println("Amount: ");
							int transferAmount = scan.nextInt();
							System.out.println("Account num: ");
							int accNum = scan.nextInt();
							
							bank.transfer(user, bank.getAccount(accNum), transferAmount);
							isSuccessful = true;
						}
						if(input == 4)
							isSuccessful = true;
						System.out.println("");
					}
					
				}
			}
		}
	}
}
