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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Model.loginCheck(request);
<<<<<<< HEAD
		if(request.getParameter("movie")==null) {
			System.out.println("aa");
			request.setAttribute("contentPage", "jsp/sh/movieSearch.jsp");
		}else {
=======
		if(request.getParameter("movie")!="") {
			
			
>>>>>>> dc28a1f2335a2b553c1766d51b142e6614203a33
			NaverMovie.getMovie(request);
			request.setAttribute("contentPage", "jsp/sh/movieSearchResult.jsp");
		
		}else {
			request.setAttribute("contentPage", "home.jsp");
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
