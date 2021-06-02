package com.aspire.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aspire.BO.ProductBO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		
	
		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * Get parameters from user
		 */
		int imageid = Integer.parseInt(request.getParameter("id"));	
		System.out.println(imageid);
		String amount = request.getParameter("price");
		
		/**
		 * Database Connection
		 */

		UserBean loginbean = new UserBean();
		loginbean.setImageid(imageid);	
		loginbean.setPrice(amount);
		
			

		if (ProductBO.updateData(loginbean) == true) {
			System.out.println("Update successfully!");
			try {
				response.sendRedirect("update.jsp");
			} catch (IOException e) {
			
				e.printStackTrace();
			}
			 
		} else {
			System.out.println("Not updated successfully!");
		}

	}

		
		
	}


