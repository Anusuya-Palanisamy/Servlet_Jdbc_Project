package com.aspire.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.BO.ProductBO;
import com.aspire.DAO.UserDAO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			{
		// response.setContentType("text/html");
		// PrintWriter printWriter=response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		/**
		 * create object loginbean data
		 */
		UserBean loginbean = new UserBean();
		loginbean.setUserName(userName);
		loginbean.setPassword(password);
		/**
		 * Session
		 */
		HttpSession session = request.getSession(true);
		
		
	    loginbean=ProductBO.LoginBO(loginbean);
		System.out.println(loginbean.getUserName());
		System.out.println(loginbean.getPassword());
		
		if(loginbean.getUserName().equals("Invalid Data"))
		{
			try {
				System.out.println(loginbean.getUserName());
				response.sendRedirect("Login.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else
			{
			if((loginbean.getUserName().equals("anu@gmail.com")) && (loginbean.getPassword().equals("jesus")))
			
			{
				try {
					session.setAttribute("username", userName);
					response.sendRedirect("HomeAdmin.jsp");
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
		 else  {
			try {
				session.setAttribute("username", userName);
				response.sendRedirect("ProductPage.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
			}
			

	}

}
