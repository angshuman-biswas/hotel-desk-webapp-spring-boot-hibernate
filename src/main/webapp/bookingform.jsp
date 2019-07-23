<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Room ${roomno} </title>
</head>
<body>
	<form action="/confirmed" method="POST">
		<input type="hidden" name="roomno" value="${roomno}">
		<div class="form-div">
			<label for="username">Unique Username : </label>
			<input type="text" name="username" required>
		</div>
		<div class="form-div">
			<label for="fromdate">FROM (yyyymmdd) : </label>
			<input type="text" name="fromdate" required>
		</div>
		<div class="form-div">
			<label for="todate">FROM (yyyymmdd) : </label>
			<input type="text" name="todate" required>
		</div>
		
		<div class="form-div">
			<input type="submit" value="Confirm" required>
		</div>
	</form>
</body>
</html>