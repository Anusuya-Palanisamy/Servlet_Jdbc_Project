<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home Page for Admin</title>
<link href="Style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script>
	function myFunction() {
		if (document.Delete.id.value.length > 0)
			alert("Deleted Successfully!");
		else
			alert("Please ,Fill the Details");

	}
</script>
</head>
<body>
	<form action="Login" method="post">
		<%
			String username = (String) session.getAttribute("username");
			if (username == null) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				out.println(username);
			}
		%>
	</form>
	<h1 style="color: white">
		<b><i>Delete the Item from Admin</i><i /></b>
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

	<div class="Delete-box">
		<form name="Delete" method="post" action="DeleteData">
			Product Id: <br>
			<br> <input type="text" name="id" placeholder="Product Id"
				required> <br> <br>

			<button onclick="myFunction()">Submit</button>
			<br> <br>
		</form>
		<form method="post" action="Admin">
			<input href="InsertImage.jsp" type="submit" name="View" value="View">

		</form>

	</div>
</body>
</html>

