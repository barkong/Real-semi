package com.semi.jw;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateAccountC")
public class UpdateAccountC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.wathingPage(request);

		if (Model.loginCheck(request)) {
			request.setAttribute("contentPage", "jsp/jw/updateInfo.jsp");
		} else {
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.wathingPage(request);

		if (Model.loginCheck(request)) {
			Model.updateInfo(request);
			Model.login(request);
			request.setAttribute("contentPage", "jsp/jw/info.jsp");
		} else {
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
