package com.aspire.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aspire.BO.ProductBO;
import com.aspire.DAO.AdminDAO;
import com.aspire.DAO.UserDAO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class SearchData
 */
@WebServlet("/SearchData")
public class SearchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		ArrayList<UserBean> arrayList=new ArrayList<UserBean>();
		 String productName=(String) request.getParameter("search");
		 System.out.println(productName);
		UserBean loginbean = new UserBean();
		arrayList=UserDAO.searchData(productName);
		request.setAttribute("product", arrayList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("search.jsp");
        try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}    
		
	}
}
