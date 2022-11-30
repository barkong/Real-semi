package com.semi.mybbs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;

@WebServlet("/MyBbsFreeC")
public class MyBbsFreeC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Model.loginCheck(request)) {
			MyBbsDAO.getAllBbsFree(request);
			MyBbsDAO.paging(1, request);
			request.setAttribute("contentPage", "jsp/tk/mybbs/myBbsFree.jsp");
		} else {
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
	}

}
