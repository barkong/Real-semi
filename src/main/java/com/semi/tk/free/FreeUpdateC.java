package com.semi.tk.free;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.jw.Model;
import com.semi.tk.review.ReviewDAO;

@WebServlet("/FreeUpdateC")
public class FreeUpdateC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Model.loginCheck(request)) {
			FreeDAO.getFree(request);
			
			FreeDAO.getFreesB(request);
			FreeDAO.getFreesC(request);
			ReviewDAO.getReviewsB(request);
			ReviewDAO.getReviewsC(request);
			
			request.setAttribute("contentPage", "jsp/tk/free/free_update.jsp");
		} else {
			// href로 넘어와서 request.getHeader("Referer") 못씀
			String watchingPage = request.getRequestURL().toString();
			String param = request.getQueryString();
			if (request.getQueryString() != null) {
				watchingPage = watchingPage + "?" + param;
			}
			request.getSession().setAttribute("watchingPage", watchingPage);
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Model.loginCheck(request)) {
			FreeDAO.updateFree(request);
			FreeDAO.getFree(request);
			FreeDAO.getAllFree(request);
			FreeDAO.paging(1, request);
			
			FreeDAO.getFreesB(request);
			FreeDAO.getFreesC(request);
			ReviewDAO.getReviewsB(request);
			ReviewDAO.getReviewsC(request);
			
			request.setAttribute("contentPage", "jsp/tk/free/free_detail.jsp");
		} else {
//			String watchingPage = request.getRequestURL().toString();
//			String param = request.getQueryString();
//			if (request.getQueryString() != null) {
//				watchingPage = watchingPage + "?" + param; // 수정할 글의 번호도 있으니까
//			}
//			System.out.println("watchingPage : " + watchingPage);
//			System.out.println("param : " + param);
//			onclick="location.href='FreeUpdateC?no=${param.no} 로 넘어왔기 때문에, 위처럼 써도 좋다.
//			다만, 수정완료를 눌렀을때 param도 같이 넘겨줘야 로그인후 그 수정하던 페이지로 돌아간다.
//			그런데 잘보면, 수정완료버튼을 누른다는 것은 form-action에 해당한다. 그러므로 아래처럼 써버려도 된다.
			String watchingPage = request.getHeader("Referer");
			request.getSession().setAttribute("watchingPage", watchingPage);
			request.getSession().setAttribute("watchingPage", watchingPage);
			
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
