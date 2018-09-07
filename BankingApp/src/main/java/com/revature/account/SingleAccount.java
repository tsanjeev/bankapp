package com.revature.account;

import java.io.Serializable;

import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

public class SingleAccount extends Account implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482258227837614516L;

	@Override
	public String toString() {
		return "SingleAccount [balance=" + balance + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", accountStatus=" + accountStatus + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", password=" + password + "]";
	}
	
}
