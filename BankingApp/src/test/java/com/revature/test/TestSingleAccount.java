package com.revature.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.account.Account;
import com.revature.account.SingleAccount;
import com.revature.exception.BankExceptions;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TestSingleAccount {

	SingleAccount user;
	int initialBalance = 500;
	int accountNumber = 123456;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new SingleAccount();
		user.setBalance(initialBalance);
		user.setAccountNumber(accountNumber);
		user.setAccountType(Account.ACCOUNT_CHECKING);
		user.setAccountStatus(Account.ACCOUNT_APPROVED);
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setUserName("qwerty");
		user.setPassword("12345");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeposit() throws BankExceptions {
		int depositAmount = 300;
		user.deposit(depositAmount);
		assertEquals(user.getBalance() , initialBalance + depositAmount);
	}
	
	@Test(expected = BankExceptions.class)
	public void testDepositNegativeAmount() throws BankExceptions {
		int depositAmount = -300;
		user.deposit(depositAmount);
	}
	
	@Test(expected = BankExceptions.class)
	public void testWithdrawtTooMuch() throws BankExceptions {
		int amount = 6300;
		user.withdraw(amount);
	}
	
	@Test
	public void testTransferTooMuch() throws BankExceptions {
		
		Account userTwo = new SingleAccount();
		userTwo.setBalance(initialBalance);
		userTwo.setAccountNumber(2);
		userTwo.setAccountType(Account.ACCOUNT_CHECKING);
		userTwo.setAccountStatus(Account.ACCOUNT_PENDING);
		userTwo.setFirstName("John");
		userTwo.setLastName("Doe");
		userTwo.setUserName("qwerty");
		userTwo.setPassword("12345");
		int amount = 6300;
		user.transfer(amount, userTwo);
		assertEquals(user.getBalance() , initialBalance);
		assertEquals(userTwo.getBalance() , initialBalance);
		
	}
	
	@Test
	public void testTransfer() throws BankExceptions {
		
		Account userTwo = new SingleAccount();
		userTwo.setBalance(initialBalance);
		userTwo.setAccountNumber(2);
		userTwo.setAccountType(Account.ACCOUNT_CHECKING);
		userTwo.setAccountStatus(Account.ACCOUNT_APPROVED);
		userTwo.setFirstName("John");
		userTwo.setLastName("Doe");
		userTwo.setUserName("qwerty");
		userTwo.setPassword("12345");
		int amount = 300;
		user.transfer(amount, userTwo);
		assertEquals(user.getBalance() , initialBalance - amount);
		assertEquals(userTwo.getBalance() , initialBalance + amount);
		
	}
	
	@Test
	public void testSetBalance() {
		int setAmount = 100;
		user.setBalance(setAmount);
		assertEquals(user.getBalance(), setAmount);
	}
	
	@Test
	public void testWithdraw() throws BankExceptions {
		int amount = 100;
		user.withdraw(amount);
		assertEquals(user.getBalance(), initialBalance - amount);
	}
	
	@Test
	public void testGetAccountNumber() {
		
		assertEquals(user.getAccountNumber(), accountNumber);
	}
	
	@Test
	public void testSetAccountNumber() {
		int accountNum = 654321;
		user.setAccountNumber(accountNum);
		assertEquals(user.getAccountNumber(), accountNum);
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(user.getBalance(), initialBalance);
	}
	
	@Test
	public void testSetAccountType() {
		user.setAccountType(Account.ACCOUNT_SAVINGS);
		assertEquals(user.getAccountType(), Account.ACCOUNT_SAVINGS);
	}
	
	@Test
	public void testGetAccountType() {
		assertEquals(user.getAccountType(), Account.ACCOUNT_CHECKING);
	}
	
	@Test
	public void testSetAccountStatus() {
		user.setAccountStatus(Account.ACCOUNT_PENDING);
		assertEquals(user.getAccountStatus(), Account.ACCOUNT_PENDING);
	}
	
	@Test
	public void testGetAccountStatus() {
		assertEquals(user.getAccountStatus(), Account.ACCOUNT_APPROVED);
	}
	
	@Test
	public void testSetFirstName() {
		user.setFirstName("Jane");
		assertEquals(user.getFirstName(), "Jane");
	}
	
	@Test
	public void testSetLastName() {
		user.setLastName("Plane");
		assertEquals(user.getLastName(), "Plane");
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals(user.getFirstName(), "John");
	}
	
	@Test
	public void testGetLastName() {
		assertEquals(user.getLastName(), "Doe");
	}
	
	@Test
	public void testGetUserName() {
		assertEquals(user.getUserName(), "qwerty");
	}
	@Test
	public void testsetUserName() {
		user.setUserName("ytrewq");
		assertEquals(user.getUserName(), "ytrewq");
	}
	
	@Test
	public void testGetPassword() {
		assertEquals(user.getPassword(), "12345");
	}
	
	@Test
	public void testSetPassword() {
		user.setPassword("54321");
		assertEquals(user.getPassword(), "54321");
	}
}
