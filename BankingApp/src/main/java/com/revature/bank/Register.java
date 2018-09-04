package com.revature.bank;

import com.revature.account.Account;
import com.revature.account.JointAccount;
import com.revature.account.SingleAccount;
import com.revature.util.LoggingUtil;

public  class Register {
	
	public static Account registerSingle(String firstName, String lastName, String accountType, String userName, String password, int accountNumber) {
		
		Account user = new SingleAccount();
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
		user.setAccountNumber(accountNumber);
		LoggingUtil.logInfo("Account successfully created - Status pending approval\n");
		user.setLoggedOn(false);
		return user;
	}
	
	public static Account registerJoint(String firstFirstName, String firstLastName, String firstUserName, String firstPassword,
	String secondFirstName, String secondLastName, String secondUserName, String secondPassword, String accountType, int accountNumber)
	{
		Account joint = new JointAccount(firstFirstName, firstLastName, firstUserName, firstPassword, secondFirstName, secondLastName, secondUserName, secondPassword);
		if(accountType.equalsIgnoreCase(Account.ACCOUNT_CHECKING))
			accountType = Account.ACCOUNT_CHECKING;
		else
			accountType = Account.ACCOUNT_SAVINGS;
		joint.setAccountType(accountType);
		joint.setAccountStatus(Account.ACCOUNT_PENDING);
		joint.setAccountNumber(accountNumber);
		LoggingUtil.logInfo("Account successfully created - Status pending approval\n");
		joint.setLoggedOn(false);
		return joint;
	}
}
