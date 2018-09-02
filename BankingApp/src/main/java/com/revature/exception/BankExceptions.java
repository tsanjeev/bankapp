package com.revature.exception;

import com.revature.util.LoggingUtil;

public class BankExceptions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -119618893307852007L;
	
	public BankExceptions(String message)
	{
		LoggingUtil.logError(message);
	}
}
