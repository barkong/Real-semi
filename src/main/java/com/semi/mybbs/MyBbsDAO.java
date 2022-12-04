package com.semi.mybbs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.semi.jw.Bean;
import com.semi.main.DBManager;
import com.semi.tk.free.Free;

public class MyBbsDAO {

	private static ArrayList<MyBbs> mbr;
	private static ArrayList<MyBbs> mbf;

	public static void getAllBbsR(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from semi_review where r_id=?";

		try {

			Bean a = (Bean) request.getSession().getAttribute("accountInfo");

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a.getA_id());
			rs = pstmt.executeQuery();

			MyBbs mb = null;
			mbr = new ArrayList<MyBbs>();
			while (rs.next()) {
				mb = new MyBbs();
				mb.setMbr_cat("리뷰게시판");
				mb.setMbr_id(rs.getString("r_id"));
				mb.setMbr_no(rs.getInt("r_no"));
				mb.setMbr_title(rs.getString("r_title"));
				mb.setMbr_detail(rs.getString("r_detail"));
				mb.setMbr_img(rs.getString("r_img"));
				mb.setMbr_date(rs.getDate("r_date"));
				mb.setMbr_count(rs.getInt("r_count"));

				mbr.add(mb);
			}

			request.setAttribute("mbr", mbr);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	
	public static void getAllBbsF(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from semi_free where f_id=?";

		try {

			Bean a = (Bean) request.getSession().getAttribute("accountInfo");

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a.getA_id());
			rs = pstmt.executeQuery();

			MyBbs mb = null;
			mbf = new ArrayList<MyBbs>();
			while (rs.next()) {
				mb = new MyBbs();
				mb.setMbf_cat("자유게시판");
				mb.setMbf_id(rs.getString("f_id"));
				mb.setMbf_no(rs.getInt("f_no"));
				mb.setMbf_title(rs.getString("f_title"));
				mb.setMbf_detail(rs.getString("f_detail"));
				mb.setMbf_img(rs.getString("f_img"));
				mb.setMbf_date(rs.getDate("f_date"));
				mb.setMbf_count(rs.getInt("f_count"));

				mbf.add(mb);
			}
			request.setAttribute("mbf", mbf);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	

	public static void pagingR(int page, HttpServletRequest req) {

		req.setAttribute("curPageNo", page);

		// 전체 페이지수 계산
		int cnt = 10;
		int total = mbr.size();
		int pageCount;
		// 총 페이지 수
		if (total==0) {
			pageCount = 1;
		} else {
			pageCount = (int) Math.ceil(((double) total / cnt));
		}
		req.setAttribute("pageCount", pageCount); // 페이지넘기기 화살표를 위해 넘겨주는 것

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<MyBbs> items = new ArrayList<MyBbs>();
		for (int i = start - 1; i > end; i--) {

			items.add(mbr.get(i));
		}

		req.setAttribute("mbr", items);
	}
	
	public static void pagingF(int page, HttpServletRequest req) {

		req.setAttribute("curPageNo", page);

		// 전체 페이지수 계산
		int cnt = 10;
		int total = mbf.size();
		int pageCount;
		// 총 페이지 수
		if (total==0) {
			pageCount = 1;
		} else {
			pageCount = (int) Math.ceil(((double) total / cnt));
		}
		req.setAttribute("pageCount", pageCount); // 페이지넘기기 화살표를 위해 넘겨주는 것

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<MyBbs> items = new ArrayList<MyBbs>();
		for (int i = start - 1; i > end; i--) {

			items.add(mbf.get(i));
		}

		req.setAttribute("mbf", items);
	}


}
