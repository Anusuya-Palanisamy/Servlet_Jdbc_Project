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

<script type="text/javascript">
	function validatePass() {
		var msg;
		if (document.checkPass.password.value.length > 12) {
			msg = "very strong";
			if (msg == "very strong") {
				document.getElementById("mylocation").style.color = "lime";
			}
		} else if (document.checkPass.password.value.length > 5) {
			msg = "Strong";
			if (msg == "Strong") {
				document.getElementById("mylocation").style.color = "green";
			}
		} else {
			msg = "poor";
			if (msg == "poor") {
				document.getElementById("mylocation").style.color = "red";
			}
		}
		document.getElementById('mylocation').innerText = msg;
	}
	function validateConPass() {
		var msg;
		if (document.checkPass.conformPass.value.length > 12) {
			msg = "Very Strong";
			if (msg == "very strong") {
				document.getElementById("myPass").style.color = "lime";
			}
		} else if (document.checkPass.conformPass.value.length > 5) {
			msg = "Strong";
			if (msg == "Strong") {
				document.getElementById("myPass").style.color = "green";
			}
		} else {
			msg = "poor";
			if (msg == "poor") {
				document.getElementById("myPass").style.color = "red";
			}
		}
		document.getElementById('myPass').innerText = msg;
	}
	
	 function Validate() {
	        var password = document.getElementById("txtPassword").value;
	        var confirmPassword = document.getElementById("txtConfirmPassword").value;
	        if (password != confirmPassword) {
	            alert("Passwords do not match.");
	            return false;
	        }
	        return true;
	    }
	 
	
	
</script>
</head>
<body>

	<h1 style="color: white">
		<b><i>Update the Item from Admin</i><i /></b>
	</h1>
	<br>
	<br>
	<img src="./images/logo.jpg" width="70px" height="50px" align="left">
	<%@ include file="header1.jsp"%>
<br>
<br>
<br>
<form name="form" action="UpdatePassword" method="post"><br>
Email Id:<br><input type="email" size="32" name="username"
				placeholder="Enter email" autocomplete="on" id="myText" required><br>
			<br>  Password:<br> <input
				type="password" size="32" name="password"
				placeholder="Enter password" id="txtPassword" value="" onkeyup="validatePass()"><br>
			Strength:<span id="mylocation">no strength</span><br><br>
			 Conform Password:<br> <input type="password" size="32"
				name="conformPass" placeholder="Enter Conform password" value="" id="txtConfirmPassword"
				onkeyup="validateConPass()"><br> Strength:<span
				id="myPass">no strength</span><br>		
				<br>
			<button type="submit" value="Submit" onclick="return Validate()">Submit</button>
	</form>

	</div>
</body>
</html>

