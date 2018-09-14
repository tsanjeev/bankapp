package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.account.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImp implements UserDAO {

	public ArrayList<User> getAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = ConnectionUtil.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM USERS";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User newUser = new User();

				newUser.setCustomerId(rs.getInt("customerid"));
				newUser.setUserName(rs.getString("username"));
				newUser.setPassword(rs.getString("password"));
				userList.add(newUser);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userList;
	}

	public void userInsert(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO USER VALUES (?,?,?)";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, user.getCustomerId());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getPassword());
			success = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			throw new Exception("Insert user failed: " + user);
		}

	}
		
	@Override
	public void userUpdate(int userId, User user) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE CUSTOMER SET username = ?, password = ? WHERE customerid= ?";

			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setInt(3, userId);
			
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			throw new Exception("Update USER failed: " + user);
		}
	}

	public void userDelete(int userId) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		
			try {
				connection = ConnectionUtil.getConnection();
				String sql = "Delete From CUSTOMER where customerid = ?";
		
			
				stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, userId);
				
				success = stmt.executeUpdate(); 
				
			} catch (SQLException e) { 
				e.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
			if (success == 0) {
				throw new Exception("Delete User failed for USER with ID " + userId);
			}
		}
	

	@Override
	public User getUserById(int userId) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		User newUser = new User();
		
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USER WHERE userid = ? ";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, userId);
						
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				newUser.setCustomerId(rs.getInt("userid"));
				newUser.setUserName(rs.getString("username"));
				newUser.setPassword(rs.getString("password"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newUser;
	}
}

