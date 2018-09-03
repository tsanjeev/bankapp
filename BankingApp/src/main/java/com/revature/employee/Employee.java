package com.revature.employee;

import java.io.Serializable;

import com.revature.account.Account;
import com.revature.util.LoggingUtil;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2918143209529064807L;
	private int employeeID;
	
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
	
	public static void approveApplication(Account person) {
		person.setAccountStatus(Account.ACCOUNT_APPROVED);
	}

	public static void denyApplication(Account person) {
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
	
	public static void getCustomerInfo(Account user) {
		LoggingUtil.logInfo(user.toString());
	}
}
