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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Model.logout(request);
		Model.loginCheck(request);
		
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Model.login(request);
		Model.loginCheck(request);
		
		HttpSession hs = request.getSession();
		String a = (String) hs.getAttribute("redirectURI");
		System.out.println(a);
		request.setAttribute("contentPage", a);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
