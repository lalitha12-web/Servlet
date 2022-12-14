package com.bitlabs;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertController extends HttpServlet {
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
	
		String driver=getServletContext().getInitParameter("Driver");
		System.out.println(driver);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("/register.html");
		rd.forward(request, response);
		String fname=request.getParameter("firstname");
		String mname=request.getParameter("middlename");
		String lname=request.getParameter("lastname");
		String course=request.getParameter("course");
		String gender=request.getParameter("gender");
		long phone=Long.parseLong(request.getParameter("phone")) ;
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pass");
		String repwd=request.getParameter("repass");
		
		
		Registration reg=new Registration();
		
		reg.setFirstname(fname);
		reg.setMiddlename(mname);
		reg.setLastname(lname);
		reg.setCourse(course);
		reg.setGender(gender);
		reg.setPhoneno(phone);
		reg.setAddress(address);
		reg.setEmail(email);
		reg.setPassword(pwd);
		reg.setRepwd(repwd);
		PrintWriter out=response.getWriter();
		DaoImpl dao=new DaoImpl();
		int i=dao.register(reg);
		if(i!=0) {
			RequestDispatcher rd2=request.getRequestDispatcher("/success.html");
			rd2.forward(request, response);
		}
		else {
			RequestDispatcher rd1=request.getRequestDispatcher("/register.html");
			rd1.forward(request, response);
			out.print("<body>not done</body>");

		}
//		
		
	}
}
