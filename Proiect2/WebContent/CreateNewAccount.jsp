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
	}else { %>
<%if(session.getAttribute("msg")!="null")
{
	out.println("<font color=red>"+session.getAttribute("msg")+"</font>");
	session.setAttribute("msg","null");
}%>
<center><h2><font face="verdana" color="6698ff">Welcome Manager</font></h2></center><hr width="1000" size="5"><br>
<center><h3><font face="verdana">Enter the required information</font></h3></center>
<table width="1000">
	<tr>
		<td width="900"><a href="Manager.jsp">Home</a></td>
		<td width="100"><a href="Logout">Logout</a></td>
	</tr>
</table>
<center><form action="CreateNewAcount">
<table width="500">
	<tr>
		<td width="300" align="left">Enter the name of the Customer</td>
		<td width="200"><input type="text" name="username" ></td>
	</tr>
	<tr>
		<td width="300" align="left">Enter the password of the customer</td>
		<td width="200"><input type="password" name="password"></td>
	</tr>
	<tr>
		<td width="300"  align="left">Enter the initial amount</td>
		<td width="200"><input type="text" name="amount"></td>
	</tr>
	<tr>
		<td width="300"  align="left">Enter the phone no</td>
		<td width="200"><input type="text" name="phoneno"></td>
	</tr>
	<tr>
		<td width="300"  align="left">Select the gender</td>
		<td width="200"><input type="radio" name="gender" value="female">female
			<input type="radio" name="gender" value="male">Male</td>
	</tr>
	<tr>
		<td width="300" align="left">Customer Address</td>
		<td width="200"><input type="text" name="address"></td>
	</tr>
	<tr>
		<td width="300" align="left">Enter the Emailid</td>
		<td width="200"><input type="text" name="emailid"></td>
	</tr>
	<tr>
		<td><input type="hidden" name="status" value="Active"></td>
	</tr>
	<tr>
		<td width="500"><input type="submit" name="submit" value="Create"></td>
	</tr>

</table>
</form>
</center>
<center><a href="Manager.jsp">Back</a></center>
<%} %>
</body>
</html>