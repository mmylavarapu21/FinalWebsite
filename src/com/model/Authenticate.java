package com.model;

import java.sql.Connection;

import com.dataLayer.jdbc.DBConnection;
import com.dataLayer.jdbc.UsersTable;

public class Authenticate {
 
	public Authenticate() throws Exception
	{
		
	}
	
	public boolean isUserValid(String userid, String password) throws Exception
	{
		Connection conn=DBConnection.getDBConnection("mysql");
		try{
		conn.setAutoCommit(false);
		boolean isExists = UsersTable.validateLogin(userid, password, conn);
		if(isExists)
		{
			return true;
		}
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
		return false;
	}
		
			
		
	}
	
