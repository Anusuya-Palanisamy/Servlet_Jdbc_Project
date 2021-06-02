<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Cart</title>
<link href="Style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<form action="Login" method="post">
			<% String username=(String)session.getAttribute("username");
  if(username==null)
  {
	  request.getRequestDispatcher("index.jsp").forward(request,response);
  }
  else
  {
	  out.println(username);
  }
%>
	</form>
	<h1 style="color: white">
		<b><i>Welcome to My Cart!!!<i /></b>
	</h1>
<br>
	<br>
	<img src="./images/logo.jpg" width="70px" height="50px" align="left">
	<%@ include file="header1.jsp" %>
	
	
	<br>
	<br>
	<br>
	
	<table>
	<td>
	<tr>
	<form method="post" action="Admin">
		<input href="InsertImage.jsp" type="submit" name="Continue to Shopping" value="Continue to Shopping"></tr>
		</form>
    <br><br>
    	<form method="get" action="Cart">
		<input  type="submit" name="Viewcart" value="Viewcart">
	</form>
	  <br><br>
		
		<a href="deleteItem.jsp" name="Remove Item" value="Remove Item">Remove Item</a>
	
	  <br><br>
	  <div class="Product">
	 <a href="index.jsp" onclick="return confirm('Thank you for Shopping! Your product will be delivered with in 5 to 7 days')">Buy Now</a>
			
			</tr>
				</td>
	</table>
	</div>

</body>
</html>

