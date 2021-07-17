package com.icici.deepak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DetailsDao {
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/bank";
	private String uname="root";
	private String pass="deepak@123";
	Timestamp created_at;
	
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
	
	public String details(Details d)
	{
		loadDriver(driver);
		Connection con=getConnection();
		String result="";
		int acno=0;
		String pass="";
		String name="";
		String mob="";
		String address="";
		int amt=0;
		
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from customer where acno=? and pass=?");
			ps.setInt(1, d.getAcno());
			//ps.setString(2, d.getUname());
			ps.setString(2,d.getPass());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				acno=rs.getInt(1);
				name=rs.getString(2);
				pass=rs.getString(3);
				address=rs.getString(4);
				mob=rs.getString(5);
				amt=rs.getInt(6);
				created_at=rs.getTimestamp(7);
			}
			int length=pass.length();
			String pass_="XXXXXXXXXXXXXXXXXXXXXX";
			pass=pass_.substring(0, length);
			String mob_="XXXXXX";
			mob=mob_+mob.substring(6, mob.length());
			
			result="Your Account Number is: "+acno+","+"Name : "+name+","+"Password : "+pass+","+"Address :"+address+","+"Mobile No : "+mob+","+"Available Balance is : "+amt+","+"Account Opened at: "+created_at;
			//result=acno+name+pass+address+mob+amt;
			
			/*if(String.valueOf(acno).equals(String.valueOf(d.getAcno()))&&pass.equals(d.getPass()))
			{
				result="true"+" "+result;
			}
			else
			{
				result="false";
			}*/
			
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			result="false";
		}
		

			
			
			
		
		return result;
	}

}
