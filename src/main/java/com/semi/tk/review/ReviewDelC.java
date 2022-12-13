package com.semi.tk.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;
import com.semi.tk.free.FreeDAO;

@WebServlet("/ReviewDelC")
public class ReviewDelC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.wathingPage(request);

		if (Model.loginCheck(request)) {
			ReviewDAO.deleteReview(request);
			ReviewDAO.getAllReview(request);
			ReviewDAO.paging(1, request);
			
			FreeDAO.getFreesB(request);
			FreeDAO.getFreesC(request);
			ReviewDAO.getReviewsB(request);
			ReviewDAO.getReviewsC(request);
			
			request.setAttribute("contentPage", "jsp/tk/review/review.jsp");
		} else {
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
