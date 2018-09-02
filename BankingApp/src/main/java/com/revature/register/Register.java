package com.revature.register;

import com.revature.pojos.Account;
import com.revature.pojos.SingleAccount;

public  class Register {
	
	public static Account registerSingle(String firstName, String lastName, String accountType, String userName, String password) {
		
		Account user = new SingleAccount();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAccountType(accountType);
		user.setAccountStatus(Account.ACCOUNT_PENDING);
		user.setUserName(userName);
		user.setPassword(password);
		return user;
	}
	
	public static void registerJoint(String fNameUserOne, String fNameUserTwo, String lNameUserOne, String lNameUserTwo, String accountType)
	{
		
	}
}
