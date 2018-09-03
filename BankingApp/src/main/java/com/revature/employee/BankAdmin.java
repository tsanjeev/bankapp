package com.revature.employee;

import java.io.Serializable;

public class BankAdmin extends Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6228681121064269783L;

	@Override
	public String toString() {
		return "BankAdmin [employeeID=" + employeeID + "]";
	}
	
	public BankAdmin() {
		this.position = "BankAdmin";
	}
	

}
