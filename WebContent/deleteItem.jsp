<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home Page for Admin</title>
<link href="Style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script>
	function myFunction() {
		if (document.DeleteItem.id.value.length > 0)
			alert("Remove Item Successfully!");
		
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
	<br>
	<div class="Delete-box">
	<br>
	<br>
	<form name="DeleteItem" method="post" action="RemoveItem">
			Product Id: <br>
			<br> <input type="text" name="id" placeholder="Product Id"
				required> <br> <br><br>

			<button onclick="myFunction()">Submit</button>
			<br> <br>
		</form>
		
	</div>
</body>
</html>

