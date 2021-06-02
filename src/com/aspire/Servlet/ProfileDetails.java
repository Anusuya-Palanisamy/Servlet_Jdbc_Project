package com.aspire.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.BO.ProductBO;
import com.aspire.DAO.AdminDAO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class profile
 */
@WebServlet("/ProfileDetails")
public class ProfileDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		 String username=(String) session.getAttribute("username");
		 System.out.println(username);
		UserBean loginbean=new UserBean();
		loginbean=ProductBO.ProfileBO(username);
		request.setAttribute("product",loginbean);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
	        try {
				requestDispatcher.forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}    
	}

}
