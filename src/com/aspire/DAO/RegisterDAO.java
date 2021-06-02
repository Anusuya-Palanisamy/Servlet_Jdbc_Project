package com.aspire.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Connect.Connect;
import com.aspire.bean.UserBean;
import com.aspire.queryUtils.QueryConstants;

public class RegisterDAO {
	

	public static boolean register(UserBean loginbean) {
		QueryConstants queryConstants = new QueryConstants();
		Connection connnection = null;
		Statement statement = null;
		int resultSet;

		String userName = loginbean.getUserName();
		String password = loginbean.getPassword();
		String firstName = loginbean.getFirstName();
		String lastName = loginbean.getLastName();
		String mobile = loginbean.getMobile();
		String conformPass = loginbean.getConformPass();
		String street = loginbean.getStreet();
		String city = loginbean.getCity();
		String post = loginbean.getPost();
		String pincode = loginbean.getPincode();

		try {
			connnection = Connect.getConnection();
			statement = connnection.createStatement();
			/**
			 * Register Statement
			 */
			PreparedStatement preparedstatement = connnection.prepareStatement(queryConstants.getRegisterQuery());
			preparedstatement.setString(1, firstName);
			preparedstatement.setString(2, lastName);
			preparedstatement.setString(3, userName);
			preparedstatement.setString(4, password);
			preparedstatement.setString(5, mobile);
			preparedstatement.setString(6, conformPass);
			preparedstatement.setString(7, street);
			preparedstatement.setString(8, city);
			preparedstatement.setString(9, post);
			preparedstatement.setString(10, pincode);
			int i = preparedstatement.executeUpdate();

			if (i > 0) {
				return true;
			}

		} catch (

		SQLException exception)

		{
			exception.printStackTrace();
		}
		return false;
	}
}
