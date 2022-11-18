package com.semi.rec;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;


@WebServlet("/RecommendMovieC")
public class RecommendMovieC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Model.loginCheck(request);
		NaverMovie.main(request);
		request.setAttribute("contentPage", "recommendMov/recMovie.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
