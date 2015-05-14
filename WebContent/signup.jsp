<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styl.css" />
</head>
<body>
<jsp:include page="nav.jsp" />
<center><h2><b>Sign Up Now...!</b></h2></center>
<form action="SignupServlet" method="post">
<center><div id="signup" ><br><h3>Username : <input type="text" name="username" value="${username}"></h3>
<h3><input type="submit" name="sub1" value="Check availability"  /></h3>
<div style="color: #A10202;">${errorMessageUnameNA}</div>
<div style="color: #006D18;">${errorMessageUnameA}</div>
<div style="color: #A10202;">${errorMessageUname}</div>
<h3>Firstname : <input type="text" name="firstname" value="${firstname}"/></h3>
<div style="color: #A10202;">${errorMessageFname}</div>
<h3>Lastname : <input type="text" name="lastname" value="${lastname}"/></h3>
<div style="color: #A10202;">${errorMessageLname}</div>
<h3>Password : <input type="password" name="password" value="${password}"/></h3>
<div style="color: #A10202;">${errorMessagePass}</div>
<h3>Confirm Password : <input type="password" name="cpassword" /></h3>
<div style="color: #A10202;">${errorMessageCPass}</div>
<div style="color: #A10202;">${errorMessagePassMatch}</div>
<input type="submit" name="sub2" value="Signup" /><br/>
<div style="color: #A10202;">${UnSuccessMessage}</div><br></div></center>
</form>
</body>
</html>