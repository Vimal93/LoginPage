<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styl.css" />
</head>
<body>
<jsp:include page="nav.jsp" />
<form action="LoginServlet" method="post" id="login" >
<center><div id="lp"><br><div style="color: #A10202;">${errorMessage}${errorMessageUname}${errorMessagePword}${errorMsg}${loginfirst}</div>
<div style="color: #006D18;">${logoutMsg}${SuccessMessage}${alreadyamember}</div><br>
<h3>Please provide your Login details</h3>
<h3>Username:<input type="text" name="username" /><br><br>
Password:<input type="password" name="password" /><br><br>
<input type="submit" value="Submit"/></h3><br></div></center></form>
</body>
</html>