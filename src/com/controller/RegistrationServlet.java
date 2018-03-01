package com.controller;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dataLayer.jdbc.UsersTable;
import com.model.Authenticate;
import com.model.Register;

public class RegistrationServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{
		try{
 
			String uid=req.getParameter("uid1");
			String password=req.getParameter("pwd");
			String email=req.getParameter("email");
			String tn=req.getParameter("tn");
			res.setContentType("application/json");
			Register r = new Register();
			boolean temp = r.processUidExist(uid); 
			if(temp == false)
			{
				r.addUser(uid, password, email, tn);
				res.sendRedirect("Login.html");				
			}else
			{
				res.sendRedirect("Error.html");				
			}
			PrintWriter pw=res.getWriter();
			pw.print(temp);
			pw.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	} 
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		doGet(req, res);
	}
	
}
