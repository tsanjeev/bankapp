package com.revature.account;

import java.io.Serializable;

import com.revature.exception.BankExceptions;

public class JointAccount extends Account implements Serializable{

	private String firstFirstName;
	private String firstLastName;
	private String firstUserName;
	private String firstPassword;
	
	private String secondFirstName;
	private String secondLastName;
	private String secondUserName;
	private String secondPassword;
	private String accType;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5934014473470305963L;

	
	
	 
	@Override
	public String toString() {
		return "JointAccount [balance=" + balance + ", accountNumber=" + accountNumber + ", accountStatus="
				+ accountStatus + ", accountType=" + accountType + ", firstLastName=" + firstLastName
				+ ", firstFirstName=" + firstFirstName + ", firstPassword=" + firstPassword + ", firstUserName="
				+ firstUserName + ", secondFirstName=" + secondFirstName + ", secondLastName=" + secondLastName
				+ ", secondPassword=" + secondPassword + ", secondUserName=" + secondUserName + "]";
	}

	public JointAccount(String firstFirstName, String firstLastName, String firstUserName, String firstPassword,
			String secondFirstName, String secondLastName, String secondUserName, String secondPassword) {
		this.firstFirstName = firstFirstName;
		this.firstLastName = firstLastName;
		this.firstUserName = firstUserName;
		this.firstPassword = firstPassword;
		this.secondFirstName = secondFirstName;
		this.secondLastName = secondLastName;
		this.secondUserName = secondUserName;
		this.secondPassword = secondPassword;
	}

	
	
	public void setAccType(String name)
	{
		this.accType = name;
	}
	
	public String getAccType() {
		return accType;
	}

	public String getFirstFirstName() {
		return this.firstFirstName;
	}
	
	public String getSecondFirstName() {
		return this.secondFirstName;
	}
	

	public void setFirstNames(String firstNameOne, String firstNameTwo) {
		// TODO Auto-generated method stub
		this.firstFirstName = firstNameOne;
		this.secondFirstName = firstNameTwo;
	}

	public void setLastNames(String lastNameOne, String lastNameTwo) {
		// TODO Auto-generated method stub
		this.firstLastName = lastNameOne;
		this.secondLastName = lastNameTwo;
	}

	public String getSecondLastName() {
		// TODO Auto-generated method stub
		return this.secondLastName;
	}

	public String getFirstLastName() {
		// TODO Auto-generated method stub
		return this.firstLastName;
	}
	
	public String getSecondUserName() {
		return this.secondUserName;
	}

	public String getFirstUserName() {
		// TODO Auto-generated method stub
		return this.firstUserName;
		
	}	
	
	public void setUserNames(String userNameOne, String userNameTwo) {
		// TODO Auto-generated method stub
		this.firstUserName = userNameOne;
		this.secondUserName = userNameTwo;
	}

	public String getPasswordOne() {
		return this.firstPassword;
	}
	public String getPasswordTwo() {
		// TODO Auto-generated method stub
		return this.secondPassword;
	}

	public void setPassword(String passwordOne, String passwordTwo) {
		// TODO Auto-generated method stub
		this.firstPassword = passwordOne;
		this.secondPassword = passwordTwo;
	}

}
