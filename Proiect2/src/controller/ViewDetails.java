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
import beans.TransactionDetail;

import dao.AccountDetailDAO;
import dao.TransactionDetailDAO;

/**
 * Servlet implementation class ViewDetails
 */
@WebServlet("/ViewDetails")
public class ViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			HttpSession sess=request.getSession();
	 		if(sess.getAttribute("valid")==null)
			{
				sess.setAttribute("msg", "You have to login");
				response.sendRedirect("errors.jsp");
			}else
			{
				int accno=(Integer) sess.getAttribute("accno");
				AccountDetailDAO dao= new AccountDetailDAO();
				TransactionDetailDAO daotd=new TransactionDetailDAO();
				try 
				{
					dao.getConnection();
					AccountDetail actdtl=dao.getDetails(accno);
					sess.setAttribute("detail", actdtl);
					dao.closeDBactdtl();
					daotd.getConnection();
					List<TransactionDetail> trndtl1=daotd.getTrndtlfromaccno(accno);
					sess.setAttribute("transaction1", trndtl1);
					List<TransactionDetail> trndtl2=daotd.getTrndtltoaccno(accno);
					sess.setAttribute("transaction2", trndtl2);
					response.sendRedirect("ViewTranDetails.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						daotd.closeDBtrndtl();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
