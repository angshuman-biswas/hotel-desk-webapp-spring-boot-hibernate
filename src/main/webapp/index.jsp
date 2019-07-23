<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Desk</title>
</head>
<body>
<h3>HOTEL DESK - ROOM BOOKING SERVICE</h3>

	<div>
		<form action="/showallbookings" method="GET">
				<input type="submit" value="See all bookings">
		</form>
		<a href="login.jsp">Logout</a>
	
	</div>
	<div>
	<table border='1'>
		<thead>
			<tr>
				<td>Available Room No.</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${availablerooms}" var="room">
				<tr>
					<td>${room.roomno }</td>				
					<td>
						<form action="book/${room.roomno}" method="GET">
							<input type="submit" value="Book">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>