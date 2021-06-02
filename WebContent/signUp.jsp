<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
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
		<b><i>Welcome to Register Page!!!<i /></b>
	</h1>
<br>
	<br>
	<img src="./images/logo.jpg" width="70px" height="50px" align="left">
	<%@ include file="header.html" %>
	
	<br>
	<br>
	<div class="SignUp-box">
		<form  name="checkPass" action="Register" method="post">
			
			<label>First Name:</label><br> <input type="text" maxlength="20"
				size="32" name="firstName" placeholder="Enter First Name" required><br>

			<label>Last Name:</label><br> <input type="text" maxlength="20"
				size="32" name="lastName" placeholder="Enter Last Name" required><br>

			<label for="phone">Mobile Number:</label><br> <input type="tel"
				maxlength="13" size="32" name="mobile"
				placeholder="Enter Mobile Number" pattern="[6-9]{1}[0-9]{9}" required><br>

			<label for="email">Email:</label><br> <input type="email"
				size="32" name="username" placeholder="Enter email"
				autocomplete="on" required><br> Password:<br> <input
				type="password" size="32" name="password"
				placeholder="Enter password" id="txtPassword" value="" onkeyup="validatePass()"><br>
			Strength:<span id="mylocation">no strength</span><br> Conform
			Password:<br> <input type="password" size="32"
				name="conformPass" placeholder="Enter Conform password" value="" id="txtConfirmPassword"
				onkeyup="validateConPass()"><br> Strength:<span
				id="myPass">no strength</span><br> <label>Street:</label><br>
			<input type="text" size="32" name="street" placeholder="Enter Street"
				required><br> 
				
			<label>Post:</label><br> <input
				type="text" size="32" name="post" placeholder="Enter Post" required><br>

			<label>City:</label><br> <input type="text" size="32"
				name="city" placeholder="Enter City" list="citylist" required><br>

			<datalist id="citylist">
			<option>New Delhi</option>
			<option>Chennai</option>
			<option>Kolkata</option>
			<option>Mumbai</option>
			<option>Coimbatore</option>
			<option>Tirupur</option>
			<option>Bengaluru</option>
			</datalist>

			<label>Pincode:</label><br> <input type="text" size="32"
				name="pincode" placeholder="Enter Pincode" required><br>
			<br>

			<button type="submit" value="Submit" onclick="return Validate()">Submit</button>
			
			<br>
			<br>
		</form>
	</div>

</body>
</html>
