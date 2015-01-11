package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AccountDetail;
import beans.Login;

import dao.AccountDetailDAO;
import dao.LoginDAO;

/**
 * Servlet implementation class Checking
 */
@WebServlet("/LogInValidation")
public class LogInValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
 		if(sess.getAttribute("login")==null)
		{
			sess.setAttribute("msg", "You have to login");
			response.sendRedirect("errors.jsp");
		}else
		{
			LoginDAO daolg=new LoginDAO();
			String user;
			String pass;
			String role;
			AccountDetailDAO dao=new AccountDetailDAO();
			response.setContentType("text/html");
			try {
				daolg.getConnection();
				user=request.getParameter("user");
				pass=request.getParameter("pass");
				if(user=="" || pass=="")
				{
					sess.setAttribute("showmsg", "Username or password cannot be empty");
					response.sendRedirect("Login.jsp");
				}
				else
				{
					Login grole=daolg.gettheRole(user, pass);
					role=grole.getRole();
					daolg.closeDBlg();
					dao.getConnection();
					if(role!="Null"){
						sess.setAttribute("role",role);
						sess.setAttribute("user",user);
						sess.setAttribute("pass",pass);
						sess.setAttribute("valid", "valid");
						if(role.equals("MANAGER"))
						{
							sess.setAttribute("msg","null");
							response.sendRedirect("Manager.jsp");
						}
						else if(role.equals("CUSTOMER"))
						{
							List<AccountDetail> actdtl=dao.getAccountno(user);
							sess.setAttribute("accountno", actdtl);
							sess.setAttribute("msg","null");
							response.sendRedirect("Customer.jsp");
						}
					}else{
						sess.setAttribute("showmsg","Wrong username or password. LogIn again");
						response.sendRedirect("Login.jsp");
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
