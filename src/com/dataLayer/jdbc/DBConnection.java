package com.dataLayer.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection {
	
	public static Connection getDBConnection(String db) throws Exception
	{
		Connection conn =null;
		try{
			  Class.forName("com.mysql.jdbc.Driver");
			  conn = DriverManager.getConnection("jdbc:mysql://localhost/login","root","Manikanta4"); 
		  return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}

}
