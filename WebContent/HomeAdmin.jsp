<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home Page for Admin</title>
<link href="Style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script>
	function myFunction() {
		if(document.admin.name.value.length>0)
		alert("Inserted Successfully!");
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
	<h1 style="color: white">
		<b><i>To Add the Item from Admin</i><i /></b>
	</h1>
	<br>
	<br>
	<img src="./images/logo.jpg" width="70px" height="50px" align="left">
	<%@ include file="header1.jsp"%>
<br>
<br>
<br>
<ul><li><a href="HomeAdmin.jsp">Insert</a></li></ul>
<ul><li><a href="update.jsp">Update</a></li></ul>
<ul><li><a href="delete.jsp">Delete</a></li></ul>

	<br>
	<br>
	
	<div class="HomeAdmin-box">
	<form name="admin" method="get" action="Admin"><br>
       Id:     <input type="text" name="id" placeholder="Id" required><br>
       <br> Image Name: <input type="file" name="image" placeholder="Image" required><br>
		 <br>ProductName: <input type="text" name="name" placeholder="ProductName" required><br>
		<br> Price:   <input type="text" name="price" placeholder="Price" required><br>
		 <br>Operating System: <input type="text" name="Operating System" placeholder="Operating System" required><br>
		 <br>RAM Type:  <input type="text" name="RAM Type" placeholder="RAM Type" required><br>
		<br>
		<button  onclick="myFunction()">Submit</button>
<br>
<br>
	</form>
	<form method="post" action="Admin">
		<input type="submit" name="View" value="View">
	</form>

	</div>
</body>
</html>

