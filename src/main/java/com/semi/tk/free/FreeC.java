package com.semi.tk.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;

@WebServlet("/FreeC")
public class FreeC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String watchingPage = request.getRequestURL().toString();
		String param = request.getQueryString();
		if (request.getQueryString() != null) {
			watchingPage = watchingPage + "?" + param;
		}
		request.getSession().setAttribute("watchingPage", watchingPage);

		Model.loginCheck(request);
		FreeDAO.getAllFree(request);
		FreeDAO.paging(1, request);
		request.setAttribute("contentPage", "jsp/tk/free/free.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
