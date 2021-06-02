package com.aspire.ConnectBean;

public class ConnectBean {
	private static String url = "jdbc:mysql://localhost:3306/loginapp";
	private static  String userName = "root";
	private static String password = "aspire@123";
	
	/**
	 * 
	 * @Connecting the Database
	 */
	public static String getUrl() {
		return url;
	}
	public static String getUserName() {
		return userName;
	}
	public static String getPassword() {
		return password;
	}
	
}
