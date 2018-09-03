package com.revature.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

import com.revature.account.Account;
import com.revature.account.SingleAccount;
import com.revature.exception.BankExceptions;
import com.revature.util.LoggingUtil;

public class Bank implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866137718288831030L;
	private static final String filename = "bankTransactions.dat";
	List<Account> userAccounts = null;
	private int numberOfAccounts;
	Scanner scan;
	
	public Bank() {
		
		scan = new Scanner(System.in);
		//userAccounts = readAccounts();
		if(readAccounts() != null){
			userAccounts = readAccounts();
		}
		else
			userAccounts = new ArrayList<Account>();
		setNumberOfAccounts(getNumberOfAccounts());
		//displayPendingAccounts(userAccounts);
		
	}
	

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}


	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}
	
	public void incrementAccountNumbers() {
		numberOfAccounts++;
	}
	
	public void applySingle() {
		//Scanner scan = new Scanner(System.in);
		LoggingUtil.logInfo("Please enter your first name: ");
		String firstName = scan.nextLine();
		//LoggingUtil.logInfo("You entered: "+ firstName);
		LoggingUtil.logInfo("Please enter your last name: ");
		String lastName = scan.nextLine();
		//LoggingUtil.logInfo("You entered: "+ lastName);
		LoggingUtil.logInfo("Please create a user name: ");
		String userName = scan.nextLine();
		//LoggingUtil.logInfo("You entered "+ userName);
		LoggingUtil.logInfo("Please create a password:  ");
		String password = scan.nextLine();
		//LoggingUtil.logInfo("You entered "+ password);
		LoggingUtil.logInfo("Please choose an account type Checking/Savings: ");
		String accountType = scan.nextLine();
		//LoggingUtil.logInfo("You entered "+ accountType);
		
		incrementAccountNumbers();
		userAccounts.add(Register.registerSingle(firstName, lastName, accountType, userName, password, numberOfAccounts));
		saveAccounts(userAccounts);
		LoggingUtil.logInfo("Account Saved - pending approval - logging off\n\n");
	}
	
	public void applyJoint() {
		
	}
	
	public List<Account> getPendingAccounts(){
		List<Account> pendingAccounts = new ArrayList<Account>();
		for(int j = 0; j < userAccounts.size(); j++) {
			if(userAccounts.get(j).getAccountStatus() == Account.ACCOUNT_PENDING)
				pendingAccounts.add(userAccounts.get(j));
		}
		return pendingAccounts;
	}
	
	public void displayPendingAccounts(List<Account> accounts) {
		for(int x = 0; x < accounts.size(); x++) {
			LoggingUtil.logInfo(accounts.get(x).toString());
		}
	}
	
	public Account customerLogin() throws BankExceptions{
		//Scanner scan = new Scanner(System.in);
		LoggingUtil.logInfo("Please enter a username: ");
		String userName = scan.nextLine();
		//LoggingUtil.logInfo("You entered: " + userName);
		LoggingUtil.logInfo("Please enter a password: ");
		String password = scan.nextLine();
		//LoggingUtil.logInfo("You entered: " + password);
		
		Account user = null;
		for(int x = 0; x < userAccounts.size(); x++) {
			if(userAccounts.get(x).getUserName().equals(userName) && (userAccounts.get(x).getPassword().equals(password))) {
				user = userAccounts.get(x);
			}
		}
		
		if(user == null) {
			throw new BankExceptions("Username / Password not found.\n");
		}
		
		return user;
	}
	
	public void saveAccounts(List<Account> bankAccounts) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(bankAccounts);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Account> readAccounts() {
		List<Account> bankAccounts = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			bankAccounts = (List<Account>) ois.readObject();
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
			return bankAccounts;
	}
	
	
	public void withdraw(Account user, int amount) throws BankExceptions {
		user.withdraw(amount);
	}
	
	public void deposit(Account user) throws BankExceptions {
		int input = 0;
		LoggingUtil.logInfo("Deposit amount : ");
		input = scan.nextInt();
		user.deposit(input);
		
	}
	
	public void transfer(Account transferFrom, Account transferTo, int amount) throws BankExceptions {
		transferFrom.transfer(amount, transferTo);
	}
	
	public Account getAccount(int accountNum) throws BankExceptions {
		Account acc = null;
		for(int j = 0; j < userAccounts.size(); j++) {
			if(accountNum == userAccounts.get(j).getAccountNumber())
				acc = userAccounts.get(j);
		}
		if(acc == null)
			throw new BankExceptions("Account not found");
		return acc;
	}
}
