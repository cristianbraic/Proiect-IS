
<%@page import="beans.TransactionDetail"%>
<%@page import="java.util.List"%>
<%@page import="beans.AccountDetail"%>
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
	else{
String user=(String)session.getAttribute("user");
%>
<center><h2><font face="verdana"  color="6698ff">Welcome <%=user %></font></h2></center><hr width="1000" size="5"><br>
<table width="1000">
	<tr>
		<td width="900"><a href="Customer.jsp">Home</a></td>
		<td width="800"><a href="ViewTranDetails.jsp">View details</a></td>
		<td width="700"><a href="BalanceTransfer.jsp">Balance Transfer</a></td>
		<td width="600"><a href="ChangeStatus.jsp">Change Status</a></td>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<%AccountDetail actdtl=(AccountDetail)session.getAttribute("detail");
%>
<center><font face="verdana">Your personal details</font></center>
<center><table border="2">
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
</table></center><br><br>
<center><font face="verdana">Transaction Details<br>
Money Transferred from your account</font></center>
<% 
List<TransactionDetail> trndtls1=(List<TransactionDetail>)session.getAttribute("transaction1");%>
<center>
<table border="1">
	<tr>
		<td>Your name</td>
		<td>Account No</td>
		<td>Transfer to</td>
		<td>Amount Transfered</td>
		<td>Date of Transfer</td>
		
	</tr>
	<% for(TransactionDetail td:trndtls1) {%>
	<tr>
			<% out.println("<td>"+td.getUsername()+"</td>"); %>
			<% out.println("<td>"+td.getFromacct()+"</td>"); %>
			<% out.println("<td>"+td.getToacct()+"</td>"); %>
			<% out.println("<td>"+td.getTransamount()+"</td>"); %>
			<% out.println("<td>"+td.getShwdate()+"</td>"); %>
	</tr><%} %>
</table>
</center><br><br>
<center><font face="verdana">Money transferred to your account</font></center>
<% 
List<TransactionDetail> trndtls2=(List<TransactionDetail>)session.getAttribute("transaction2");%>
<center>
<table border="1">
	<tr>
		<td>User name</td>
		<td>Account No</td>
		<td>Transfer to</td>
		<td>Amount Transfered</td>
		<td>Date of Transfer</td>
		
	</tr>
	<% for(TransactionDetail td:trndtls2) {%>
	<tr>
			<% out.println("<td>"+td.getUsername()+"</td>"); %>
			<% out.println("<td>"+td.getFromacct()+"</td>"); %>
			<% out.println("<td>"+td.getToacct()+"</td>"); %>
			<% out.println("<td>"+td.getTransamount()+"</td>"); %>
			<% out.println("<td>"+td.getShwdate()+"</td>"); %>
	</tr><%} %>
</table>
</center><br>
<center><a href="Customer.jsp">Back</a></center>
<%} %>
</body>
</html>