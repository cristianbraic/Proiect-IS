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
}else {
String users=(String)session.getAttribute("user");
%>
<center><h2><font face="verdana"  color="6698ff">Welcome <%=users %></font></h2></center><hr width="1000" size="5"><br>
<table width="1000">
	<tr>
		<td width="900"><a href="Customer.jsp">Home</a></td>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<br><br>
<% String status=(String)session.getAttribute("status");
int accno=(Integer)session.getAttribute("accno");%>
<% out.println("Currently yoour account no "+accno+" is "+status);
if(status.equals("Active")){
	out.println("<a href=ChangingStatus?status=Inactive>Click on the link to make it inactive</a>");
}
else{
out.println("<a href=ChangingStatus?status=Active>Click on the link to make it Active</a>");
}%><br><br>
<center><a href="Customer.jsp">Back</a></center>
<%}%>
</body>
</html>