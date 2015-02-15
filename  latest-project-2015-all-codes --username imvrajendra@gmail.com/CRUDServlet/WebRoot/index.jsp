<i><%@page language="java" import="java.util.*"
		pageEncoding="ISO-8859-1"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<form action="Login" method="post">
		<center>
			<table style="border: 1px;">
				<tr>
					<td colspan="2" style="text-align: center;"><span
						style="color: red;"> <c:if test="${not empty errorMessage}">
								<c:out value="${errorMessage}" />
							</c:if>
					</span></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><h1>Login for
							Application</h1></td>
				</tr>
				<tr>
					<td>User Name :</td>
					<td><input type="text" name="username" value="game"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" value="game"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit"></td>
				</tr>
			</table>
		</center>
	</form>
</body>
	</html> </i>