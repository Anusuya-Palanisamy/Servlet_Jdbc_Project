package com.aspire.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aspire.BO.ProductBO;
import com.aspire.DAO.AdminDAO;
import com.aspire.bean.UserBean;

/**
 * Servlet implementation class InsertImage
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Statement DBconnect = null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			{
		
		try {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
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
		String myloc = request.getParameter("image");
		String name = request.getParameter("name");
		String amount = request.getParameter("price");
		String  operatingSys= request.getParameter("Operating System");
		String  ram= request.getParameter("RAM Type");
		
		/**
		 * Database Connection
		 */

		UserBean loginbean = new UserBean();
		loginbean.setImageid(imageid);
		loginbean.setImage(myloc);
		loginbean.setImageName(name);
		loginbean.setPrice(amount);
		loginbean.setOperatingSys(operatingSys);
		loginbean.setRam(ram);
		

		if (ProductBO.AdminDAO(loginbean) == true) {
			System.out.println("insert successfully!");
			try {
				response.sendRedirect("HomeAdmin.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Not insert successfully!");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//int bookId = Integer.parseInt(request.getParameter("imageid"));
		ArrayList<UserBean> arrayList=new ArrayList<UserBean>();
		UserBean loginbean = new UserBean();
		arrayList=AdminDAO.retrieveImage();
		request.setAttribute("product", arrayList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("InsertImage.jsp");
        requestDispatcher.forward(request, response);    
		
	}
}
