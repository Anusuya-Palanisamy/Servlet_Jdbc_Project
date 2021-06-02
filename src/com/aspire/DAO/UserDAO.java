package com.aspire.DAO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import com.Connect.Connect;
import com.aspire.Servlet.Login;
import com.aspire.bean.UserBean;
import com.aspire.queryUtils.QueryConstants;

public class UserDAO {
	static String userNameDB;
	static String passwordDB;
	static Connection connnection = Connect.getConnection();

	public static UserBean login(UserBean loginbean) {
		QueryConstants queryConstants = new QueryConstants();

		Statement statement = null;
		ResultSet resultSet = null;

		String userName = loginbean.getUserName();
		String password = loginbean.getPassword();

		try {

			statement = connnection.createStatement();
			/**
			 * Login Statement
			 */
			resultSet = statement.executeQuery(queryConstants.getLoginquery());
			while (resultSet.next()) {

				userNameDB = resultSet.getString("userName");
				passwordDB = resultSet.getString("password");

				if (userName.equals(userNameDB) && password.equals(passwordDB)) {
					if (userName.equals("anu@gmail.com") && (password.equals("jesus"))) {

						return loginbean;
					}

					else {

						return loginbean;
					}
				}

			}

			loginbean.setUserName("Invalid Data");
		} catch (

		SQLException exception)

		{
			exception.printStackTrace();
		}
		return loginbean;

	}

	/**
	 * 
	 * @param Add
	 *            to cart Details
	 * @return
	 * 
	 */

	public static void addDetails(String username, int id) {

		try {

			PreparedStatement statement = null;
			QueryConstants queryConstants = new QueryConstants();
			statement = connnection.prepareStatement(queryConstants.getAddProduct());
			System.out.println(username);
			statement.setString(1, username);
			statement.setInt(2, id);
			statement.executeUpdate();
		}

		catch (SQLException ex) {
			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * @param Display
	 *            the Cart Details
	 */
	public static ArrayList<UserBean> cartDetails(String username) {
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();
		QueryConstants queryConstants = new QueryConstants();
		try {
			PreparedStatement statement = null;
			statement = connnection.prepareStatement(queryConstants.getViewProduct());
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserBean loginbean = new UserBean();
				int id = result.getInt(1);
				Blob image = result.getBlob(2);
				String name = result.getString(3);
				System.out.println(name);
				String price = result.getString(4);

				String operatingSys = result.getString(5);
				String ram = result.getString(6);
				System.out.println(ram);

				InputStream inputStream = image.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();
				loginbean.setImageid(id);
				loginbean.setImageName(name);
				loginbean.setPrice(price);
				loginbean.setImage(base64Image);
				loginbean.setRam(ram);
				loginbean.setOperatingSys(operatingSys);
				arrayList.add(loginbean);

			}

		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
			try {
				throw ex;
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return arrayList;
	}

	public static boolean deleteItem(int imageid) {
		QueryConstants queryConstants = new QueryConstants();
		int resultSet;

		/**
		 * Get parameters from user
		 */

		System.out.println(imageid);
		try {

			PreparedStatement statement = connnection.prepareStatement(QueryConstants.getRemoveItem());
			statement.setInt(1, imageid);

			int count = statement.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return false;
	}

	public static UserBean profile(String username) {
		QueryConstants queryConstants = new QueryConstants();
		UserBean loginbean = new UserBean();
		System.out.println(username);
		try {

			PreparedStatement preparedstatement = connnection.prepareStatement(queryConstants.getProfileData());
			preparedstatement.setString(1, username);
			ResultSet result = preparedstatement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString(1));
				loginbean.setFirstName(result.getString(1));
				loginbean.setLastName(result.getString(2));
				loginbean.setUserName(result.getString(3));
				loginbean.setPassword(result.getString(4));
				loginbean.setMobile(result.getString(5));
				loginbean.setStreet(result.getString(7));
				loginbean.setCity(result.getString(8));
				loginbean.setPost(result.getString(9));
				loginbean.setPincode(result.getString(10));
				// System.out.println(loginbean);

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			try {
				throw ex;
			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return loginbean;
	}

	/**
	 * 
	 * @param Update
	 *            Password
	 */
	public static boolean updatePassword(UserBean loginbean) {

		QueryConstants queryConstants = new QueryConstants();

		int resultSet;

		/**
		 * Get parameters from user
		 */
		String username = loginbean.getUserName();
		System.out.println(username);
		String password = loginbean.getPassword();
		System.out.println(password);
		String conFormPass = loginbean.getConformPass();
		System.out.println(conFormPass);

		try {

			PreparedStatement statement = connnection.prepareStatement(QueryConstants.getResetPassword());

			statement.setString(1, password);
			statement.setString(2, conFormPass);
			statement.setString(3, username);
			int count = statement.executeUpdate();
			System.out.println(count);
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return false;
	}


	/**
	 * 
	 * @param Retrieve
	 *            Image
	 */
	public static ArrayList<UserBean> retrieveImage(String username) {
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();

		try {
			PreparedStatement statement = null;

			statement = connnection.prepareStatement(QueryConstants.getRetrieveImage());
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserBean loginbean = new UserBean();
				int id = result.getInt(1);
				Blob image = result.getBlob(2);
				String name = result.getString(3);
				String price = result.getString(4);
				String operatingSys = result.getString(5);
				String ram = result.getString(6);

				InputStream inputStream = image.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();
				loginbean.setImageid(id);
				loginbean.setImageName(name);
				loginbean.setPrice(price);
				loginbean.setImage(base64Image);
				loginbean.setRam(ram);
				loginbean.setOperatingSys(operatingSys);
				arrayList.add(loginbean);

			}

		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
			try {
				throw ex;
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return arrayList;
	}

	/**
	 * 
	 * @param Search
	 *            Data
	 */
	public static ArrayList<UserBean> searchData(String userProduct) {
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();

		try {
			PreparedStatement statement = null;
			
			statement = connnection.prepareStatement(QueryConstants.getSearchData());
			statement.setString(1, userProduct);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserBean loginbean = new UserBean();
				int id = result.getInt(1);
				Blob image = result.getBlob(2);
				String name = result.getString(3);
				String price = result.getString(4);
				String operatingSys = result.getString(5);
				String ram = result.getString(6);
                System.out.println(ram);
				InputStream inputStream = image.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();
				loginbean.setImageid(id);
				loginbean.setImageName(name);
				loginbean.setPrice(price);
				loginbean.setImage(base64Image);
				loginbean.setRam(ram);
				loginbean.setOperatingSys(operatingSys);
				arrayList.add(loginbean);

			}

		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
			try {
				throw ex;
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return arrayList;
	}
}
