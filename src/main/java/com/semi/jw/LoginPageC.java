package com.semi.jw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginPageC")
public class LoginPageC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Model.loginCheck(request);

//		String watchingPage = request.getHeader("Referer");
//		System.out.println("LoginPageC watchingPage = " + watchingPage);
//
//		if (watchingPage.equals("http://localhost/SemiProject/LoginPageC")
//				|| watchingPage.equals("http://localhost/SemiProject/LoginC")) {
//			watchingPage = null;
//		} else {
//			request.getSession().setAttribute("watchingPage", watchingPage);
//		}

		request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
