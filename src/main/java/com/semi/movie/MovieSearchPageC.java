package com.semi.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.news.NaverNews;

@WebServlet("/MovieSearchPageC")
public class MovieSearchPageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int p = Integer.parseInt(request.getParameter("p"));

		NaverMovie.getNM().getMovie(request);
		NaverMovie.getNM().paging(p, request);
		
		request.setAttribute("contentPage", "jsp/sh/movieSearchResult.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
