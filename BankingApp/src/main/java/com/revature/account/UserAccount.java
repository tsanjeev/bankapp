package com.revature.account;

import java.io.Serializable;

import com.revature.util.LoggingUtil;

public class UserAccount implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8482258227837614516L;
	public static final String ACCOUNT_APPROVED = "APPROVED";
	public static final String ACCOUNT_DENIED = "DENIED";
	public static final String ACCOUNT_CHECKING = "CHECKING";
	public static final String ACCOUNT_SAVINGS = "SAVINGS";
	public static final String ACCOUNT_PENDING = "PENDING";
	public static final String JOINT_ACCOUNT = "JOINT_ACCOUNT";
	public static final String REGULAR_ACCOUNT = "REGULAR_ACCOUNT";
	
	private int balance;
	private int accountNumber;
	private String accountType;
	private String accountStatus;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String accType;
	private UserAccount jointAccount;
	

	
	public void setAccType(String acctype) {
		this.accType = acctype;
	}
	
	public String getAccType() {
		return this.accType;
	}
	
	public UserAccount getJointAccount() {
		return this.jointAccount;
	}
	
	public void setJointAccount(UserAccount jointAccount) {
		this.jointAccount = jointAccount;
	}
	
	public void transfer(int amount, UserAccount account) {
		// TODO Auto-generated method stu
		if(amount > this.balance) {
			LoggingUtil.logError("Invalid withdraw amount - Withdraw cancelled.\n");
		}
		else {
				withdraw(amount);
				account.deposit(amount);
				LoggingUtil.logInfo("Account #" + this.getAccountNumber() + " successfully transferred " + amount + ", new balance: $" + this.balance +".\n\n");
		}
	}
	public void setBalance(int amount) {
			// TODO Auto-generated method stub
			balance = amount;
	}
	public void deposit(int amount) {
		// TODO Auto-generated method stub
			balance += amount;
			LoggingUtil.logInfo("Account #" + this.getAccountNumber() + " successfully deposited " + amount + ", new balance: $" + this.balance +".\n\n");
			
	}
	
	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		if(amount > this.balance) {
			LoggingUtil.logError("Insufficient Funds - Transaction cancelled.\n\n");
			System.out.println("Insufficient Funds - Transaction cancelled.\n\n");
		}
		else {
			balance -= amount;
			LoggingUtil.logInfo("Account #" + this.getAccountNumber() + " successfully withdrew " + amount + ", new balance: $" + this.balance +".\n\n");
			System.out.println("Account #" + this.getAccountNumber() + " successfully withdrew " + amount + ", new balance: $" + this.balance +".\n\n");
		}
			
		
	}
	public int getAccountNumber() {
		// TODO Auto-generated method stub
		return this.accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		// TODO Auto-generated method stub
		this.accountNumber = accountNumber;
		
	}
	
	public int getBalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}
	public String getAccountType() {
		// TODO Auto-generated method stub
		return this.accountType;
	}
	public void setAccountType(String accountType) {
		// TODO Auto-generated method stub
		this.accountType = accountType;
	}
	public void setAccountStatus(String status) {
		// TODO Auto-generated method stub
		this.accountStatus = status;
		
	}
	
	public String getAccountStatus() {
		// TODO Auto-generated method stub
		return this.accountStatus;
	}
		
	public void setFirstName(String firstName) {
		// TODO Auto-generated method stub
		this.firstName = firstName;
		
	}
	public void setLastName(String lastName) {
		// TODO Auto-generated method stub
		this.lastName = lastName;
	}
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}
	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}
	public void setUserName(String userName) {
		// TODO Auto-generated method stub
		this.userName = userName;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
		
	}
	
	@Override
	public String toString() {
		return "UserAccount [accType=" + accType + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", accountType=" + accountType + ", accountStatus=" + accountStatus + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
