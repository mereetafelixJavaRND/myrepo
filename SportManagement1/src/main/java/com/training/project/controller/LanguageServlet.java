package com.training.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.project.service.CountryService;
import com.training.project.service.CountryServiceImpl;


public class LanguageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int langId = Integer.parseInt(request.getParameter("langid"));
		HttpSession session = request.getSession(false);
		CountryService countryService = new CountryServiceImpl();

		//Get language object from db

		List list = countryService.getLangObj(langId);
		session.setAttribute("list", list);
		request.getRequestDispatcher("lang_display.jsp").forward(request, response);

	}

}
