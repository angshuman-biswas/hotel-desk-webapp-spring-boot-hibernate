<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<h1>HOTEL DESK APPLICATION</h1>
<%
session=request.getSession();
String user=(String)session.getAttribute("user");
if(user==null)
{
	out.println("<form action='alogin' method='post'>");
	out.println("<table>");
	out.println("<tr><td>User name:</td><td> <input type='text' name='ausername'></td></tr>");
	out.println("<tr><td>Password: </td><td> <input type='password' name='apassword'></td></tr>");
	out.println("</table>");
	out.println("<tr><td><input type='submit'></td></tr>");
	out.println("</form>");	
}
else
{
	out.println(user);
	out.println("<a href='login.jsp'>Login Page</a>");
}

%>
<br>
<br>
</body>
</html>