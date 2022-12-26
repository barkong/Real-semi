package com.semi.jw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginC")
public class LoginC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Model.logout(request);
		Model.loginCheck(request);
		Model.wathingPage(request);

		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Model.login(request);
		if (Model.loginCheck(request)) {
			String watchingPage = (String) request.getSession().getAttribute("watchingPage");
			System.out.println(watchingPage);
			response.sendRedirect(watchingPage);
		} else {
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
//		request.getRequestDispatcher("index.jsp").forward(request, response);

//		if (Model.loginCheck(request)) {
//			String watchingPage1 = request.getRequestURL().toString();
//			String watchingPage = (String) request.getSession().getAttribute("watchingPage");
//			
//			System.out.println(watchingPage);
//
//			if (watchingPage == null || watchingPage.equals(watchingPage1)) {
//				request.setAttribute("contentPage", "home.jsp");
//				request.getRequestDispatcher("index.jsp").forward(request, response);
//			} else {
//				response.sendRedirect(watchingPage);
//			}
//		} else {
//			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}

	}
}
