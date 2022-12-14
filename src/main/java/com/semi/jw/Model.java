package com.semi.jw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.semi.main.DBManager;

public class Model {

	public static void login(HttpServletRequest request) {

		String userId = request.getParameter("id");
		String userPw = request.getParameter("pw");

		String iddd = (String) request.getAttribute("iddd");
		String pwww = (String) request.getAttribute("pwww");

		if (iddd != null) {
			userId = iddd;
			userPw = pwww;
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "select * from semi_account where a_id=?";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (userPw.equals(rs.getString("a_password"))) {
					request.setAttribute("r", "로그인성공");
					
					Bean bean = new Bean();
					bean.setA_id(rs.getString("a_id"));
					bean.setA_password(rs.getString("a_password"));
					bean.setA_name(rs.getString("a_name"));
					bean.setA_birth(rs.getString("a_birth"));
					bean.setA_gender(rs.getString("a_gender"));
					bean.setA_email(rs.getString("a_email"));
					bean.setA_phone(rs.getString("a_phone"));

					String interest = rs.getString("a_interest");
					interest = interest.replace("!", "&nbsp;&nbsp;");
					bean.setA_interest(interest);

					request.setAttribute("account", bean);

					HttpSession hs = request.getSession();
					hs.setAttribute("accountInfo", bean);

					hs.setMaxInactiveInterval(5000000);
					
				} else {
					request.setAttribute("r", "비밀번호 오류!");
				}
			} else {
				request.setAttribute("r", "존재하지 않는 회원");
			}

		} catch (Exception e) {
			request.setAttribute("r", "서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

	public static void account(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		

		try {
			// post 방식 한글처리.  *한글*
//			request.setCharacterEncoding("utf-8");
			String sql = "insert into semi_account values(?,?,?,to_date(?,'YYYY-MM-DD'),?,?,?,?)";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

				
			pstmt.setString(1, request.getParameter("id"));
			pstmt.setString(2, request.getParameter("pw"));
			String name = request.getParameter("name");
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			pstmt.setString(3, name);
			pstmt.setString(4, request.getParameter("birth"));
			String gender = request.getParameter("gender");
			gender = new String(gender.getBytes("ISO-8859-1"), "UTF-8");
			pstmt.setString(5, gender);
			pstmt.setString(6, request.getParameter("email"));
			pstmt.setString(7, request.getParameter("phone"));
			
			String[] chk = request.getParameterValues("chk");
			String chk2 = "";
			if (chk != null) {
				for (String s : chk) {
					chk2 += s + "!";
				}
				chk2 = new String(chk2.getBytes("ISO-8859-1"), "UTF-8");
			} else {
				chk2 = "관심사 없음";
			}

			pstmt.setString(8, chk2);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "회원가입성공");
			}

		} catch (Exception e) {
			request.setAttribute("r", "db서버오류");
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
			return false;
		} else {
			request.setAttribute("loginPage", "jsp/jw/loginOk.jsp");
			return true;
		}
	}
	
	public static void wathingPage(HttpServletRequest request) {

		String watchingPage = request.getRequestURL().toString();
		String param = request.getQueryString();
		if (request.getQueryString() != null) {
			watchingPage = watchingPage + "?" + param; // 수정할 글의 번호도 있으니까
		}
		request.getSession().setAttribute("watchingPage", watchingPage);

	}

	public static void logout(HttpServletRequest request) {

		HttpSession hs = request.getSession();
		hs.setAttribute("accountInfo", null);
		hs.setAttribute("watchingPage", null);

	}

	public static void updateInfo(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			String sql = "update semi_account set a_password=?,a_name=?,a_email=?,a_phone=?,a_interest=? where a_id=?";
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("pw"));
			String name = request.getParameter("name");
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			pstmt.setString(2, name);
			pstmt.setString(3, request.getParameter("email"));
			pstmt.setString(4, request.getParameter("phone"));
			String[] chk = request.getParameterValues("chk");
			String chk2 = "";
			if (chk != null) {
				for (String s : chk) {
					chk2 += s + "!";
				}
				chk2 = new String(chk2.getBytes("ISO-8859-1"), "UTF-8");
			} else {
				chk2 = "관심사 없음";
			}
			pstmt.setString(5, chk2);
			Bean a = (Bean) request.getSession().getAttribute("accountInfo");
			pstmt.setString(6, a.getA_id());

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "회원 정보 수정 성공");
				request.setAttribute("iddd", a.getA_id());
				request.setAttribute("pwww", request.getParameter("pw"));
			}

		} catch (Exception e) {
			request.setAttribute("r", "서버오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	public static void delId(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete semi_account where a_id=?";
		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			Bean a = (Bean) request.getSession().getAttribute("accountInfo");

			String id = a.getA_id();
			pstmt.setString(1, id);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제성공");
			}

		} catch (Exception e) {
			request.setAttribute("r", "서버오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, null);
		}

	}

	public static void idCheck(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.connect();
			String sql = "select a_id from semi_account where a_id=?";
			pstmt = con.prepareStatement(sql);
			String id = request.getParameter("id");
			pstmt.setString(1, request.getParameter("id"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (request.getParameter("id") == null || request.getParameter("id") == "") {
					request.setAttribute("t", "ID를 입력해주세요");
				} else if (request.getParameter("id").equals(rs.getString("a_id"))) {
					request.setAttribute("t", "이미 사용중인 ID 입니다.다른 ID를 입력해주세요");
				}
				
			}else {
				request.setAttribute("t", "사용가능한 아이디 입니다");
			}
			
			request.setAttribute("y", request.getParameter("id"));
		} catch (Exception e) {
			request.setAttribute("r", "서버 오류");
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}

	}

}
