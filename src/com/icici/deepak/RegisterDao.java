package com.icici.deepak;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.ResultSet;

public class RegisterDao {
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
	
	public String insert(Customer cm)
	{
		loadDriver(driver);
		Connection con=getConnection();
		String result="true";
		int accno=0;
		
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into customer(name,pass,addr,mob,amt,created_at)"+"values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, cm.getName());
			ps.setString(2, cm.getPass());
			ps.setString(3, cm.getAddr());
			ps.setString(4, cm.getMob());
			ps.setInt(5, cm.getAmt());
			ps.setTimestamp(6, new Timestamp(new Date().getTime()));
			ps.executeUpdate();
			ResultSet rs=ps.getGeneratedKeys();
			rs.next();
			accno=rs.getInt(1);
		}catch(SQLException e)
		{
			e.printStackTrace();
			result="false";
		}
		return result+" "+accno;
	}

}
