<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Banking</title>
</head>
<body>

<% session.setAttribute("login", "yes");
if(session.getAttribute("showmsg")!=null){
	out.println("<font face=verdana color=ee0000>"+session.getAttribute("showmsg")+"</font>");
	session.setAttribute("showmsg", null);
	}
	else if(session.getAttribute("showmsg")==null){
		session.setAttribute("msg", "null");
	}%>
<center><h2><font face="Times New Roman" color="blue">Welcome to Online Banking</font></h2><br><br>
<p align="left">To log on, enter your Username and Password </p>
<hr width="900" size="5">
<form action="LogInValidation" method="POST">
<table height="20">
	<tr>
		<td width="200">Enter the Username</td>
		<td bgcolor="pink" width="100"><input type="text" name="user" ></td>
	</tr>
</table>
<table height="20">
	<tr>
		<td width="200">Enter the Password</td>
		<td bgcolor="pink" width="100"><input type="password" name="pass" ></td>
	</tr>
</table>
<table>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>
</center>
</body>
</html>