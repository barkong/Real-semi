package com.semi.mybbs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;

@WebServlet("/MyBbsFC")
public class MyBbsFC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.wathingPage(request);

		if (Model.loginCheck(request)) {
			MyBbsDAO.getAllBbsF(request);
			MyBbsDAO.pagingF(1, request);
			request.setAttribute("contentPage", "jsp/tk/mybbs/myBbsF.jsp");
		} else {
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
