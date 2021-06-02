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
<script>
	function Function() {
		
		if(document.Update.id.value.length>0)
		     alert("Are you sure to Buy this product");
		else
			alert("Please ,Fill the Details");
		
	}
</script>
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
	<br>
		<c:forEach items="${product}" var="list" >
	
	<table>
	<td>
			<tr>
			<h2>Product Id:${list.imageid}</h2>
				<img src="data:image/jpg;base64,${list.image}" width="400" height="300"/>
				<h2>Product Name: ${list.imageName }</h2>
				<h2>Price: ${list.price}</h2>
				<h2>Operating system: ${list.operatingSys}</h2> 
				<h2>RAM Size: ${list.ram}</h2>
			</tr>
			</td>
		
		
	</table>

	</c:forEach>
	<br>

</body>
</html>

