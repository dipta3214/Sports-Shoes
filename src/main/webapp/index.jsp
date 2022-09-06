<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shoe</title>
</head>
<body>
	<h1>Welcome!</h1>
	<br>
	<a href="shoeAdd.jsp">Add a shoe</a>
	<br>
	<form action="get">

	<input type="submit" value="retrieve all shoes">
	
	</form>
	<br>
	<p>Get shoes by category: </p>
	<form action="getCategory">

	Category: <input type="text" placeholder="Enter your value" name="category">
	<input type="submit" value="category">
	
	</form>
</body>
</html>