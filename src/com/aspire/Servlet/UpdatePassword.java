package com.aspire.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aspire.BO.ProductBO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * Get parameters from user
		 */
		String username = request.getParameter("username");	
		System.out.println(username);
		String password = request.getParameter("password");
		String conformPass = request.getParameter("conformPass");
		
		/**
		 * Database Connection
		 */

		UserBean loginbean = new UserBean();
		loginbean.setUserName(username);	
		loginbean.setPassword(password);
		loginbean.setConformPass(conformPass);
		
			
		if (ProductBO.updatePassword(loginbean) == true) {
			System.out.println("Reset password successfully!");
			try {
				response.sendRedirect("Login.jsp");
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			 
		} else {
			System.out.println("Not Reseted successfully!");
		}

	}

		
	}


