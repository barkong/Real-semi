package com.semi.movie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;

@WebServlet("/MovieSearchC")
public class MovieSearchC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Model.loginCheck(request);

		if (request.getParameter("movie") != "") {
			NaverMovie.getMovie(request);
			request.setAttribute("contentPage", "jsp/sh/movieSearchResult.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
