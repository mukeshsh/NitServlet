<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Security WebApp Login page::</title>
</head>
<body bgcolor="#cccccc">
	<blockquote>
		<h2>Please Enter Your userName and Password::</h2>
		<p>
		<form action="j_security_check" method="post">
			<table border="1">
				<tr>
					<td>Username:</td>
					<td><input type="text" name="j_username"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="j_password"></td>
				</tr>
				<tr>
					<td colspan=2 align="right"><input type=submit value="Submit"></td>
				</tr>
			</table>
		</form>
	</blockquote>
</body>
</html>