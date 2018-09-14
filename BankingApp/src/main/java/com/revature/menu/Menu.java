package com.revature.menu;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.User;
import com.revature.bank.BankHandler;
import com.revature.bank.Bank;
import com.revature.employee.Employee;
import com.revature.util.FileManager;
import com.revature.util.LoggingUtil;

public class Menu {
	
	

	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		Bank bank = null;
		if(FileManager.initializeBank() != null)
			bank = FileManager.initializeBank();
		else
			bank = new Bank();
		
		bank.displayAllAccounts();
		bank.displayAllUsers();
		String input = null;
		boolean hasQuit = false;
		while(!hasQuit)
		{
			System.out.println("Welcome to The Bank.\n" );
			System.out.println("Please choose an option: ");
			System.out.println("[Register][Login][Employee][Exit]: " );
			input = scan.nextLine();
			
			switch(input.toLowerCase().trim())
			{
			
				case "register":
									BankHandler.register(bank);
									bank.displayAllAccounts();
									bank.displayAllUsers();
									break;
				
				case "login":
									System.out.println("Please Enter A Username: " );
									String username = scan.nextLine();
									System.out.println("Please Enter A Password: " );
									String password = scan.nextLine();
									User user = BankHandler.customerLogin(bank, username, password);
									//System.out.println(user.toString());
									System.out.println(user.getUserName()+ " Successfully Logged In.\n");
									boolean isDone = false;
									while(!isDone)
									{
										bank.displayUsersAccounts(user);
										System.out.println("Please Choose An Option: ");
										System.out.println("[New Account][Deposit][Withdraw][Transfer][Exit]: ");
										String userInput = scan.nextLine();
										switch(userInput.toLowerCase().trim()) {
											
											case "new account":		System.out.println("[Regular] or [Joint] Account: ");
																	userInput = scan.nextLine();
																	
																	if(userInput.trim().equalsIgnoreCase("REGULAR")){
																		Account account = BankHandler.applyRegular(bank, user);
																		//System.out.println(account.toString());
																	}
																	else if(userInput.trim().equalsIgnoreCase("JOINT")){
																		System.out.println("Please Enter 2nd User's Username: ");
																		userInput = scan.nextLine();
																		//User userTwo = BankHandler.findUser(bank, userInput);
																		//applyJoint(bank, user, userTwo);
																	}
																	break;
											case "deposit":
																	System.out.println("Please Enter Amount For Deposit: ");
																	String amountDeposit = scan.nextLine();
																	System.out.println("Please Enter Account #:");
																	String accNum = scan.nextLine();
																	Account checkAccount = BankHandler.findAccount(bank, Integer.parseInt(accNum));
																	if(!checkAccount.getAccountStatus().equals(Account.ACCOUNT_PENDING))
																		BankHandler.deposit(checkAccount, Integer.parseInt(amountDeposit));
																	else {
																		LoggingUtil.logWarn("Account: " + checkAccount.getAccountNumber()+ " - Status Pending - No Transactions Available At This Time\n\n");
																	}
																	FileManager.saveAccounts(bank);
																	break;
											
											case "withdraw":		System.out.println("Please Enter Amount For Withdraw: ");
																	String amountWithdraw = scan.nextLine();
																	System.out.println("Please Enter Account #:");
																	String accNumTwo = scan.nextLine();
																	Account checkAccountTwo = BankHandler.findAccount(bank, Integer.parseInt(accNumTwo));
																	if(!checkAccountTwo.getAccountStatus().equals(Account.ACCOUNT_PENDING))
																		BankHandler.deposit(checkAccountTwo, Integer.parseInt(amountWithdraw));
																	else {
																		LoggingUtil.logWarn("Account: " + checkAccountTwo.getAccountNumber()+ " - Status Pending - No Transactions Available At This Time\n\n");
																	}
																	FileManager.saveAccounts(bank);
																	break;
											case "transfer":
																	FileManager.saveAccounts(bank);
																	break;
											case "exit":
																	isDone = true;
																	break;
											default :
																	System.out.println("Invalid Entry - Try Again\n\n");
										}	
									}
									break;
				
				case "employee":
									Employee emp = new Employee();
									Employee worker = emp.employeeLogin(bank);
									worker.employeeActions(bank);
									break;
				case "exit":		
									hasQuit = true;
									break;
				default:			
									System.out.println("Invalid Entry - Try Again\n\n");
					
			}	
		}
		System.out.println("Exiting Bank");
		scan.close();
	}
	}
				
		