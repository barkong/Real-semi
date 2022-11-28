package com.semi.news;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;


@WebServlet("/MovieNewsC")
public class MovieNewsC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model.loginCheck(request);
		
//		NaverNews.getNa().getNews(request);
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		out.print(NaverNews.getNa().getNews(request));
		
		
//		NaverNews.getNa().paging(1, request); 
		
		request.setAttribute("contentPage", "jsp/sh/newsResult.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
