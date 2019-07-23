<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Desk</title>
</head>
<body>
<h3>All Bookings</h3>

	<div>
		<a href="login.jsp">Logout</a>
	
	</div>
	<div>
	<table border='1'>
		<thead>
			<tr>
				<td>Booking ID</td>
				<td>Room No.</td>
				<td>From </td>
				<td>To </td>
				<td>Customer Username </td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookings}" var="booking">
				<tr>
					<td>${booking.bookingid }</td>
					<td>${booking.roomno }</td>
					<td>${booking.fromDate }</td>
					<td>${booking.toDate }</td>
					<td>${booking.username }</td>
								
					<td>
						<form action="deletebooking/${booking.bookingid}" method="GET">
							<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>