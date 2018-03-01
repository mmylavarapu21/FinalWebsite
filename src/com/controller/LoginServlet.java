package com.controller;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Authenticate;
		public class LoginServlet extends HttpServlet{
			
			
		public void doGet(HttpServletRequest req,HttpServletResponse res)
		{
			String uid=req.getParameter("uid");
			String password=req.getParameter("pwd");
			Authenticate a;
			try { 
				a = new Authenticate();
				 boolean result=a.isUserValid(uid,password);
					
					if(result)
						res.sendRedirect("Login.html");
					else
						res.sendRedirect("Error.html");
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void doPost(HttpServletRequest req,HttpServletResponse res)
		{
			doGet(req, res);
		}
		
	}



