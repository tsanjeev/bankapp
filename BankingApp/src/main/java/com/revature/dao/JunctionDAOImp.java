package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.account.Account;
import com.revature.account.User;
import com.revature.util.ConnectionUtil;

public class JunctionDAOImp implements JunctionDAO{

	@Override
	public void accountInsert(int customerId, int accountId) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO CUSTOMER_ACCOUNTS VALUES (?,?)";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, customerId);
			stmt.setInt(2, accountId);
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
			throw new Exception("Insert Customer_Account failed");
		}
	}

	@Override
	public void accountUpdate(int accountOne, int accountTwo) throws Exception {
		// TODO Auto-generated method stub 
		/*
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE ACCOUNT SET primary_account_holder = ?,"
							+ " secondary_account_hlder = ?"
							+ " WHERE primary_account_holder = ? AND secondary_account_holder = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, account.getBalance());
			stmt.setInt(2, account.getAccountStatus());
			stmt.setInt(3, account.getAccountType());
			stmt.setInt(4, account.getPrimary().getCustomerId());
			stmt.setInt(5, account.getSecondary().getCustomerId());
			
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
			throw new Exception("Update Account failed: " + account);
		}*/
	}

	@Override
	public void accountDelete(int account_id) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<Account> getAccountsByUser(User user) throws Exception {
		// TODO Auto-generated method stub
			ArrayList<Account> accountList = new ArrayList<Account>();
			Connection connection = null;
			PreparedStatement stmt = null;

			try {
				connection = ConnectionUtil.getConnection();

				String sql = "SELECT * FROM CUSTOMER INNER JOIN CUSTOMER_ACCOUNTS ON ? = aid" + 
						"INNER JOIN ACCOUNT ON aid = accountid";
				stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery(sql);
				

				while (rs.next()) {
					Account account = new Account();

					account.setAccountNumber(rs.getInt("accountid"));
					account.setBalance(rs.getInt("balance"));
					account.setAccountStatus(rs.getString("account_status"));
					account.setAccountType(rs.getString("account_type"));
					account.setAccountStatus(rs.getString("account_status"));
					account.setAccountType(rs.getString("account_type"));
					
					UserDAOImp ud = new UserDAOImp();
					int primary = rs.getInt("primary_account_holder");
					int secondary = rs.getInt("secondary_account_holder");
					account.setPrimary(ud.getUserById(primary));
					account.setSecondary(ud.getUserById(secondary));
					
					accountList.add(account);
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

			return accountList;
		}
}
