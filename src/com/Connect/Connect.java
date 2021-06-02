package com.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.aspire.ConnectBean.ConnectBean;

public class Connect {
	Connection connection = null;

	public static Connection getConnection()  {
		Connection connection = null;
		ConnectBean connectBean =new ConnectBean();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	
		try {
			connection = DriverManager.getConnection(connectBean.getUrl(), connectBean.getUserName(),connectBean.getPassword());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return connection;
	}

}
