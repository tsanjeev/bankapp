package com.revature.register;

import com.revature.pojos.Account;
import com.revature.pojos.SingleAccount;

public  class Register {
	
	public static Account registerSingle(String firstName, String lastName, String accountType) {
		
		Account user = new SingleAccount();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAccountType(accountType);
		user.setAccountStatus(Account.ACCOUNT_PENDING);
		return user;
	}
	
	public static void registerJoint(String fNameUserOne, String fNameUserTwo, String lNameUserOne, String lNameUserTwo, String accountType)
	{
		
	}
}
