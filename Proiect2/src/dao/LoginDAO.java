package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Login;

import com.mysql.jdbc.Driver;

public class LoginDAO {
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
	public void setpassword(String password,String username) throws SQLException{
		pst=conn.prepareStatement("Update Login set password="+password+"where username="+username);
		pst.executeQuery();
	}
	public void closeDBlg() throws SQLException
	{
			pst.close();
			
	}
	public Login gettheRole(String username,String password) throws SQLException{
		pst=conn.prepareStatement("select role from Login where username=? and password=?");
		pst.setString(1, username);
		pst.setString(2, password);
		rs=pst.executeQuery();
		if(rs.next())
		{
			return (new Login(rs.getString(1)));
		}
		else {
			return (new Login("Null"));
		}
	}
		public void addLogin(Login custmr) throws SQLException{
			pst=conn.prepareStatement("insert into login values(?,?,?)");
			pst.setString(1, custmr.getUsername());
			pst.setString(2, custmr.getPassword());
			pst.setString(3, custmr.getRole());
			pst.executeUpdate();
		}
		public String checkExist(String oldpassword) throws SQLException{
				pst=conn.prepareStatement("select * from login where password=?");
				pst.setString(1, oldpassword);
				rs=pst.executeQuery();
				if(rs.next())
				{
						return "exist";
				}
				else{
					return "notexist";
				}
		}
		public void changePassword(String user,String renewpassword) throws SQLException{
			pst=conn.prepareStatement("update login set password=? where username=?");
			pst.setString(1, renewpassword);
			pst.setString(2, user);
			pst.executeUpdate();
		}
		public void getPassword(String oldpassword,String newpassword,String username) throws SQLException{
			pst=conn.prepareStatement("select * from login where password=?");
			pst.setString(1, oldpassword);
			rs=pst.executeQuery();
			if(rs.next())
			{
					pst=conn.prepareStatement("update login set password=? where username=?");
					pst.setString(1, newpassword);
					pst.setString(2, username);
					pst.executeUpdate();
			}
		}
		public List<Login> getAllUsername() throws SQLException{
			List<Login> user=new ArrayList<Login>();
			pst=conn.prepareStatement("select * from login where role=?");
			pst.setString(1, "CUSTOMER");
			rs=pst.executeQuery();
			while(rs.next())
			{
				user.add(new Login(rs.getString(1),rs.getString(2)));
			}
			return user;
		}
		public String checkExistCustomer(String username) throws SQLException{
			pst=conn.prepareStatement("select * from Login where username=?");
			pst.setString(1, username);
			rs=pst.executeQuery();
			if(rs.next()){
				return "exist";
			}
			else{
				return "netexist";
			}
		}
}
