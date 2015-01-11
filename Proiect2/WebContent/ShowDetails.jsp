<%@page import="dao.AccountDetailDAO"%>
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
</head>
<body>
<%if(session.getAttribute("valid")==null){
	response.sendRedirect("errors.jsp");
}else {%>
<center><h2><font face="verdana" color="6698ff">Welcome Manager</font></h2></center><hr width="1000" size="5"><br>
<center><h3><font face="verdana">Required information</font></h3></center>
<table width="1000">
	<tr>
		<td width="900"><a href="Manager.jsp">Home</a></td>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<%AccountDetail actdtl= (AccountDetail)session.getAttribute("details");%>
<center>
<table border="2">
	<tr>
		<td width="300" align="left">Customer Name</td>
		<td  width="300" align="left">Customer Account no</td>
		<td width="300" align="left">Customer balance</td>
		<td  width="300" align="left">Customer Gender</td>
		<td  width="300" align="left">Customer Address</td>
		<td  width="300" align="left">Customer Status</td>
		<td width="300" align="left">Customer Emailid</td>
		<td width="300" align="left">Customer Phoneno</td>
	</tr>
	<tr>
		<% out.println("<td width=300 align=left>"+actdtl.getUsername()+"</td>");%>
		<% out.println("<td width=300 align=left>"+actdtl.getAccno()+"</td>");%>
		<% out.println("<td width=300 align=left>"+actdtl.getAmount()+"</td>");%>
		<% out.println("<td width=300 align=left>"+actdtl.getGender()+"</td>");%>
		<% out.println("<td width=300 align=left>"+actdtl.getAddress()+"</td>");%>
		<% out.println("<td width=300 align=left>"+actdtl.getStatus()+"</td>");%>
		<% out.println("<td width=300 align=left>"+actdtl.getEmailid()+"</td>");%>
		<% out.println("<td width=300 align=left>"+actdtl.getPhoneno()+"</td>");%>
	</tr>
</table>
</center>
<center><a href="ShowAllAccno.jsp">Back</a></center>
<%} %>
</body>
</html>