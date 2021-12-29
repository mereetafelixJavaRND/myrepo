package com.training.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.training.project.model.User;
import com.training.project.service.UserService;
import com.training.project.service.UserServiceImpl;


public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		UserService service = new UserServiceImpl();
		User user = new User();
		
		//Setting the values to user object
		
		user.setName(request.getParameter("name"));
		user.setPhone(Long.parseLong(request.getParameter("phone")));
		user.setEmail(request.getParameter("email"));
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		try {
			
				int register = service.register(user); // Registering the details of new user
				if(register != 0) {
					
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
					out.println("<h2>You are successfully Registered !!</h2> Please Login");
					
				}
				
		} catch (SQLException e) {
				
				e.printStackTrace();
		}
				
	}
	
}
