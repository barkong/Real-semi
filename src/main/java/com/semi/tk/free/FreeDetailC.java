package com.semi.tk.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;
import com.semi.tk.review.ReviewDAO;

@WebServlet("/FreeDetailC")
public class FreeDetailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Model.wathingPage(request);		
		Model.loginCheck(request);
		
		if (FreeDAO.ipCheck(request)) {
			FreeDAO.count(request);
		}
		
		FreeDAO.getFree(request);
		FreeDAO.getAllFree(request);
		FreeDAO.paging(1, request);
		
		FreeDAO.getFreesB(request);
		FreeDAO.getFreesC(request);
		ReviewDAO.getReviewsB(request);
		ReviewDAO.getReviewsC(request);
		
		request.getRequestURL();
		request.setAttribute("contentPage", "jsp/tk/free/free_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
