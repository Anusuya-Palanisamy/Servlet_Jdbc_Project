<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<title>List of Laptops</title>
<link href='Style.css' rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<h1 style="color: white">
		<b><i>Welcome to Laptop Shopping!!!</i></b>
	</h1>
	<br>
	<br>
	<img src="./images/logo.jpg" width="70px" height="50px" align="left">
	<%@ include file="header1.jsp"%>

	<br>
	<br>
	<br>
	
		<table>
			<tr>
				<td>

					<div class="card">
						<img src="./images/images (37).jpg" style="width: 20% hight:100%">
						<h2>Hp 15q APU Dual Core</h2>
						<p class="price">$30,000</p>
						<p>AMD APU Dual Core A9 Processor</p>
						<p>4 GB DDR4 RAM</p>
						<p>64 bit Windows 10 Operating System</p>
						<p>1 TB HDD</p>
						<p>39.62 cm (15.6 inch) Display</p>
						<p>1 Year Onsite Warranty</p>

						<p>
							
	<ul><li><a href="Login.jsp" onclick="return confirm('Please Login Your Id')" name="cart">Add to Cart</a></li></ul>
					
				</td>
				
				<td>
					
						<img src="./images/images (32).jpg" style="width: 20% hight:100%">
						<h2>Dell 3 Dual Core</h2>
						<p class="price">$45,000</p>
						<p>AMD Ryzen 3 Dual Core Processor</p>
						<p>4 GB DDR4 RAM</p>
						<p>64 bit Windows 10 Operating System</p>
						<p>500 GB HDD</p>
						<p>1 TB HDD</p>
						<p>39.62 cm (15.6 inch) Display</p>
						<p>1 Year Limited Hardware Warranty</p>
						<p>
							<ul><li><a href="Login.jsp" onclick="return confirm('Please Login Your Id')" name="cart">Add to Cart</a></li></ul>
						
				</td>
				
				<td>
					
						<img src="./images/download (1).jpg" style="width: 20% hight:90%">
						<h2>Acer 3 Pentium Gold</h2>
						<p class="price">$45,000</p>
						<p>Intel Pentium Gold Processor</p>
						<p>4 GB DDR4 RAM</p>
						<p>64 bit Windows 10 Operating System</p>
						<p>500 GB HDD</p>
						<p>39.62 cm (15.6 inch) Display</p>
						<p>1 Year International Travelers Warranty</p>
						<p>
			<ul><li><a href="Login.jsp" onclick="return confirm('Please Login Your Id')" name="cart">Add to Cart</a></li></ul>			
					
				</td>
				</tr>
				</div>
		</table>
</body>
</html>