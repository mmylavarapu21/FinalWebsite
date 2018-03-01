package com.soap;

import java.sql.Connection;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.dataLayer.jdbc.DBConnection;
import com.dataLayer.jdbc.UsersTable;


@WebService 
public class LoginSoap {

	public String isUserValid(String userid, String password) throws Exception
	{
		Connection conn=DBConnection.getDBConnection("mysql");
		try{
		conn.setAutoCommit(false);
		boolean isExists = UsersTable.validateLogin(userid, password, conn);
		if(isExists)
		{
			return "true";
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
		return "false";
	}
	
}
