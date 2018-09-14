package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.account.Account;
import com.revature.util.ConnectionUtil;

public class AccountDAOImp implements AccountDAO{

	@Override
	public ArrayList<Account> getAllAccounts() throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Account> accountList = new ArrayList<Account>();
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ConnectionUtil.getConnection();

			

			String sql = "SELECT * FROM USERS";
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

	@Override
	public void accountInsert(Account accountToSave) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ACCOUNT VALUES (?,?,?,?,?,?)";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, accountToSave.getAccountNumber());
			stmt.setInt(2,  0);
			stmt.setString(3, accountToSave.getAccountType());
			stmt.setString(4, accountToSave.getAccountStatus());
			stmt.setInt(5, accountToSave.getPrimary().getCustomerId());
			stmt.setInt(6, accountToSave.getSecondary().getCustomerId());
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
			throw new Exception("Insert Account failed: " + accountToSave);
		}
		
	}

	@Override
	public void accountUpdate(Account account, int accountNum) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE ACCOUNT SET balance = ?,"
							+ " account_status = ?,"
							+ " account_type = ?,"
							+ " primary_account_holder = ?,"
							+ " secondary_account_holder = ?"
							+ " WHERE accountid = ?";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, account.getBalance());
			stmt.setString(2, account.getAccountStatus());
			stmt.setString(3, account.getAccountType());
			stmt.setInt(4, account.getPrimary().getCustomerId());
			stmt.setInt(5, account.getSecondary().getCustomerId());
			stmt.setInt(6, accountNum);
			
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
		}
		
	}

	@Override
	public void accountDelete(int account_id) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;
		
			try {
				connection = ConnectionUtil.getConnection();
				String sql = "Delete From ACCOUNT where accountid = ?";
		
			
				stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, account_id);
				
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
				throw new Exception("Delete Account failed for Account ID: " + account_id);
			}
		}

	@Override
	public Account getAccountById(int account_id) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		Account account = new Account();
		
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM USER WHERE userid = ? ";
			
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, account_id);
						
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				account.setAccountNumber(rs.getInt("account"));
				account.setBalance(rs.getInt("balance"));
				account.setAccountStatus(rs.getString("account_status"));
				account.setAccountType(rs.getString("account_type"));
				
				UserDAOImp ud = new UserDAOImp();
				int primary = rs.getInt("primary_account_holder");
				int secondary = rs.getInt("secondary_account_holder");
				account.setPrimary(ud.getUserById(primary));
				account.setSecondary(ud.getUserById(secondary));
				
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
		return account;
	}

}
