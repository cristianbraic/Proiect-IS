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
<% if(session.getAttribute("valid")==null){
	response.sendRedirect("errors.jsp");} else{
		if(session.getAttribute("msg")!="null")
		{
			out.println("<font color=red>"+session.getAttribute("msg")+"</font>");
			session.setAttribute("msg","null");
		}
		if((session.getAttribute("role")).equals("CUSTOMER")){
		String user=(String)session.getAttribute("user");%>
		<center><h2><font face="verdana"  color="ff66cc">Welcome <%=user %></font></h2></center><hr width="1000" size="5"><br>
		<%} else { %>
<center><h2><font face="verdana"  color="6698ff">Welcome Manager</font></h2></center><hr width="1000" size="5"><br><%} %>
<center><h3><font face="verdana">Enter the required information</font></h3></center>
<table width="1000">
	<tr>
		<% if((session.getAttribute("role")).equals("CUSTOMER")){%>
		<td width="900"><a href="Customer.jsp">Home</a></td>
		<%}
		else {%>
		<td width="900"><a href="Manager.jsp">Home</a></td>
		<%} %>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<form action="ChangePassword" method="POST">
<center><table width="500">
	<tr>
		<td width="250" align="left">Enter the Current Password</td>
		<td width="250" align="left"><input type="password" name="oldpassword"></td>
	</tr>
	<tr>
		<td width="250" align="left">Enter the New Password</td>
		<td width="250" align="left"><input type="password" name="newpassword"></td>
	</tr>
	<tr>
		<td width="250" align="left">Retype the Password</td>
		<td width="250" align="left"><input type="password" name="renewpassword"></td>
	</tr>
	<tr>
		<td width="500" align="center"><input type="submit" name="submit" value="change"></td>
	</tr>
</table>
</center>
</form>
<% if((session.getAttribute("role")).equals("CUSTOMER")){%>
<center><a href="Customer.jsp">Back</a></center>
<%} else { %>
<center><a href="Manager.jsp">Back</a></center>
<%} }%>
</body>
</html>