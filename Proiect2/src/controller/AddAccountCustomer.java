package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDetailDAO;

import beans.AccountDetail;

/**
 * Servlet implementation class AddAccountCustomer
 */
@WebServlet("/AddAccountCustomer")
public class AddAccountCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		HttpSession sess=request.getSession();
 		if(sess.getAttribute("valid")==null)
		{
			sess.setAttribute("msg", "You have to login");
			response.sendRedirect("errors.jsp");
		}else
		{
			String username=request.getParameter("user");
			int accno;
			double amount; 
			String amounts=request.getParameter("amount");
			String gender=request.getParameter("gender");
			String address=request.getParameter("address");
			String status=request.getParameter("status");
			String emailid=request.getParameter("emailid");
			String phoneno=request.getParameter("phoneno");
			AccountDetailDAO dao=new AccountDetailDAO();
			if(username==null || address==null || gender==null || emailid==null || phoneno==null)
			{
				sess.setAttribute("msg","Please fill up all the fields");
				response.sendRedirect("AddAccountCustomer.jsp");
			}else
			{
				if(((( emailid.contains("@gmail.com") || emailid.contains("@yahoo.com") || emailid.contains("@hotmail.com")))==false) && (phoneno.length()!=10))
				{
					sess.setAttribute("msg", "The phoneno should be 10 digit and emailid is not valid");
					response.sendRedirect("AddAccountCustomer.jsp");
				}else
				{
					if(phoneno.length()!=10)
					{
						username=null;
						sess.setAttribute("msg", "The Phone no should be 10 digit.");
						response.sendRedirect("AddAccountCustomer.jsp");
					} else
					{
						if(((emailid.contains("@gmail.com") || emailid.contains("@yahoo.com") || emailid.contains("@hotmail.com"))==false))
						{
							sess.setAttribute("msg", "Emailid is not valid");
							response.sendRedirect("AddAccountCustomer.jsp");
						}
						else
						{
							try 
							{
								dao.getConnection();
								amount=Double.parseDouble(amounts);
								AccountDetail actdtl=new AccountDetail(username, amount,gender, address, status, emailid, phoneno);
								accno=dao.addAccountDetails(actdtl);
								sess.setAttribute("msg","Account successfully added.Your account no is "+accno);
								response.sendRedirect("Manager.jsp");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}finally
							{
								try {
									dao.closeDBactdtl();
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
