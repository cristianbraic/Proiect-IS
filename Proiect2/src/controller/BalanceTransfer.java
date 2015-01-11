package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;

import beans.AccountDetail;
import beans.TransactionDetail;

import dao.AccountDetailDAO;
import dao.TransactionDetailDAO;

/**
 * Servlet implementation class BalanceTransfer
 */
@SuppressWarnings("unused")
@WebServlet("/BalanceTransfer")
public class BalanceTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess=request.getSession();
		if(sess.getAttribute("valid")==null)
		{
			sess.setAttribute("msg", "You have to login");
			response.sendRedirect("errors.jsp");
		}else{
			int toaccno;
			String toaccnos=request.getParameter("toaccno");
			int fromaccno;
			String fromaccnos=request.getParameter("fromaccno");
			double transamount;
			String transamounts=request.getParameter("transamount");
			String user=(String) sess.getAttribute("user");
			AccountDetailDAO dao=new AccountDetailDAO();
			TransactionDetailDAO daotrd=new TransactionDetailDAO();
			try
			{
				transamount=Double.parseDouble(transamounts);
				fromaccno=Integer.parseInt(fromaccnos);
				toaccno=Integer.parseInt(toaccnos);
				dao.getConnection();
				if(toaccno==fromaccno)
				{
					sess.setAttribute("msg", "Transfering account number cannot be same ");
					response.sendRedirect("BalanceTransfer.jsp");
				}else
				{
					String check=dao.checkExist(toaccno);
					if((check.equals("exist"))==false)
					{
						sess.setAttribute("msg", "The account for transfering the balance does not exist");
						response.sendRedirect("BalanceTransfer.jsp");
					}else
					{
						String status1=dao.checkStatus(fromaccno);
						if(status1.equals("Inactive"))
						{	
							sess.setAttribute("msg", "The account is inactive balance transfer cannot performed");
							response.sendRedirect("BalanceTransfer.jsp");
						}else 
						{	
							if((transamount<=5000)==false)
							{
								sess.setAttribute("msg", "The transfering amount need to be less or eqal to 5000");
								response.sendRedirect("BalanceTransfer.jsp");
							}else 
							{
								check=dao.checkExist(toaccno);
								if((check.equals("exist"))==false)
								{
									sess.setAttribute("msg", "The account for transfering the balance does not exist");
									response.sendRedirect("BalanceTransfer.jsp");
								}else 
								{
									AccountDetail actdtl=dao.getAmountfromaccno(fromaccno);
									if((actdtl.getAmount()>10000)==false)
									{	
										sess.setAttribute("msg", "Your account balance need to be greater then 10000");
										response.sendRedirect("BalanceTransfer.jsp");
									} else 
									{
										dao.setNewAmount(fromaccno, transamount, toaccno);
										java.util.Date d=new java.util.Date();
										int yr=d.getYear()-100;
										int dt=d.getDate();
										int mn=d.getMonth()+1;
										String shwdate=dt+"/"+mn+"/"+yr;
										dao.closeDBactdtl();
										daotrd.getConnection();
										daotrd.addTransactionDetail(new TransactionDetail(user,fromaccno,toaccno,transamount,shwdate));
										daotrd.closeDBtrndtl();
										sess.setAttribute("msg", "The Money is successfully transferred");
										response.sendRedirect("Customer.jsp");
									}
								}
							}
						}	
					}	
				}
			}catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(NumberFormatException e)
			{
				sess.setAttribute("msg", "Please fillup all the fields");
				response.sendRedirect("BalanceTransfer.jsp");
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doGet(request, response);
	}
}
