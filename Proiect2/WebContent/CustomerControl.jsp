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
}else {
	String users=(String)session.getAttribute("user");
%>
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
<center><font face="verdana">Perform operation</font></center><br>
<%int accno=Integer.parseInt(request.getParameter("accno"));
session.setAttribute("accno", accno);
String user=(String)session.getAttribute("user");%>
<center>
<font face="arial">Select the operation for Account no <%=accno %></font><br><br></center>
<center><% out.println("<a href=ViewDetails?>View Details</a>");%><br>
<%   out.println("<a href=BalanceTransfer.jsp?>Balance Transfer</a>");%><br>
 <% out.println("<a href=ChangeStatus?>Change status</a>");%></center><br><br>
 <center><a href="Customer.jsp">Back</a></center>
<%} %>
</body>
</html>