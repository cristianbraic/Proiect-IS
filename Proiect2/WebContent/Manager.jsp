<%@page errorPage="errors.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Banking</title>
<style>
  body {background-color:lightgrey}
  h1   {color:blue}
  p    {color:green}
</style>
</head>
<body>
<%if(session.getAttribute("valid")==null){
	response.sendRedirect("errors.jsp");
	}
else{ 
	if(session.getAttribute("msg")!="null")
{
	out.println("<font color=green>"+session.getAttribute("msg")+"</font>");
	session.setAttribute("msg","null");
}%>
<center><h2><font face="verdana" color="6698ff">Welcome Manager</font></h2></center><hr width="1000" size="5"><br>
<table width="1000">
	<tr>
		<td width="900"><a href="Manager.jsp">Home</a></td>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<center>
<table>
	<tr>
		<td><a  href="CreateNewAccount.jsp">Create A new Customer</a></td>
	</tr>
	<tr>
		<td><a href="AddAccountCustomer.jsp">Add Account to existing Customer</a></td>
	</tr>
	<tr>
		<td><a href="ChangePassword.jsp">Change Your Password</a></td>
	</tr>
	<tr>
		<td><a href="ShowAllAccno">See The Account no of all customers</a></td>
	</tr>
	<tr>
		<td><a href="AllDetails">See the Account Details of all customer</a></td>
	</tr>
</table>
</center>
<%} %>


</body>
</html>