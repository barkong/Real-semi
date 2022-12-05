package com.semi.tk.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;
import com.semi.tk.free.FreeDAO;

@WebServlet("/ReviewSC")
public class ReviewSC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String watchingPage = request.getRequestURL().toString();
		String param = request.getQueryString();
		if (request.getQueryString() != null) {
			watchingPage = watchingPage + "?" + param;
		}
		request.getSession().setAttribute("watchingPage", watchingPage);

		Model.loginCheck(request);
		
		String sf = null;
		String st = null;
		ReviewDAO.getSearch(sf, st, request);
		ReviewDAO.pagingS(1, request);

		FreeDAO.getFreesB(request);
		FreeDAO.getFreesC(request);
		ReviewDAO.getReviewsB(request);
		ReviewDAO.getReviewsC(request);

		request.setAttribute("contentPage", "jsp/tk/review/review_search.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
