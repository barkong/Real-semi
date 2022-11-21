package com.semi.tk.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.login.Model;


@WebServlet("/FreePageC")
public class FreePageC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Model.loginCheck(request);
		
		int p = Integer.parseInt(request.getParameter("p"));
		FreeDAO.getAllFree(request);
		FreeDAO.paging(p, request);
		
		request.setAttribute("contentPage", "jsp/tk/free/free.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
