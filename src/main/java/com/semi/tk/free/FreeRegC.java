package com.semi.tk.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;

@WebServlet("/FreeRegC")
public class FreeRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Model.loginCheck(request)) {
			request.setAttribute("contentPage", "jsp/tk/free/free_reg.jsp");
		} else {
			// href로 넘어와서 request.getHeader("Referer") 못씀
			String watchingPage = request.getRequestURL().toString();
			String param = request.getQueryString();
			if (request.getQueryString() != null) {
				watchingPage = watchingPage + "?" + param; // 수정할 글의 번호도 있으니까
			}
			System.out.println("watchingPage : " + watchingPage);
			System.out.println("param : " + param);
			request.getSession().setAttribute("watchingPage", watchingPage);

			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Model.loginCheck(request)) {
			FreeDAO.regFree(request);
			FreeDAO.getAllFree(request);
			FreeDAO.paging(1, request);
			request.setAttribute("contentPage", "jsp/tk/free/free.jsp");
		} else {
			// form-action으로 넘어왔기 때문에, LoginPageC의 request.getHeader("Referer")에 맡기면됨
			// 다만, 수정은 다르다. 수정은 그 글의 번호까지 받아서 와야하기때문
			String watchingPage = request.getRequestURL().toString();
			String param = request.getQueryString();
			if (request.getQueryString() != null) {
				watchingPage = watchingPage + "?" + param; // 수정할 글의 번호도 있으니까
			}
			System.out.println("watchingPage : " + watchingPage);
			System.out.println("param : " + param);
			request.getSession().setAttribute("watchingPage", watchingPage);
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
