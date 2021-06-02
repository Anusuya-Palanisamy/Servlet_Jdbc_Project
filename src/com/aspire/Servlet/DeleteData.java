package com.aspire.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aspire.BO.ProductBO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class delete
 */
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		
		/**
		 * Get parameters from user
		 */
		int imageid = Integer.parseInt(request.getParameter("id"));	
		System.out.println(imageid);
		
		
		
		/**
		 * Database Connection
		 */

		
		
		
		if (ProductBO.deleteData(imageid) == true) {
			System.out.println("Deleted successfully!");
			try {
				response.sendRedirect("delete.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Not Deleted successfully!");
		}

	}

		
	}


