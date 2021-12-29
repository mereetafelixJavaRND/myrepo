package com.training.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.training.project.model.Product;
import com.training.project.model.User;
import com.training.project.service.UserService;
import com.training.project.service.UserServiceImpl;

public class ReportServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
	    String username = user.getUserName();
		UserService service = new UserServiceImpl();  
		try {
				
			List<Product> productList = service.getAllProduct(username); //Get all the products added by a particular user
			session.setAttribute("productList", productList);
			request.getRequestDispatcher("report.jsp").forward(request, response);
			
		} catch (SQLException e1) {
				
				e1.printStackTrace();
				
		}
		 
	}

}
