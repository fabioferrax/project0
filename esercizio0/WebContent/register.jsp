<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register user</title>
</head>
<body>
<h1>Register</h1>
	<form action="newUser" method="post">
	<h3>Username <input type="text" name="username"></h3>
	<h3>Password <input type="password" name="password"></h3>
	<input type="submit">
		
	</form>

</body>
</html>