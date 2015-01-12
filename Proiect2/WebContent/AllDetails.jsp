<%@page import="java.util.ArrayList"%>
<%@page import="beans.AccountDetail"%>
<%@page import="java.util.List"%>
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
	response.sendRedirect("errors.jsp");}
	else {%>
<%List<AccountDetail> actdtls=(List<AccountDetail>)session.getAttribute("alldetails");
%>
<center><h2><font face="verdana" color="6698ff">Welcome Manager</font></h2></center><hr width="1000" size="5"><br>
<table width="1000">
	<tr>
		<td width="900"><a href="Manager.jsp">Home</a></td>
	
		<td width="100"><a href="Logout">Logout</a></td>
</table>
<br>
<center><table border="2">
	<tr>
		<th width="300" align="left">Customer Name</th>
		<th  width="300" align="left">Customer Account no</th>
		<th width="300" align="left">Customer balance</th>
		<th  width="300" align="left">Customer Gender</th>
		<th  width="300" align="left">Customer Address</th>
		<th  width="300" align="left">Customer Status</th>
		<th width="300" align="left">Customer Emailid</th>
		<th width="300" align="left">Customer Phoneno</th>
	</tr>
	<%for(AccountDetail a:actdtls) { %>
	<tr>
		<% out.println("<td width=300 align=left>"+a.getUsername()+"</td>");%>
		<% out.println("<td width=300 align=left>"+a.getAccno()+"</td>");%>
		<% out.println("<td width=300 align=left>"+a.getAmount()+"</td>");%>
		<% out.println("<td width=300 align=left>"+a.getGender()+"</td>");%>
		<% out.println("<td width=300 align=left>"+a.getAddress()+"</td>");%>
		<% out.println("<td width=300 align=left>"+a.getStatus()+"</td>");%>
		<% out.println("<td width=300 align=left>"+a.getEmailid()+"</td>");%>
		<% out.println("<td width=300 align=left>"+a.getPhoneno()+"</td>");%>
	</tr>
	<%} %>
</table>
</center>
<center><a href="Manager.jsp">Back</a></center>
<%} %>
</body>
</html>