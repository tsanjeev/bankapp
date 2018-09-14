package com.revature.dao;

public interface JunctionDAO {
	void accountInsert(int one, int two) throws Exception;
	void accountUpdate(int one, int two) throws Exception;
	void accountDelete(int account) throws Exception;
}
