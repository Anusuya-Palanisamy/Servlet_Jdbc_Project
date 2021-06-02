package com.aspire.Servlet;

import java.io.IOException;
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
 * Servlet implementation class cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			
		
	//	int pid=Integer.parseInt(request.getParameter("cart"));
		HttpSession session = request.getSession();
		ArrayList<UserBean> arrayList = new ArrayList<UserBean>();
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		
		arrayList = UserDAO.cartDetails(username);
		System.out.println(arrayList);
		
		request.setAttribute("product", arrayList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewCart.jsp");
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			HttpSession session = request.getSession(true);
			String str=(String) (session.getAttribute("username"));
			//System.out.println(str);
			ProductBO.addDetails(str,
					Integer.parseInt(request.getParameter("cart")));
			response.sendRedirect("My cart.jsp");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
