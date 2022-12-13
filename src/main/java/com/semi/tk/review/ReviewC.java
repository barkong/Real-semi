package com.semi.tk.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;
import com.semi.tk.free.FreeDAO;

@WebServlet("/ReviewC")
public class ReviewC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.wathingPage(request);

		Model.loginCheck(request);
		
		ReviewDAO.getAllReview(request);
		ReviewDAO.paging(1, request);
		
		ReviewDAO.getReviewsB(request);
		ReviewDAO.getReviewsC(request);
		FreeDAO.getFreesB(request);
		FreeDAO.getFreesC(request);
		
		
		request.setAttribute("contentPage", "jsp/tk/review/review.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
