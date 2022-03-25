<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<script> 
function validate()
{ 

     var username = document.form.username.value; 
     var password = document.form.password.value;
     var role = document.form.role.value;

     
     if (username==null || username=="") { 
     	alert("Username can't be blank"); 
     return false; 
     } else if (password==null || password=="") {
    	 alert("Password can't be blank");
    	 return false;
     }
 } 
</script> 
</head>
<body>
<center><h2>Register a new Employee</h2></center>
    <form name="form" action="<%=request.getContextPath()%>/RegisterServlet" method="post" onsubmit="return validate()">
        <table align="center">
         <tr>
         <td>Username</td>
         <td><input type="text" name="username" /></td>
         </tr>
         <tr>
         <td>Password</td>
         <td><input type="password" name="password" /></td>
         </tr>
         <tr>
         <td>Role
         <td><select name="role">
    	 <option value="Employee">Employee</option>
    	 <option value="Manager">Manager</option>
  		 </select>
  		 </td>
		<td>
         <tr>
         <td></td>

         <td><input type="submit" value="Register"></input></td>
		 <td><input type="button" value="Back" onclick="window.location='Login.jsp'"></td>
         </tr>
<tr><td></td>
<td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td></tr>
        </table>
    </form>
</body>
</html>