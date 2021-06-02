<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Laptops</title>
<link href='Style.css' rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<form action="Login" method="post">
		<% String username=(String)session.getAttribute("username");
  if(username==null)
  {
	  request.getRequestDispatcher("index.jsp").forward(request,response);
	 // out.println("Gest");
  }
  else
  {
	  %>
	<p>  ${username }</p>
	  
	  <%
  }
%>
	</form>
	<h1 style="color: white">
		<b><i>Laptop List!!!<i /></b>
	</h1>
<br>
	<br>
	<img src="./images/logo.jpg" width="70px" height="50px" align="left">
<%@ include file="header1.jsp" %>
	
	<br>
	<br>
	</form>
	<br>
	<br>
	<form method="post" action="ProfileDetails">
	<button type="Submit" name="My Profile" >My Profile</button><br><br>
	</form>
	
	<form method="post" action="Admin">
		<input href="InsertImage.jsp" type="submit" name="Product View" value="Product View">

	</form>
	

</body>
</html>