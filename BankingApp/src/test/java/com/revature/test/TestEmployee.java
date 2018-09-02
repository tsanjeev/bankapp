package com.revature.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.account.Account;
import com.revature.account.SingleAccount;
import com.revature.employee.Employee;

public class TestEmployee {

	SingleAccount user;
	Employee teller;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		int initialBalance = 500;
		int accountNumber = 123456;
		teller = new Employee();
		teller.setEmployeeID(22);
		user = new SingleAccount();
		user.setBalance(initialBalance);
		user.setAccountNumber(accountNumber);
		user.setAccountType(Account.ACCOUNT_CHECKING);
		user.setAccountStatus(Account.ACCOUNT_PENDING);
		user.setFirstName("John");
		user.setLastName("Doe");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetEmployeeID() {
		int employeeID = 39;
		teller.setEmployeeID(employeeID);
		assertEquals(teller.getEmployeeID(), employeeID);
	}
	
	@Test
	public void testGetEmployeeID() {
		assertEquals(teller.getEmployeeID(), 22);
	}
	
	@Test
	public void testGetUserAccountNumber() {
		assertEquals(user.getAccountNumber(), teller.getAccountNumber(user));
	}
	
	@Test
	public void testGetUserBalance() {
		assertEquals(user.getBalance(), teller.getBalance(user));
	}
	
	@Test
	public void testGetUserAccountType() {
		assertEquals(user.getAccountType(), teller.getAccountType(user));
	}
	
	@Test
	public void testApproveApplication() {
		teller.approveApplication(user);
		assertEquals(user.getAccountStatus(), teller.getAccountStatus(user));
	}
	
	@Test
	public void testDenyApplication() {
		teller.denyApplication(user);
		assertEquals(user.getAccountStatus(), teller.getAccountStatus(user));
	}
	
	@Test
	public void testGetAccountStatus() {
		assertEquals(user.getAccountStatus(), teller.getAccountStatus(user));
	}
	
	@Test
	public void testGetUserFirstName() {
		assertEquals(user.getFirstName(), teller.getUserFirstName(user));
	}

	@Test
	public void testGetUserLastName() {
		assertEquals(user.getLastName(), teller.getUserLastName(user));
	}
}
