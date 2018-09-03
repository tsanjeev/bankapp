package com.revature.employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.bank.Bank;
import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2918143209529064807L;
	private static final String filename = "bankEmployees.dat";
	protected int employeeID;
	Scanner scan;
	
	public Employee() {
		scan = new Scanner(System.in);
	}
	
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
	
	public void approveApplication(Account person) {
		person.setAccountStatus(Account.ACCOUNT_APPROVED);
	}

	public void denyApplication(Account person) {
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
	
	public void getCustomerInfo(Account user) {
		LoggingUtil.logInfo(user.toString());
	}
	
	public void employeeActions(Bank bank) {
		boolean isFinished = false;
		int input = 0;
		while(!isFinished)
		{
			LoggingUtil.logInfo("1: Retrieve customer information\n");
			LoggingUtil.logInfo("2: Approve or deny pending accounts\n");
			LoggingUtil.logInfo("3: Return to main menu\n");
			LoggingUtil.logInfo("Please choose an action: ");
			input = scan.nextInt();
			if(input == 1) {
				LoggingUtil.logInfo("Enter account numbuer: ");
				int accountNumber = scan.nextInt();
				try {
						getCustomerInfo((bank.getAccount(accountNumber)));
				} catch (BankExceptions e) {
					LoggingUtil.logWarn("Account not found\n");
				} 
			}
			else if(input == 2) {
				LoggingUtil.logInfo("Pending accounts: \n");
				if(bank.getPendingAccounts().size() > 1)
				{
					bank.displayAccounts(( bank.getPendingAccounts()));
					LoggingUtil.logInfo("Choose account to approve or deny\n");
					LoggingUtil.logInfo("Account number: ");
					int accountNum = scan.nextInt();
					LoggingUtil.logInfo("1: approve\n");
					LoggingUtil.logInfo("2: deny\n");
					LoggingUtil.logInfo("Please choose an action: ");
					input = scan.nextInt();
					if(input == 1) {
						try {
							approveApplication(bank.getAccount(accountNum));
						} catch (BankExceptions e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(input == 2) {
						try {
							denyApplication(bank.getAccount(accountNum));
						} catch (BankExceptions e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					bank.saveAccounts();
				}
			}
			else if(input == 3) {
				isFinished = true;
			}
	}
	}
	public void saveEmployeeList(List<Employee> employeeList) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(employeeList);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Employee> readEmployeeList() {
		List<Employee> employeeList = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			employeeList = (List<Employee>) ois.readObject();
			//displayPendingAccounts(getPendingAccounts());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return employeeList;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + "]";
		
	}
	
	public static void displayEmployeeList(List<Employee> emp) {
		for(int j = 0; j < emp.size(); j++)
			LoggingUtil.logInfo(emp.get(j).toString() + "\n");
	}
}
