package com.model;


import java.sql.Connection;
import com.dataLayer.jdbc.DBConnection;
import com.dataLayer.jdbc.UsersTable;

	public class Register {
	 
		public Register() throws Exception
		{
			
		}

		public boolean processUidExist(String uid)throws Exception {
			Connection conn=DBConnection.getDBConnection("mysql");
			try{
			//conn.setAutoCommit(false);
			boolean isExists = UsersTable.Useridexist(uid,conn);
			if(isExists)
			{
				return true;
			}
			else
			{
				return false;
				
			}
			
			//conn.commit();
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
		
		
		public void addUser(String userid,String password,String email,String tn) throws Exception
		{
			Connection conn=DBConnection.getDBConnection("mysql");
			try{
			conn.setAutoCommit(false);
			UsersTable.insertUser(userid, password, email, tn, conn);
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
		
		public String jsonUidExist(String uid)throws Exception {
			Connection conn=DBConnection.getDBConnection("mysql");
			String jsonResponse="";
			
			try{
			//conn.setAutoCommit(false);
			boolean isExists = UsersTable.Useridexist(uid,conn);
			if(isExists)
			{
				jsonResponse="{ \n "+
						"	\"isUserExist\":\"true\" \n "+
						"}";
				return jsonResponse;
			}
			else
			{
				jsonResponse="{ \n "+
						"	\"isUserExist\":\"false\" \n "+
						"}";
				return jsonResponse;
				
			}
			
			//conn.commit();
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
			return jsonResponse;
		}
		
		
		
	}

	
	

