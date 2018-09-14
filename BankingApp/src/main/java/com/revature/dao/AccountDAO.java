package com.revature.dao;

import java.util.ArrayList;

import com.revature.account.Account;

public interface AccountDAO {

		ArrayList<Account> getAllAccounts() throws Exception;
		void accountInsert(Account accountToSave) throws Exception;
		void accountUpdate(Account account, int accountNum) throws Exception;
		void accountDelete(int account_id) throws Exception;
		Account getAccountById(int account_id) throws Exception;
		
}
