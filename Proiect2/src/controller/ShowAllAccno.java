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

import dao.AccountDetailDAO;

/**
 * Servlet implementation class ShowAllDetails
 */
@WebServlet("/ShowAllAccno")
public class ShowAllAccno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess=request.getSession();
 		if(sess.getAttribute("valid")==null)
		{
			sess.setAttribute("msg", "You have to login");
			response.sendRedirect("errors.jsp");
		}else{
			AccountDetailDAO dao=new AccountDetailDAO();
			try {
				dao.getConnection();
				List<AccountDetail> actdtl=dao.getAccountno();
				sess.setAttribute("accountn", actdtl);
				response.sendRedirect("ShowAllAccno.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					dao.closeDBactdtl();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
