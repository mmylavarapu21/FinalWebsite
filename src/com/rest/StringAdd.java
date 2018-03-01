package com.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/add")
public class StringAdd {
	@Path("{num1}/{num2}")
	@GET
	@Produces({MediaType.TEXT_HTML})

	public String stringConcatination(@PathParam("num1")String a, @PathParam("num2")String b)
	{
		a = a+b;
		return a;
	}
	
}
