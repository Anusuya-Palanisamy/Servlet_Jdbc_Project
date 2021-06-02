package com.aspire.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aspire.BO.ProductBO;

/**
 * Servlet implementation class RemoveItem
 */
@WebServlet("/RemoveItem")
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		/**
		 * Get parameters from user
		 */
		int imageid = Integer.parseInt(request.getParameter("id"));	
		System.out.println(imageid);
			
		/**
		 * Database Connection
		 */
		
		if (ProductBO.deleteItem(imageid) == true) {
			System.out.println("Remove Item successfully!");
			try {
				response.sendRedirect("deleteItem.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("Not Removed successfully!");
			try {
				response.sendRedirect("deleteItem.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}

	}

	}


