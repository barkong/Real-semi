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
		
		Model.loginCheck(request);

		HttpSession hs = request.getSession();
		String watchingPage = (String) hs.getAttribute("watchingPage");
		System.out.println("LoginC watchingPage = " + watchingPage);

//		if (watchingPage.contains(".j")) {
//			request.setAttribute("contentPage", watchingPage);
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		} else {
//			response.sendRedirect(watchingPage);
//		}
		
		if (watchingPage == null || watchingPage.equals("http://localhost/SemiProject/LoginC")) {
			request.setAttribute("contentPage", "home.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendRedirect(watchingPage);
		}
	}
}
