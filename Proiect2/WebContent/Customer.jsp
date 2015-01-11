<%@page import="beans.AccountDetail"%>
<%@page import="java.util.List"%>
<%@page import="dao.AccountDetailDAO"%>
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
}else{
if(session.getAttribute("msg")!="null")
{
	out.println("<font color=green>"+session.getAttribute("msg")+"</font>");
	session.setAttribute("msg","null");
}
String user=(String)session.getAttribute("user");
%>
<center><h2><font face="verdana"  color="6698ff">Welcome <%=user %></font></h2></center><hr width="1000" size="5"><br>
<table width="1000">
	<tr>
		<td width="900"><a href="Customer.jsp">Home</a></td>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<font face="vardana">Click on the Account Links for Action</font>
<center><table border="2" height="10">
	<tr>
		<th>Your Account number</th>
	</tr>
	<%List<AccountDetail> actdtl= (List<AccountDetail>)session.getAttribute("accountno");
	for(AccountDetail u:actdtl){%>
	<tr>
		<td algn="center"><% out.println("<a href=CustomerControl.jsp?accno="+u.getAccno()+">"+u.getAccno()+"</a>"); %></td>
	<%} %></tr></table><br><br>
	<a href="ChangePassword.jsp">Change Password</a></center>
	
	<%} %>
</body>
</html>