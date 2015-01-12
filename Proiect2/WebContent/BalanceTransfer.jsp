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
<%if(session.getAttribute("valid")==null)
{
	response.sendRedirect("errors.jsp");
	}else
	{
	if(session.getAttribute("msg")!="null")
		{
			out.println("<font color=red>"+session.getAttribute("msg")+"</font>");
			session.setAttribute("msg","null");
		}
 		String users=(String)session.getAttribute("user");%>
<center><h2><font face="verdana"  color="6698ff">Welcome <%=users %></font></h2></center><hr width="1000" size="5"><br>
<table width="1000">
	<tr>
		<td width="900"><a href="Customer.jsp">Home</a></td>
		<td width="800"><a href="ViewTranDetails.jsp">View details</a></td>
		<td width="700"><a href="BalanceTransfer.jsp">Balance Transfer</a></td>
		<td width="600"><a href="ChangeStatus.jsp">Change Status</a></td>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<center>
<font face="verdana" size="2">The amount of transfer money should be less then or equals to 5000*</font><br>
<font face="verdana" size="2">The amount in your account need to be greater then 10000*</font>
<%int accno=(Integer)session.getAttribute("accno");%>
<form action="BalanceTransfer" method="POST">
<table>
	<tr>
		<td>Your Account no</td>
		<td><%out.println(accno); %></td>
	</tr>
	<tr>
		<td>Transfer Amount to</td>
		<td><input type="text" name="toaccno"></td>
	</tr>
	<tr>
		<td>Amount Transfer</td>
		<td><input type="text" name="transamount"></td>
	</tr>
	<tr>
		<td><input type="hidden" name="fromaccno" value="<%=accno %>"></td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="Transfer"></td>
	</tr>
</table>
</form>
</center>
<center><a href="Customer.jsp">Back</a></center>
<%} %></body>
</html>