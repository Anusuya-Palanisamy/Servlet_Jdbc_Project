package com.aspire.DAO;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import javax.servlet.ServletOutputStream;

import com.Connect.Connect;
import com.aspire.bean.UserBean;
import com.aspire.queryUtils.QueryConstants;

public class AdminDAO {
	static Connection connnection = Connect.getConnection();
/**
 * 
 * @param Insert Image
 * 
 */
	public static boolean insertImage(UserBean loginbean) {

		QueryConstants queryConstants = new QueryConstants();
		int resultSet;

		/**
		 * Get parameters from user
		 */
		
		int imageid = loginbean.getImageid();
		String name = loginbean.getImageName();
		String amount = loginbean.getPrice();
		String myloc = loginbean.getImage();
		String ram = loginbean.getRam();
		String operatingSys = loginbean.getOperatingSys();

		File image = new File(myloc);
		try {
			
			File image1 = new File(myloc);
			PreparedStatement statement = connnection.prepareStatement(QueryConstants.getInsertImage());
			statement.setInt(1, imageid);
			statement.setString(3, name);
			statement.setString(4, amount);
			statement.setString(5, operatingSys);
			statement.setString(6, ram);
			FileInputStream fileInputStream = new FileInputStream(image);
			statement.setBinaryStream(2, (InputStream) fileInputStream, (int) (image.length()));

			int count = statement.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return false;
	}
	
/**
 * 
 * @param Retrieve Image
 */
	public static ArrayList<UserBean> retrieveImage() {
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();

		try {
			PreparedStatement statement = null;
			
			statement = connnection.prepareStatement(QueryConstants.getRetrieveImage());

			ResultSet result = statement.executeQuery();
			while (result.next()) {
				UserBean loginbean = new UserBean();
				int id=result.getInt(1);
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
 * @param Update the data
 */
	public static boolean updateData(UserBean loginbean) {

		QueryConstants queryConstants = new QueryConstants();

		int resultSet;

		/**
		 * Get parameters from user
		 */
		int imageid = loginbean.getImageid();
		System.out.println(imageid);
		String amount = loginbean.getPrice();
		System.out.println(amount);
			
		try {
				
			PreparedStatement statement = connnection
					.prepareStatement(QueryConstants.getUpdateData());
			statement.setInt(2, imageid);
			statement.setString(1, amount);	
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

	/**
	 * 
	 * @param Delete data
	 * 
	 */

	public static boolean deleteData(int imageid) {

		QueryConstants queryConstants = new QueryConstants();

		int resultSet;

		/**
		 * Get parameters from user
		 */
		
		System.out.println(imageid);
		
		
			
		try {
			
			PreparedStatement statement = connnection
					.prepareStatement(QueryConstants.getDeleteData());
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


}
