<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginForm</title>
</head>
<body bgcolor="lightblue">

<center>
<h2>Login Form</h2>
	<form action="LoginController.html" method="POST">
		<table >
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
		</table>		

	</form>
</center>	

</body>
</html>