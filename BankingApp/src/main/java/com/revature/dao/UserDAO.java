package com.revature.dao;

import java.util.ArrayList;

import com.revature.account.User;

public interface UserDAO {
	
	ArrayList<User> getAllUsers();
	void userInsert(User user) throws Exception;
	void userUpdate(int userId, User user) throws Exception;
	void userDelete(int userId) throws Exception;
	User getUserById(int userId) throws Exception;
}
