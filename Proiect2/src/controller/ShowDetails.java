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
 * Servlet implementation class ShowDetails
 */
@WebServlet("/ShowDetails")
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
 		if(sess.getAttribute("valid")==null)
		{
			sess.setAttribute("msg", "You have to login");
			response.sendRedirect("errors.jsp");
		}else{
			AccountDetailDAO dao=new AccountDetailDAO();
			int accno=Integer.parseInt(request.getParameter("accno"));
			try {
				dao.getConnection();
				AccountDetail actdtl=dao.getDetails(accno);
				sess.setAttribute("details", actdtl);
				response.sendRedirect("ShowDetails.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
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
