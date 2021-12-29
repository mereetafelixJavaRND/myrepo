package com.training.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.training.project.model.User;
import com.training.project.service.UserService;
import com.training.project.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        UserService service = new UserServiceImpl();
		try {
			User user = service.authenticate(username, password);//Authenticate whether the user is valid
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if (user != null) {
				
					RequestDispatcher rd = request.getRequestDispatcher("product-detail.jsp");
					rd.include(request, response);
					
			} else {
				
				    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				    rd.include(request, response);
				    out.println("<h3>Incorrect credentials!!</h3>");
					
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

	}
 
}


