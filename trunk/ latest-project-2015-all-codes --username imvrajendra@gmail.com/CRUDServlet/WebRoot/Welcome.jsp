<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>Welcome.jsp</title>	
  </head>
  
  <body>
    Hello ${username},Welcome to the website ...!
    <br>
    <form action="welcome" method="post">
    	<%
    		String loadText = (String)request.getAttribute("LOAD_TEXT");
    	%>
    	<input type="text" id="LoadTextArea" name="LoadTextArea" value="<%=loadText %>" style="height: 60px; width: 400px;"/>
    	<br>
    	<input type="submit" name="actionSubmit" value="update"/>
    	<input type="submit" name="actionSubmit" value="delete"/>
    </form>
    
  </body>
</html>
