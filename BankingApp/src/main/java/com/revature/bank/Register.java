package com.revature.bank;

import com.revature.account.Account;
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
		LoggingUtil.logInfo("Account successfully created - Status pending approval");
		user.setLoggedOn(false);
		LoggingUtil.logInfo("Logging off");
		return user;
	}
	
	public static void registerJoint(String fNameUserOne, String fNameUserTwo, String lNameUserOne, String lNameUserTwo, String accountType)
	{
		
	}
}
