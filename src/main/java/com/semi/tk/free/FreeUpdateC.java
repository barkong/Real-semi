package com.semi.tk.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.Model;


@WebServlet("/FreeUpdateC")
public class FreeUpdateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.loginCheck(request);
		FreeDAO.getFree(request);
		request.setAttribute("contentPage", "jsp/tk/free/free_update.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Model.loginCheck(request);
		FreeDAO.updateFree(request);
		FreeDAO.getFree(request);
		request.setAttribute("contentPage", "jsp/tk/free/free_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
