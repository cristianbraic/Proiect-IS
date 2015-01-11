package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.AccountDetail;

import com.mysql.jdbc.Driver;

public class AccountDetailDAO {
	Connection conn;
	ResultSet rs;
	Statement st;
	PreparedStatement pst;
	
	public void getConnection() throws SQLException
	{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking","root","");
	}
	

	public int addAccountDetails(AccountDetail actdtl) throws SQLException
	{
			pst=conn.prepareStatement("insert into accountdetail(username,amount,gender,address,status,emailid,phoneno) values(?,?,?,?,?,?,?)");
			pst.setString(1, actdtl.getUsername());
			pst.setDouble(2,actdtl.getAmount());
			pst.setString(3, actdtl.getGender());
			pst.setString(4, actdtl.getAddress());
			pst.setString(5, actdtl.getStatus());
			pst.setString(6, actdtl.getEmailid());
			pst.setString(7,actdtl.getPhoneno());
			pst.executeUpdate();
			pst=conn.prepareStatement("select MAX(accno) from accountdetail");
			rs=pst.executeQuery();
			if(rs.next()){
				return (rs.getInt(1));
			}else
				return (Integer) null;
	}
	public void closeDBactdtl() throws SQLException
	{
			pst.close();
			
	}
	public List<AccountDetail> getActdtls() throws SQLException
	{
		List<AccountDetail> actdtls=new ArrayList<AccountDetail>();
		pst=conn.prepareStatement("select * from Accountdetail");
		rs=pst.executeQuery();
		while(rs.next())
		{
			actdtls.add(new AccountDetail(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
		}
		return actdtls;
	}
	public List<AccountDetail> getAccountno() throws SQLException{
		List<AccountDetail> actdtl=new ArrayList<AccountDetail>();
		pst=conn.prepareStatement("select accno from Accountdetail");
		rs=pst.executeQuery();
		while(rs.next())
		{
				actdtl.add(new AccountDetail(rs.getInt(1)));
		}
		return actdtl;
	}
	public List<AccountDetail> getAccountno(String username) throws SQLException{
		List<AccountDetail> acc=new ArrayList<AccountDetail>();
		pst=conn.prepareStatement("select accno from accountdetail where username=?");
		pst.setString(1, username);
		rs=pst.executeQuery();
		while(rs.next())
		{
			acc.add(new AccountDetail(rs.getInt(1)));
		}
		return acc;
	}
	public List<AccountDetail> getAllUsername() throws SQLException{
		List<AccountDetail> user=new ArrayList<AccountDetail>();
		pst=conn.prepareStatement("select username from Login where role=?");
		pst.setString(1, "CUSTOMER");
		rs=pst.executeQuery();
		while(rs.next())
		{
			user.add(new AccountDetail(rs.getString(1)));
		}
		return user;
	}
	public AccountDetail getDetails(int accno) throws SQLException{
		pst=conn.prepareStatement("select * from accountdetail where accno=?");
		pst.setInt(1, accno);
		rs=pst.executeQuery();
		if(rs.next())
		{
			return(new AccountDetail(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
		}
		else{
			return null;
		}
	}
	public AccountDetail getAmountfromaccno(int fromaccno) throws SQLException{
		pst=conn.prepareStatement("select amount from accountdetail where accno=?");
		pst.setInt(1, fromaccno);
		rs=pst.executeQuery();
		if(rs.next())
		{
			return(new AccountDetail(rs.getDouble(1)));
		}
		else{
			return null;
		}
	}
	public String checkExist(int toaccno) throws SQLException{
		pst=conn.prepareStatement("select * from accountdetail where accno=?");
		pst.setInt(1, toaccno);
		rs=pst.executeQuery();
		if(rs.next())
		{
				return "exist";
		}
		else{
			return "notexist";
		}
	}
	public void setNewAmount(int fromaccno,double amount,int toaccno) throws SQLException{
		pst=conn.prepareStatement("update accountdetail set amount=amount-? where accno=?");
		pst.setDouble(1, amount);
		pst.setInt(2, fromaccno);
		pst.executeUpdate();
		pst=conn.prepareStatement("update accountdetail set amount=amount+? where accno=?");
		pst.setDouble(1, amount);
		pst.setInt(2, toaccno);
		pst.executeUpdate();
	}
	public String checkStatus(int accno) throws SQLException{
		pst=conn.prepareStatement("select status from accountdetail where accno=?");
		pst.setInt(1, accno);
		rs=pst.executeQuery();
		if(rs.next())
		{
				return (rs.getString(1));
		}
		else{
			return null;
		}
	}
	public void setNewStatus(int accno,String status) throws SQLException{
		pst=conn.prepareStatement("update accountdetail set status=? where accno=?");
		pst.setString(1, status);
		pst.setInt(2, accno);
		pst.executeUpdate();
	}
}
