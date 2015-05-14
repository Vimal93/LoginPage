<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styl.css" />
</head>
<body>
<% if(session.getAttribute("username")==null) 
{
	request.setAttribute("loginfirst", "You need to Login first");
    request.getRequestDispatcher("/login.jsp").forward(request, response);
} %>
<jsp:include page="logout.jsp" />
<jsp:include page="nav.jsp" />
<div id="welcome"><center>
<div style="color: #004400;"><h3>${Alreadylogged}</h3></div>
<div style="color: #004400;"><h3>${SuccessMsg}</h3></div>
<h1>Welcome ${firstname} ${lastname}</h1><br/><br/></center></div>
</body>
</html>