<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Restricted Manager Page</title>
</head>

<% 
if((request.getSession(false).getAttribute("Manager")== null) )
{
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%} %>
<body>
<center><h2>Admin's Home</h2></center>
 
Welcome <%=request.getAttribute("username") %>,
<br>
Your current role is <%=request.getAttribute("role") %>.
<br>
You are in the restricted Manager's page.
<div style="text-align: center"><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></div>
<center>
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/DXC_Technology_logo_%282021%29.svg/1200px-DXC_Technology_logo_%282021%29.svg.png" alt="DXC Logo" width="1280" height="720">
</center>
</body>
</html>