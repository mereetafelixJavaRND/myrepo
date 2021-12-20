package com.training.project.controller;

import java.io.IOException;
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

public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		UserService service = new UserServiceImpl();
		try {
			Product product1 = new Product();
			
			//Set the details of product into product1 object for updation
			
			product1.setProductId(Integer.parseInt(request.getParameter("pid")));
			product1.setProductName(request.getParameter("pname"));
			product1.setPrice(Integer.parseInt(request.getParameter("price")));
			product1.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			product1.setVendor(request.getParameter("vendor"));
			product1.setWarranty(Integer.parseInt(request.getParameter("warranty")));
			product1.setUserName(user.getUserName());
			int update = service.updateProduct(product1); //Update the product details
			if(update != 0) {
				
				request.getRequestDispatcher("report").forward(request, response);	
				
			}
			
		 } catch (SQLException e) {
			 
			e.printStackTrace();
			
		}
				  
	}

}
