package com.dataLayer.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersTable {
		
		
		public static void insertUser(String userid,String password, String email,String tn,Connection conn) throws  SQLException
	    {
	        PreparedStatement stmt = null;
	        try
	        {
	            stmt = conn.prepareStatement("insert into customer (userid,password,email,phone) values (?,?,?,? )");
	            stmt.setString(1, userid);
	            stmt.setString(2, password);
	            stmt.setString(3, email);
	            stmt.setString(4, tn);
	            int recordImpacted=stmt.executeUpdate();
	            System.out.println("total inserts:"+recordImpacted);
	        }
	        catch (SQLException e)
	        {
	        	e.printStackTrace();
	        	throw e;
	        }
	        finally
	        {
	            try{
	            	stmt.close();} catch(SQLException s){}
	        }
	    }
		
		
		public static boolean Useridexist(String uid,Connection conn) throws SQLException 
	    {
			
	        PreparedStatement stmt = null;
	        ResultSet resultSet = null;
	        String result="admin";
	        try
	        {
	        	stmt = conn.prepareStatement("select userid from customer");
	            //stmt.setString(1, userid);
	            resultSet = stmt.executeQuery();
	            
	            while (resultSet.next() && !(result.equalsIgnoreCase(uid)))
	            {
	            	result=resultSet.getString("userid");
	            }
	            if(result.equalsIgnoreCase(uid))
		        {
		        	return true;
		        }
		        else
		        {
		        return false;
		        }
	            
	        }
	        catch (SQLException e)
	        {
	        	System.out.println("Exception occured");
	        	e.printStackTrace();
	            throw e;
	        }
	        finally
	        {
	        	try{
	        		resultSet.close(); } catch(SQLException s){}
	            try{
	            	stmt.close();} catch(SQLException s){}
	        }
	        
	    }


		
		//updateOrder("john","new_pasword")
		public static void updatePwd(String uid,String pwd, Connection conn) throws  SQLException
	    {
	        PreparedStatement stmt = null;
	        try
	        {
	            stmt = conn.prepareStatement("update customer set password=? where userid=?");
	            stmt.setString(1, pwd);
	            stmt.setString(2, uid);
	            stmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	        	e.printStackTrace();
	        	throw e;
	        }
	        finally
	        {
	            try{
	            	stmt.close();} catch(SQLException s){}
	        }
	     
	    }
		

		public static void deleteUser(String delUid,Connection conn) throws  SQLException
	    {
	        PreparedStatement stmt = null;
	        try
	        {
	            stmt = conn.prepareStatement("delete from customer where userid=?");
	            stmt.setString(1, delUid);
	            int rowsupdated=stmt.executeUpdate();
	        }
	        catch (SQLException e)
	        {
	        	e.printStackTrace();
	        	throw e;
	        }
	        finally
	        {
	            try{
	            	stmt.close();} catch(SQLException s){}
	        }
	     
	    }
		
		public static String getEmail4Userid(String userid,Connection conn) throws SQLException 
	    {
			//date="03/20/15"
	        PreparedStatement stmt = null;
	        ResultSet resultSet = null;
	        String result=null;
	        try
	        {
	        	stmt = conn.prepareStatement("select email from customer where userid=?");
	            stmt.setString(1, userid);
	            resultSet = stmt.executeQuery();
	            
	            while (resultSet.next())
	            {
	            	result=resultSet.getString("email");
	            }
	            
	        }
	        catch (SQLException e)
	        {
	        	System.out.println("Exception occured");
	        	e.printStackTrace();
	            throw e;
	        }
	        finally
	        {
	        	try{
	        		resultSet.close(); } catch(SQLException s){}
	            try{
	            	stmt.close();} catch(SQLException s){}
	        }
	        
	        return result;
	    }

	

		public static boolean validateLogin(String userid,String pwd,Connection conn) throws SQLException 
	    {
			PreparedStatement stmt = null;
	        ResultSet resultSet = null;
	        boolean result=false;
	        try
	        {
	        	stmt = conn.prepareStatement("select password from customer where userid=? and password=?");
	        	stmt.setString(1, userid);
	        	stmt.setString(2, pwd);
	            resultSet = stmt.executeQuery();
	            if(resultSet.next())
	            	return true;
	            else
	            	return false;
	        }
	        catch (SQLException e)
	        {
	        	System.out.println("Exception occured");
	        	e.printStackTrace();
	            throw e;
	        }
	        finally
	        {
	        	try{
	        		resultSet.close(); } catch(SQLException s){}
	            try{
	            	stmt.close();} catch(SQLException s){}
	        }
	        
	    }
		
				
}
