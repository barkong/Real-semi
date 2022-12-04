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
			// href로 넘어와서 request.getHeader("Referer") 못씀
			// 그런데 이러면, 로그인하자마자 삭제가 되어버림;;
			// 그래서 일단 상세보기 보여주는 곳으로 바꿔줌
			String watchingPage = request.getRequestURL().toString();
			watchingPage = watchingPage.replace("ReviewDelC", "ReviewDetailC");
			String param = request.getQueryString();
			if (request.getQueryString() != null) {
				watchingPage = watchingPage + "?" + param;
			}
			request.getSession().setAttribute("watchingPage", watchingPage);
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
