<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Image Page</title>
<link href='Style.css' rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<h1 style="color: white">
		<b><i>Product Page</i></b>
		<br>
	<br>
	<img src="./images/logo.jpg" width="70px" height="50px" align="left">
	</h1>

	<%@ include file="header1.jsp" %>

	<br>
	<br>
	<br>
	<table>
	<td>
	<tr>
	<h3>First Name:  ${product.firstName }</h3>
	<h3>Last Name:  ${product.lastName }</h3>
	<h3>User Name:  ${product.userName }</h3>
	<h3>Password:  ${product.password }</h3>
	<h3>Mobile Number:  ${product.mobile }</h3>
	<h3>Street:  ${product.street }</h3>
	<h3>Post:  ${product.post}</h3>
	<h3>City:  ${product.city}</h3>
	<h3>Pin code:  ${product.pincode}</h3>
    
    </tr>
    </td>
   
    </table>
     
	
</body>
</html>