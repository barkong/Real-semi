package com.semi.tk.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;

@WebServlet("/ReviewRegC")
public class ReviewRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.loginCheck(request);
		request.setAttribute("contentPage", "jsp/tk/review/review_reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.loginCheck(request);
		ReviewDAO.regReview(request);
		ReviewDAO.getAllReview(request);
		ReviewDAO.paging(1, request);
		
		request.setAttribute("contentPage", "jsp/tk/review/review.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}