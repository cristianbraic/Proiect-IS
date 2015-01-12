<%@page import="beans.AccountDetail"%>
<%@page import="java.util.List"%>
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
	}else
{%>
<center><h2><font face="verdana" color="6698ff">Welcome Manager</font></h2></center><hr width="1000" size="5"><br>
<center><h3><font face="verdana">Select the Account No to see the information</font></h3></center>
<table width="1000">
	<tr>
		<td width="900"><a href="Manager.jsp">Home</a></td>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<center>
<table>
	<tr>
		<th>Account numbers</th>
	</tr>
	<%List<AccountDetail> actdtl= (List<AccountDetail>)session.getAttribute("accountn");
	for(AccountDetail u:actdtl){%>
	<tr>
		<td><% out.println("<a href=ShowDetails?accno="+u.getAccno()+">"+u.getAccno()+"</a>"); %></td>
	</tr>	
	<%} %>
</table>
</center>
<center><a href="Manager.jsp">Back</a></center>
<%} %></body>
</html>