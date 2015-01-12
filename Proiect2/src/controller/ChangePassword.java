package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
 		if(sess.getAttribute("valid")==null)
		{
			sess.setAttribute("msg", "You have to login");
			response.sendRedirect("errors.jsp");
		}else
		{
			LoginDAO daolg=new LoginDAO();
			String oldpassword=request.getParameter("oldpassword");
			String newpassword=request.getParameter("newpassword");
			String renewpassword=request.getParameter("renewpassword");
			if(oldpassword==null || newpassword==null || renewpassword==null)
			{
				oldpassword=null;
				sess.setAttribute("msg", "Please fill up all the fields");
				response.sendRedirect("ChangePassword.jsp");
			}else
			{
				try {
					daolg.getConnection();
					String checkexist=daolg.checkExist(oldpassword);
					if(checkexist.equals("exist")==false)
					{
						newpassword=null;
						renewpassword=null;
						sess.setAttribute("msg","The password type is wrong");
						response.sendRedirect("ChangePassword.jsp");
					}else
					{	
						if((newpassword.equals(renewpassword))==false)
						{
							sess.setAttribute("msg","Your retype password is not matching. Try again");
							response.sendRedirect("ChangePassword.jsp");
						}else
						{
							String user=(String)sess.getAttribute("user");
							daolg.changePassword(user,renewpassword);
							sess.setAttribute("msg", "Your Password is successfully changed");
							if((sess.getAttribute("role")).equals("CUSTOMER"))
							{
								response.sendRedirect("Customer.jsp");
							}else
							{
								response.sendRedirect("Manager.jsp");
							}
						}
					}
				} catch (SQLException e) {					
					e.printStackTrace();
				}finally
				{
					try 
					{
						daolg.closeDBlg();
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
