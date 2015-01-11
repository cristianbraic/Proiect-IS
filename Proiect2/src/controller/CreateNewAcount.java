package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AccountDetail;
//import beans.AccountDetail;
import beans.Login;

import dao.AccountDetailDAO;
import dao.LoginDAO;


/**
 * Servlet implementation class CreateNewAcount
 */
@WebServlet("/CreateNewAcount")
public class CreateNewAcount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
 		if(sess.getAttribute("valid")==null)
		{
			sess.setAttribute("msg", "You have to login");
			response.sendRedirect("errors.jsp");
		}else{
			String username;
			String password;
			AccountDetailDAO dao;
			LoginDAO daolg;
			dao=new AccountDetailDAO();
			daolg=new LoginDAO();
			double amount;
			int accno=1;
			PrintWriter out=response.getWriter();
			String phoneno;
			String gender;
			String address;
			String status;
			String emailid;
			String amounts;
			String check;
			String role="CUSTOMER";
			username=request.getParameter("username");
			password=request.getParameter("password");
			amounts=request.getParameter("amount");
			gender=request.getParameter("gender");
			address=request.getParameter("address");
			status=request.getParameter("status");
			emailid=request.getParameter("emailid");
			phoneno=request.getParameter("phoneno");
			if(username==null || address==null || gender==null || emailid==null || phoneno==null)
			{
				sess.setAttribute("msg","Please fill up all the fields");
				response.sendRedirect("CreateNewAccount.jsp");
			}else
			{
				if(((( emailid.contains("@gmail.com") || emailid.contains("@yahoo.com") || emailid.contains("@hotmail.com")))==false) && (phoneno.length()!=10))
				{
					sess.setAttribute("msg", "The phoneno should be 10 digit and emailid is not valid");
					response.sendRedirect("CreateNewAccount.jsp");
				}else
				{
					if(phoneno.length()!=10)
					{
						username=null;
						sess.setAttribute("msg", "The Phone no should be 10 digit.");
						response.sendRedirect("CreateNewAccount.jsp");
					} else
					{
						if(((emailid.contains("@gmail.com") || emailid.contains("@yahoo.com") || emailid.contains("@hotmail.com"))==false))
						{
							sess.setAttribute("msg", "Emailid is not valid");
							response.sendRedirect("CreateNewAccount.jsp");
						}
						else
						{
							try 
							{
								amount=Double.parseDouble(amounts);
								daolg.getConnection();
								check=daolg.checkExistCustomer(username);
								if(check=="exist")
								{
									username=null;
									sess.setAttribute("msg", "The username already exist");	
									response.sendRedirect("CreateNewAccount.jsp");
								}
								daolg.addLogin(new Login(username,password,role));
								daolg.closeDBlg();
								AccountDetail actdtl=new AccountDetail(username,amount,gender,address,status,emailid,phoneno);
								out.println("YES");
								out.println("YES");
								dao.getConnection();
								out.println("YES");
								accno=dao.addAccountDetails(actdtl);
								out.println("YES");
								sess.setAttribute("msg","The Customer is sucessfully added and the account no is "+accno);
								response.sendRedirect("Manager.jsp");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
							finally
							{
								try {
									daolg.closeDBlg();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
