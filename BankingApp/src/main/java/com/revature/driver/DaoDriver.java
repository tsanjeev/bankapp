package com.revature.driver;

import com.revature.account.User;
import com.revature.dao.UserDAOImp;

public class DaoDriver {
		public static void main(String[] args) {
			User user = new User("testName", "testPassWord",2);
			User userTwo = new User("Updatetwo","updatetwo", 1);
			UserDAOImp ud = new UserDAOImp();
			try {
				//ud.userInsert(user);
				ud.userDelete(1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
