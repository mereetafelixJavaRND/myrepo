package com.training.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.project.model.Country;
import com.training.project.service.CountryService;
import com.training.project.service.CountryServiceImpl;


public class CountryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(false);
		CountryService countryService = new CountryServiceImpl();
		Country country = countryService.getCountryObj(id);
		session.setAttribute("country", country);
		request.getRequestDispatcher("display.jsp").forward(request, response);

	}


}
