<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signin</title>
<link href="Style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-

awesome.min.css">
<script type="text/javascript">
	function validateform() {
		var username = document.form.username.value;
		var password = document.form.password.value;

		if (username == null || username == "") {
			alert("Name can't be blank")
		} else if (password.length == 0) {
			alert("Please Enter your Password");
			header("Location:Login.jsp")
		}

	}
	
</script>
</head>
<body>

	<h1 style="color: white">
		<b><i>Welcome to Login Page!!!<i /></b>
	</h1>
<br>
	<br>
	<img src="./images/logo.jpg" width="70px" height="50px" align="left">
	<%@ include file="header1.jsp" %>

	<br>
	<br>
	<div class="login-box">

		
		<form name="form" action="Login" method="post">
			Email Id:<br>
			<br>
			<input type="email" size="32" name="username"
				placeholder="Enter email" autocomplete="on" id="myText" required><br>
			<br> Password:<br>
			<br> <input type="password" size="32" name="password"
				placeholder="Enter password" id="Text" required><br>
			<br>
			<button onclick="validateform()" name="sumbit">Submit</button>
			&nbsp &nbsp &nbsp &nbsp&nbsp   
			<a class="fa fa-registered" href="signUp.jsp">SignUp</a><br><br>	
	&nbsp &nbsp &nbsp&nbsp &nbsp<a href="ResetPassword.jsp">forgot password</a>
	</form>
		</div>
</body>
</html>

