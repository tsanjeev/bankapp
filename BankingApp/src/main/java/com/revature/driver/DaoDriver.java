package com.revature.driver;

import com.revature.account.Account;
import com.revature.account.User;
import com.revature.dao.AccountDAOImp;
import com.revature.dao.UserDAOImp;

public class DaoDriver {
		public static void main(String[] args) {
			User user = new User("testName", "testPassWord",2);
			User userTwo = new User("Updatetwo111","updatetwo111", 1);
			
			Account account = new Account(1, "test", "test", user, userTwo);
			Account accountTwo = new Account(2, "tesafadt", "taafest", user, userTwo);
			
			UserDAOImp ud = new UserDAOImp();
			AccountDAOImp ad = new AccountDAOImp();
			try {
				//ud.userInsert(user);
				//ud.userInsert(userTwo);
				
				//ad.accountInsert(account);
				//ad.accountInsert(accountTwo);
				
				//ud.userUpdate(1, userTwo);
				//ad.accountUpdate(accountTwo, 2);
				
				
				//ad.accountDelete(1);
				//ud.userDelete(2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
