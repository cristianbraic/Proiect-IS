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

import dao.AccountDetailDAO;

/**
 * Servlet implementation class ChangingStatus
 */
@WebServlet("/ChangingStatus")
public class ChangingStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
		if(sess.getAttribute("valid")==null)
		{
			sess.setAttribute("msg", "You have to login");
			response.sendRedirect("errors.jsp");
		}else
		{
			String status=request.getParameter("status");
			PrintWriter out=response.getWriter();
			int accno=(Integer) sess.getAttribute("accno");
			AccountDetailDAO dao=new AccountDetailDAO();
			try {
				dao.getConnection();
				out.println("yes 1");
				dao.setNewStatus(accno,status);
				out.println("yes 1");
				sess.setAttribute("msg", "Yor account no "+accno+" is "+status);
				response.sendRedirect("Customer.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
