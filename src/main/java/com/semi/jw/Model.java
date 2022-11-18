package com.semi.jw;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Model {

	public static void login(HttpServletRequest request) {

		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from semi_account where a_id=?";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt = DBManager.connect().prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (userPw.equals(rs.getString("a_pw"))) {
					request.setAttribute("r", "濡쒓렇�씤 �꽦怨�!");

					Bean bean = new Bean();
					bean.setA_id(rs.getString("a_id"));
					bean.setA_password(rs.getString("a_password"));
					bean.setA_name(rs.getString("a_name"));
					bean.setA_birth(rs.getDate("a_birth"));
					bean.setA_gender(rs.getString("a_gender"));
					bean.setA_email(rs.getString("a_email"));
					bean.setA_phone(rs.getString("a_phone"));
					bean.setA_interest(rs.getString("a_interest"));
					request.setAttribute("account", bean);

					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", bean);
					hs.setMaxInactiveInterval(60);

				} else {
					request.setAttribute("r", "鍮꾨�踰덊샇 �삤瑜�!");
					;
				}
			} else {
				request.setAttribute("r", "議댁옱�븯吏� �븡�뒗 �쉶�썝");
			}

			if (pstmt.executeUpdate() == 1) {
			}

		} catch (Exception e) {
			request.setAttribute("r", "�꽌踰� �삤瑜�");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void account(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "insert into semi_account values(?,?,?,?,?,?,?,?);";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt = DBManager.connect().prepareStatement(sql);

			pstmt.setString(1, request.getParameter("id"));
			pstmt.setString(2, request.getParameter("pw"));
			pstmt.setString(3, request.getParameter("name"));
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
			Date birth = (Date) format.parse(request.getParameter("birth"));
			pstmt.setDate(4, birth);
			pstmt.setString(5, request.getParameter("gender"));
			pstmt.setString(6, request.getParameter("email"));
			pstmt.setString(7, request.getParameter("phone"));
			pstmt.setString(8, request.getParameter("chk"));
			pstmt.executeUpdate();

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "�쉶�썝媛��엯�꽦怨�");
			}

		} catch (Exception e) {
			request.setAttribute("r", "db�꽌踰꾩삤瑜�");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static boolean loginCheck(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		Bean a = (Bean) hs.getAttribute("accountInfo");

		if (a == null) {
			request.setAttribute("loginPage", "jsp/jw/login.jsp");
		} else {
			request.setAttribute("loginPage", "jsp/jw/loginOk.jsp");
		}
		return false;
	}

	public static void logout(HttpServletRequest request) {

		HttpSession hs = request.getSession();
		hs.setAttribute("accountInfo", null);

	}

	public static void delId(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete semi_account where a_id=?";
		try {
			con=DBManager.connect();
			pstmt=con.prepareStatement(sql);
			
			String id = request.getParameter("id");
			
			
			pstmt.setString(1, id);
			
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("r", "삭제성공");
			}
			
		} catch (Exception e) {
			request.setAttribute("r", "서버오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
		
	}
}
