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
	<c:forEach  items="${product}" var="list" >
	<form action="Cart" method="post">
	<table>
	<td>
	<input type="hidden" name="cart" value="${list.imageid}">
	<tr> <img src="data:image/jpg;base64,${list.image}" width="500" height="300"/>
    <h3>Product Name: ${list.imageName }</h3>
    <h3>Price: ${ list.price} </h3>
    <h3>Operating System:${list.operatingSys} </h3>
    <h3>RAM Type: ${list.ram}</h3>  
		<input type="submit" name="View" value="Add to cart">


    
    </tr>
    </td>
   
    </table>
	</form>
     </c:forEach>
     
</body>
</html>