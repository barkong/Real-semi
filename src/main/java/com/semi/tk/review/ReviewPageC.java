package com.semi.tk.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;
import com.semi.tk.free.FreeDAO;

@WebServlet("/ReviewPageC")
public class ReviewPageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.loginCheck(request);
		
		int p = Integer.parseInt(request.getParameter("p"));
		ReviewDAO.getAllReview(request);
		ReviewDAO.paging(p, request);
		
		FreeDAO.getFreesB(request);
		FreeDAO.getFreesC(request);
		ReviewDAO.getReviewsB(request);
		ReviewDAO.getReviewsC(request);
		
		request.setAttribute("contentPage", "jsp/tk/review/review.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
