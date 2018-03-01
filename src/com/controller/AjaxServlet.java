package com.controller;
import java.io.PrintWriter;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.model.Register;
 
public class AjaxServlet extends HttpServlet{
	 
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	{ 
		try{

			String uid=req.getParameter("uid1");
	 		res.setContentType("application/json");
			
			Register r=new Register();
			String jsonResponse = r.jsonUidExist(uid);
			
			PrintWriter pw=res.getWriter();
			pw.print(jsonResponse);
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
