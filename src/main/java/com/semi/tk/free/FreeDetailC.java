package com.semi.tk.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;

@WebServlet("/FreeDetailC")
public class FreeDetailC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String watchingPage = request.getRequestURL().toString();
		String param = request.getQueryString();
		if (request.getQueryString() != null) {
			watchingPage = watchingPage + "?" + param; // 수정할 글의 번호도 있으니까
		}
		request.getSession().setAttribute("watchingPage", watchingPage);
		
		Model.loginCheck(request);
		
		if (FreeDAO.ipCheck(request)) {
			FreeDAO.count(request);
		}
		
		FreeDAO.getFree(request);
		FreeDAO.getAllFree(request);
		FreeDAO.paging(1, request);
		request.getRequestURL();
		request.setAttribute("contentPage", "jsp/tk/free/free_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
