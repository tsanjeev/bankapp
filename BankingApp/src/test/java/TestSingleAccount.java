import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pojos.SingleAccount;

public class TestSingleAccount {

	SingleAccount user;
	int initialBalance = 500;
	int accountNumber = 123456;
	String accountType = "Checking";
	
	
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
		user.setAccountType(accountType);
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
		user.setAccountType("Savings");
		assertEquals(user.getAccountType(), "Savings");
	}
	
	@Test
	public void testGetAccountType() {
		assertEquals(user.getAccountType(), "Checking");
	}
	
}
