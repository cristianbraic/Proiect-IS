package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.TransactionDetail;

import com.mysql.jdbc.Driver;

public class TransactionDetailDAO {
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
	public void closeDBtrndtl() throws SQLException
	{
			pst.close();
			
	}
	public void addTransactionDetail(TransactionDetail trndtl) throws SQLException
	{
			pst=conn.prepareStatement("insert into transactiondetail values(?,?,?,?,?)");
			pst.setString(1, trndtl.getUsername());
			pst.setInt(2,trndtl.getFromacct());
			pst.setInt(3,trndtl.getToacct());
			pst.setDouble(4, trndtl.getTransamount());
			pst.setString(5, trndtl.getShwdate());
			pst.executeUpdate();
	}
	public List<TransactionDetail> getTrndtlfromaccno(int accno) throws SQLException
	{
		List<TransactionDetail> trndtls=new ArrayList<TransactionDetail>();
		pst=conn.prepareStatement("select * from transactiondetail where fromacct=?");
		pst.setInt(1, accno);
		rs=pst.executeQuery();
		while(rs.next())
		{
				trndtls.add(new TransactionDetail(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getString(5)));
		}
		return trndtls;
	}
	public List<TransactionDetail> getTrndtltoaccno(int accno) throws SQLException{
		List<TransactionDetail> trndtls=new ArrayList<TransactionDetail>();
		pst=conn.prepareStatement("select * from transactiondetail where toacct=?");
		pst.setInt(1, accno);
		rs=pst.executeQuery();
		while(rs.next())
		{
				trndtls.add(new TransactionDetail(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4),rs.getString(5)));
		}
		return trndtls;
	}
}
