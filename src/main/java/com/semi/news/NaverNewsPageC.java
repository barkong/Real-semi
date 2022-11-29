package com.semi.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NaverNewsPageC")
public class NaverNewsPageC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int p = Integer.parseInt(request.getParameter("p"));

		NaverNews.getNa().getNews(request);
		NaverNews.getNa().paging(p, request);
		
		request.setAttribute("contentPage", "jsp/sh/newsResult.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
