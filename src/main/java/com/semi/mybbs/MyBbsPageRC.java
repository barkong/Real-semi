package com.semi.mybbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;

@WebServlet("/MyBbsPageRC")
public class MyBbsPageRC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Model.loginCheck(request);

		int p = Integer.parseInt(request.getParameter("p"));
		MyBbsDAO.getAllBbsR(request);
		MyBbsDAO.pagingR(p, request);

		request.setAttribute("contentPage", "jsp/tk/mybbs/myBbsR.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
