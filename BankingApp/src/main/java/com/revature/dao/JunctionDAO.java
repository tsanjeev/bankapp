package com.revature.dao;

import java.util.ArrayList;

import com.revature.account.Account;
import com.revature.account.User;

public interface JunctionDAO {
	void accountInsert(int one, int two) throws Exception;
	void accountUpdate(int one, int two) throws Exception;
	void accountDelete(int account) throws Exception;
	ArrayList<Account> getAccountsByUser(User user) throws Exception;
}
