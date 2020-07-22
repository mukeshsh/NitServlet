<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<%
out.println("<center><b>The User Name is::"+request.getRemoteUser()+"</center></b>");
 %>
 <center><b><h1 style=color:red>login Successfully.......welcome to homepage</b></center>
<p><b><a href="login.jsp">Loginpage</a></b>
</body>
</html>