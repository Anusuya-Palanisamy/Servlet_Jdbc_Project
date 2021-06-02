package com.aspire.BO;

import java.util.ArrayList;

import com.aspire.DAO.AdminDAO;
import com.aspire.DAO.RegisterDAO;
import com.aspire.DAO.UserDAO;
import com.aspire.bean.UserBean;

public class ProductBO {
	/**
	 * 
	 * @param User
	 *            Process
	 * 
	 */
	public static UserBean LoginBO(UserBean loginBean) {
		return UserDAO.login(loginBean);

	}

	public static boolean RegisterBO(UserBean loginBean) {
		return RegisterDAO.register(loginBean);

	}

	/**
	 * 
	 * @param Admin
	 *            Process-Insert Image
	 * 
	 */
	public static boolean AdminDAO(UserBean loginBean) {
		return AdminDAO.insertImage(loginBean);

	}

	/**
	 * 
	 * @param Admin
	 *            Process-Retrieve Image
	 * 
	 */

	public ArrayList<UserBean> retrieveImage(UserBean loginBean) {
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();
		AdminDAO adminDAO = new AdminDAO();
		return AdminDAO.retrieveImage();
	}

	/**
	 * 
	 * @param Admin
	 *            Process-update Data
	 * 
	 */

	public static boolean updateData(UserBean loginBean) {

		return AdminDAO.updateData(loginBean);
	}

	/**
	 * 
	 * @param Admin
	 *            Process-Delete Data
	 * 
	 */

	public static boolean deleteData(int imageid) {

		return AdminDAO.deleteData(imageid);
	}

	/**
	 * 
	 * @param user
	 *            Process-User Profile
	 * @return
	 * 
	 */
	public static UserBean ProfileBO(String username) {
		return UserDAO.profile(username);
	}

	/**
	 * 
	 * @param user
	 *            Process-User Add Product
	 * 
	 */

	public static void addDetails(String username, int id) {
		System.out.println(username);
		System.out.println(id);
		UserDAO.addDetails(username, id);
	}

	/**
	 * 
	 * @param user
	 *            Process-User cartDetails
	 *
	 */

	public static ArrayList<UserBean> cartDetails(String username) {

		return UserDAO.cartDetails(username);
	}

	/**
	 * 
	 * @param User
	 *            Process-User Delete Item
	 * 
	 */
	public static boolean deleteItem(int imageid) {

		return UserDAO.deleteItem(imageid);
	}

	/**
	 * 
	 * @param Update
	 *            Password
	 * 
	 */
	public static boolean updatePassword(UserBean loginBean) {

		return UserDAO.updatePassword(loginBean);
	}
	/**
	 * 
	 * @param Search data
	 * 
	 */

	public ArrayList<UserBean> searchData(String productName) {
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();
		return UserDAO.searchData(productName);
	}


}
