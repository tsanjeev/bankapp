package com.revature.employee;

import java.io.Serializable;
import java.util.Scanner;

import com.revature.account.Account;
import com.revature.bank.Bank;
import com.revature.util.FileManager;
import com.revature.util.LoggingUtil;

public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2918143209529064807L;
	protected int employeeID;
	protected String position;
	Scanner scan;
	
	public Employee() {
		scan = new Scanner(System.in);
		this.position = "Teller";
	}
	
	
	
	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}

	public void setEmployeeID(int ID) {
		this.employeeID = ID;
	}
	
	public int getEmployeeID() {
		return this.employeeID;
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
	
	public void getCustomerInfo(Account user) {
		System.out.println(user.toString() +"\n\n");
	}
	
	public void employeeActions(Bank bank) {
		boolean isFinished = false;
		String input = null;
		while(!isFinished)
		{	
			System.out.println("Please Choose An Option: ");
			System.out.println("[Retrieve Account][Approve / Deny Account][Exit]:");
			input = scan.nextLine();
			switch(input.toLowerCase().toString()){
			case "retrieve":
								System.out.println("Enter account numbuer: ");
								int accountNumber = scan.nextInt();
								bank.displayAccount(accountNumber);
								scan.nextLine();
								break;
			case "approve":
								System.out.println("\nPending accounts: ");
								bank.displayPending();
								System.out.println("Please Enter Account to Approve/Deny:");
								String accNum = scan.nextLine();
								System.out.println("[Approve][Deny]: ");
								input = scan.nextLine();
								Account acc = bank.getAccount(Integer.parseInt(accNum));
								
								if("approve".equals(input.toLowerCase().trim())) {
									if(acc == null)
										System.out.println("Account not found\n\n");
									else {
										acc.setAccountStatus(Account.ACCOUNT_APPROVED);
										LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Approved account # " + acc + "\n\n");
									}
								}else if("deny".equals(input.toLowerCase().trim())) {
									if(acc == null)
										System.out.println("Account not found\n\n");
									else {
										acc.setAccountStatus(Account.ACCOUNT_DENIED);
										LoggingUtil.logInfo(getPosition()+": " + getEmployeeID() + " - Denied account # " + acc + "\n\n");
									}
								}	
								break;
						
			case "exit":
							isFinished = true;
							break;
			default:
							LoggingUtil.logWarn("Invalid Entry - try again\n\n");
			}
		}
		
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + "]";
		
	}
	
	public Employee employeeLogin(Bank bank) {
		boolean isFinished = false;
		Employee bankEmployee = null;
		while(!isFinished)
		{
			System.out.println("Please enter employee id: ");
			int empID = scan.nextInt();
			System.out.println("");
			if(Integer.toString((empID)).charAt(0) == '1'){
				System.out.println("Welcome Teller: "+ empID + "\n");
				bankEmployee = new Employee();
				bankEmployee.setEmployeeID(empID);
				isFinished = true;
			}
			else if(Integer.toString((empID)).charAt(0) == '5') {
				System.out.println("Welcome BankAdmin: "+ empID + "\n");
				bankEmployee = new BankAdmin();
				bankEmployee.setEmployeeID(empID);
				isFinished = true;
			}
			else {
				LoggingUtil.logWarn("Invalid Employee Id - try again.\n\n");
				System.out.println("Invalid Employee Id - try again.\n\n");
				
			}
		}
		bankEmployee.employeeActions(bank);
		FileManager.saveAccounts(bank);
		return bankEmployee;

	}
}