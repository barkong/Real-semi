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
			request.setAttribute("contentPage", "로그인하세요");
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
			request.setAttribute("contentPage", "로그인하세요");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
