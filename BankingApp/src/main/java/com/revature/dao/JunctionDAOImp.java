package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class JunctionDAOImp implements JunctionDAO{

	@Override
	public void accountInsert(int accountOne, int accountTwo) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO CUSTOMER_ACCOUNT VALUES (?,?)";

			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, accountOne);
			stmt.setInt(2, accountTwo);
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

}
