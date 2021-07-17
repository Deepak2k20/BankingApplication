package com.icici.deepak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferDao {
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
	
	public String transfer(Transfer t)
	{
		loadDriver(driver);
		Connection con=getConnection();
		String result="";
		try
		{
			PreparedStatement ps=con.prepareStatement("select amt from customer where acno=? and name=? and pass=?");
			ps.setInt(1, t.getAcno());
			ps.setString(2, t.getUname());
			ps.setString(3, t.getPass());
			ResultSet rs=ps.executeQuery();
			//int accno=0;
			//String password="";
			int amt_in_transferable_account=0;
			while(rs.next())
			{
				//accno=rs.getInt(1);
				//password=rs.getString(3);
				amt_in_transferable_account=rs.getInt(1);
			}
			ps=con.prepareStatement("select acno,amt from customer where acno=?");
			ps.setInt(1,t.getT_acno());
			rs=ps.executeQuery();
			int amt_in_transferred_account=0;
			int acno=0;
			while(rs.next())
			{
				acno=rs.getInt(1);
				amt_in_transferred_account=rs.getInt(2);
				
			}
			
		if(acno==t.getT_acno())
		{
			
			
			if(t.getT_amt()<amt_in_transferable_account)
			{
				ps=con.prepareStatement("update customer set amt=? where acno=? and pass=?");
				ps.setInt(1, amt_in_transferable_account-t.getT_amt());
				ps.setInt(2,t.getAcno() );
				ps.setString(3, t.getPass());
				ps.executeUpdate();
				ps=con.prepareStatement("update customer set amt=? where acno=? ");
				ps.setInt(1,amt_in_transferred_account+t.getT_amt());
				ps.setInt(2,t.getT_acno());
				
				//ps.addBatch();
				int n=ps.executeUpdate();
				
				if(n==1)
				{
					int r_bal=amt_in_transferable_account-t.getT_amt();
					//t_amt-w.getW_amt();
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
		}
		else
		{
			result="false"+" "+0;
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
			result="false"+" "+0;
		}
		return result;
	}


}
