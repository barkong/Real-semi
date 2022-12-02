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

		String watchingPage = request.getRequestURL().toString();
		System.out.println();
		System.out.println(watchingPage);
		System.out.println();
		String param = request.getQueryString();
		if (request.getQueryString() != null) {
			watchingPage = watchingPage + "?" + param;
		}
		System.out.println("watchingPage : " + watchingPage);
		System.out.println("param : " + param);
		request.getSession().setAttribute("watchingPage", watchingPage);

		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Model.login(request);

		if (Model.loginCheck(request)) {
			String watchingPage1 = request.getRequestURL().toString();
			HttpSession hs = request.getSession();
			String watchingPage = (String) hs.getAttribute("watchingPage");
			System.out.println("LoginC watchingPage = " + watchingPage);

			if (watchingPage == null || watchingPage.equals(watchingPage1)) {
				request.setAttribute("contentPage", "home.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				response.sendRedirect(watchingPage);
			}
		} else {
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}
}
