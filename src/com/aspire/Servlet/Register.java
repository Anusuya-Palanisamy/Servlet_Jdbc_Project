package com.aspire.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aspire.BO.ProductBO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			{
		
		try {
			doGet(request, response);
		} catch (ServletException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String mobile = request.getParameter("mobile");
		String conformPass = request.getParameter("conformPass");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String post = request.getParameter("post");
		String pincode = request.getParameter("pincode");
				
		UserBean loginbean = new UserBean();
		
		loginbean.setUserName(userName);
		loginbean.setPassword(password);
		loginbean.setFirstName(firstName);
		loginbean.setLastName(lastName);
		loginbean.setMobile(mobile);
		loginbean.setConformPass(conformPass);
		loginbean.setStreet(street);
		loginbean.setCity(city);
		loginbean.setPost(post);
		loginbean.setPincode(pincode);

		if (ProductBO.RegisterBO(loginbean)) {
			try {
				response.sendRedirect("Login.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}

		}

	}

}
