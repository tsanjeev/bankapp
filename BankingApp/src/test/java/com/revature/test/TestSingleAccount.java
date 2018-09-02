package com.revature.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pojos.Account;
import com.revature.pojos.SingleAccount;

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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeposit() {
		int depositAmount = 300;
		user.deposit(depositAmount);
		assertEquals(user.getBalance() , initialBalance + depositAmount);
	}
	
	@Test
	public void testSetBalance() {
		int setAmount = 100;
		user.setBalance(setAmount);
		assertEquals(user.getBalance(), setAmount);
	}
	
	@Test
	public void testWithdraw() {
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
}
