<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Employee's Page</title>
</head>
<% 
if((request.getSession(false).getAttribute("Employee")== null) )
{
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%} %>
<body>
<center><h2>User's Home</h2></center>
Welcome <%=request.getAttribute("username") %>.
<br>
Your current role is <%=request.getAttribute("role") %>.
<div style="text-align: center"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
 
</body>
</html>