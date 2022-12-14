package com.bitlabs;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet{
  public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {

		String driver=getServletContext().getInitParameter("Driver");
		System.out.println(driver);
		
		RequestDispatcher rd=req.getRequestDispatcher("/index.html");
		
			rd.forward(req, res);
		
	}

}
