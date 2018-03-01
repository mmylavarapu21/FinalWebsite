package com.dataLayer.jdbc;
import java.sql.Connection;

import com.model.Authenticate;
import com.model.Register;


public class TestDBCalls {

	public static void main(String args[]) throws Exception
	{
		
		Connection conn=DBConnection.getDBConnection("mysql");
		try{
		conn.setAutoCommit(false);
	Authenticate a = new Authenticate();
	Register r = new Register();
	UsersTable.validateLogin("mani123", "mani1!", conn);
	System.out.println(r.processUidExist("a"));
	System.out.println(a.isUserValid("mani123", "mani1!"));
	//UsersTable.insertUser("a21234561", "b", "a@a.com", "1234", conn);
	System.out.println(UsersTable.Useridexist("dfgdfghjgfdfghbhgfdgh", conn));
		conn.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			conn.rollback();
		}
		finally{
			try{
				conn.close();
			}catch(Exception e){}
		}
		
	}
}
