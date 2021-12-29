package com.training.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);//if a session is created it will retain on giving false
		session.invalidate();  // Invalidate the session created by a particular user
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
		out.println("<h2>You are successfully Logged out!!</h2>");
		
	}

}
