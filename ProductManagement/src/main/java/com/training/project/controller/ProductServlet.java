package com.training.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.training.project.model.Product;
import com.training.project.model.User;
import com.training.project.service.UserService;
import com.training.project.service.UserServiceImpl;

public class ProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		UserService service = new UserServiceImpl();
		Product product = new Product();
		
		//Set the values of product in the product object
		
		product.setProductName(request.getParameter("pname"));
		product.setPrice(Integer.parseInt(request.getParameter("price")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		product.setVendor(request.getParameter("vendor"));
		product.setWarranty(Integer.parseInt(request.getParameter("warranty")));
		User user = (User) session.getAttribute("user");
		String username = user.getUserName();
		product.setUserName(username);
		try {
			
			int add = service.addProduct(product);// Add the particular product into database
			if(add != 0) {
				
				session.setAttribute("product", product); 
				request.getRequestDispatcher("report").forward(request, response);	
				
			}
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
	}

}
