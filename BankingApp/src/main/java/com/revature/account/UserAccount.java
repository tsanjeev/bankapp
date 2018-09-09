package com.revature.account;

import java.io.Serializable;

public class UserAccount extends Account implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482258227837614516L;
	

	
	@Override
	public String toString() {
		return "UserAccount [accType=" + accType + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", accountType=" + accountType + ", accountStatus=" + accountStatus + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
