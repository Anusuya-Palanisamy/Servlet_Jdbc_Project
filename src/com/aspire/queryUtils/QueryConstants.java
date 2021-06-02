package com.aspire.queryUtils;

public class QueryConstants {
	private final String loginquery = "select * from customerdetails";
	private final String registerQuery = "insert into customerdetails values(?,?,?,?,?,?,?,?,?,?)";
	private static String insertImage = "insert into adminimage values(?,?,?,?,?,?)";
	private static String retrieveImage = "select * from adminimage";
	private static String updateData = "update adminimage set price=? where id=?";
	private static String deleteData = "delete from adminimage where id=?";
	private String profileData = "select * from customerdetails where userName=?";
	private String addProduct = "insert into cart(userName,productId)values(?,?)";
	private String viewProduct = "select * from adminimage inner join cart on adminimage.id=cart.productId where cart.userName=?";
	private static String removeItem = "delete from cart where productId=?";
	private static String resetPassword = "update customerdetails set password=?,conformPass=? where userName=?";
	private static String searchData = "select * from adminimage where productName=?";

	/**
	 * 
	 * @Login and Register Process
	 */

	public String getLoginquery() {
		return loginquery;
	}

	public String getRegisterQuery() {
		return registerQuery;
	}

	/**
	 * 
	 * @Admin Process
	 */

	public static String getInsertImage() {
		return insertImage;
	}

	public static String getRetrieveImage() {
		return retrieveImage;
	}

	public static String getUpdateData() {
		return updateData;
	}

	public static String getDeleteData() {
		return deleteData;
	}

	/**
	 * 
	 * @User Details
	 */
	public String getProfileData() {
		return profileData;
	}

	public String getAddProduct() {
		return addProduct;
	}

	public String getViewProduct() {
		return viewProduct;
	}

	public static String getRemoveItem() {
		return removeItem;
	}

	/**
	 * 
	 * @return Forgot Password
	 */
	public static String getResetPassword() {
		return resetPassword;
	}

	/**
	 * 
	 * @return search Details
	 */
	public static String getSearchData() {
		return searchData;
	}

}
