package com.revature.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pojos.Account;
import com.revature.pojos.SingleAccount;
import com.revature.register.Register;

public class TestRegister {

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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegisterSingle() {
		String firstName = "John";
		String lastName = "Doe";
		String userName = "qwerty";
		String password = "12345";
		String accountType = Account.ACCOUNT_SAVINGS;
		SingleAccount newUser = (SingleAccount)Register.registerSingle(firstName, lastName, accountType, userName, password);
		assertEquals(newUser.getFirstName(), firstName);
		assertEquals(newUser.getLastName(), lastName);
		assertEquals(newUser.getAccountType(), accountType);
		assertEquals(newUser.getUserName(), userName);
		assertEquals(newUser.getPassword(), password);
	}
	
	@Test
	public void testRegisterJoint() {
		
	}

}