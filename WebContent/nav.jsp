<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ServletContext sc = getServletContext();  
String path = sc.getContextPath(); %>  
<div id="nav" align="left"><a href="<%= path %>\index.jsp" >Home</a><br/>
<a href="<%= path %>\login.jsp" >Login</a><br/>
<a href="<%= path %>\signup.jsp" >Sign Up</a></div>
</body>
</html>