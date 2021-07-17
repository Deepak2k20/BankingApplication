package com.icici.deepak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WithdrawDao {

	private String driver="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/bank";
	private String uname="root";
	private String pass="deepak@123";
	
	public void loadDriver(String driver)
	{
		try
		{
			Class.forName(driver);
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con=null;
		try
		{
			con=DriverManager.getConnection(url, uname, pass);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public String withdraw(Withdraw w)
	{
		loadDriver(driver);
		Connection con=getConnection();
		String result="";
		try
		{
			PreparedStatement ps=con.prepareStatement("select amt from customer where acno=? and name=? and pass=?");
			ps.setInt(1, w.getAcno());
			ps.setString(2, w.getUname());
			ps.setString(3, w.getPass());
			ResultSet rs=ps.executeQuery();
			//int accno=0;
			//String password="";
			int t_amt=0;
			while(rs.next())
			{
				//accno=rs.getInt(1);
				//password=rs.getString(3);
				t_amt=rs.getInt(1);
			}
			if(w.getW_amt()<t_amt)
			{
				ps=con.prepareStatement("update customer set amt=? where acno=? and pass=?");
				ps.setInt(1, t_amt-w.getW_amt());
				ps.setInt(2,w.getAcno() );
				ps.setString(3, w.getPass());
				int n=ps.executeUpdate();
				if(n==1)
				{
					int r_bal=t_amt-w.getW_amt();
					result="true"+" "+r_bal;
				}
				else
				{
					result="false"+" "+0;
				}
			}
			else
			{
				result="not"+" "+0;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			result="false"+" "+0;
		}
		return result;
	}
}
