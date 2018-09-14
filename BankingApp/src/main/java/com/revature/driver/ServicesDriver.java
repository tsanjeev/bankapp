package com.revature.driver;

import java.util.Scanner;

import com.revature.account.Account;
import com.revature.account.User;
import com.revature.bank.AccountServices;
import com.revature.bank.BankHandler;
import com.revature.dao.AccountDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.employee.Employee;
import com.revature.util.FileManager;
import com.revature.util.LoggingUtil;

public class ServicesDriver {
	public static void main(String[] args) {
		
	Scanner scan = new Scanner(System.in);

	String input = null;
	boolean hasQuit = false;
	UserDAOImp ud = new UserDAOImp();
	AccountDAOImp ad = new AccountDAOImp();
	while(!hasQuit)
	{
		System.out.println("Welcome to The Bank.\n" );
		System.out.println("Please choose an option: ");
		System.out.println("[Register][Login][Employee][Exit]: " );
		input = scan.nextLine();
		
		switch(input.toLowerCase().trim())
		{
		
			case "register":
								User newUser = AccountServices.register();
								try {
									ud.userInsert(newUser);
									System.out.println(("Account Created: " + newUser +"\n\n"));
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								break;
			
			case "login":
								System.out.println("Please Enter A Username: " );
								String username = scan.nextLine();
								System.out.println("Please Enter A Password: " );
								String password = scan.nextLine();
								User loggedUser = ud.getUserByCred(username, password);
								System.out.println(loggedUser.toString());
								boolean isDone = false;
								while(!isDone)
								{
									//bank.displayUsersAccounts(user);
									System.out.println("Please Choose An Option: ");
									System.out.println("[New Account][Deposit][Withdraw][Transfer][Exit]: ");
									String userInput = scan.nextLine();
									if(loggedUser == null) {
										userInput = "exit";
									}
									switch(userInput.toLowerCase().trim()) {
										
										case "new account":		System.out.println("[Regular] or [Joint] Account: ");
																userInput = scan.nextLine();
																
																if(userInput.trim().equalsIgnoreCase("REGULAR")){
																	try {
																		Account account = AccountServices.applyRegular(loggedUser);
																		System.out.println("Account Created!\n\n");
																	} catch (Exception e) {
																		// TODO Auto-generated catch block
																		e.printStackTrace();
																	}
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
																try {
																	AccountServices.deposit(AccountServices.getAccountById(Integer.parseInt(accNum)), Integer.parseInt(amountDeposit));
																} catch (NumberFormatException e) {
																	// TODO Auto-generated catch block
																	e.printStackTrace();
																} catch (Exception e) {
																	// TODO Auto-generated catch block
																	e.printStackTrace();
																}
																break;
										
										case "withdraw":		System.out.println("Please Enter Amount For Withdraw: ");
																String amountWithdraw = scan.nextLine();
																System.out.println("Please Enter Account #:");
																String accNumTwo = scan.nextLine();
																//Account checkAccountTwo = BankHandler.findAccount(bank, Integer.parseInt(accNumTwo));
																//if(!checkAccountTwo.getAccountStatus().equals(Account.ACCOUNT_PENDING))
																//	BankHandler.deposit(checkAccountTwo, Integer.parseInt(amountWithdraw));
																//else {
																	//LoggingUtil.logWarn("Account: " + checkAccountTwo.getAccountNumber()+ " - Status Pending - No Transactions Available At This Time\n\n");
																//}
																
																break;
										case "transfer":
																
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
								//Employee worker = emp.employeeLogin(bank);
								//worker.employeeActions(bank);
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
