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

	private static ArrayList<MyBbs> mbs;

	public static void getAllBbsFree(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		String sql = "select * from semi_free where f_id=?";
		String sql2 = "select * from semi_review where r_id=?";

		try {

			Bean a = (Bean) request.getSession().getAttribute("accountInfo");
			System.out.println("param no : " + a.getA_id());

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, a.getA_id());
			rs = pstmt.executeQuery();

			MyBbs mb = null;
			mbs = new ArrayList<MyBbs>();
			while (rs.next()) {
				mb = new MyBbs();
				mb.setMb_cat("자유게시판");
				mb.setMb_id(rs.getString("f_id"));
				mb.setMb_no(rs.getInt("f_no"));
				mb.setMb_title(rs.getString("f_title"));
				mb.setMb_detail(rs.getString("f_detail"));
				mb.setMb_img(rs.getString("f_img"));
				mb.setMb_date(rs.getDate("f_date"));
				mb.setMb_count(rs.getInt("f_count"));

				mbs.add(mb);
			}

//			pstmt2 = con.prepareStatement(sql2);
//			pstmt2.setString(1, a.getA_id());
//			rs2 = pstmt2.executeQuery();
//
//			while (rs2.next()) {
//				mb = new MyBbs();
//				mb.setMbr_cat("리뷰게시판");
//				mb.setMbr_id(rs.getString("r_id"));
//				mb.setMbr_no(rs.getInt("r_no"));
//				mb.setMbr_title(rs.getString("r_title"));
//				mb.setMbr_detail(rs.getString("r_detail"));
//				mb.setMbr_img(rs.getString("r_img"));
//				mb.setMbr_date(rs.getDate("r_date"));
//				mb.setMbr_count(rs.getInt("r_count"));
//
//				mbs.add(mb);
//			}

			request.setAttribute("mbs", mbs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}


	public static void paging(int page, HttpServletRequest req) {

		req.setAttribute("curPageNo", page);

		// 전체 페이지수 계산
		int cnt = 10;
		int total = mbs.size();

		// 총 페이지 수
		int pageCount = (int) Math.ceil(((double) total / cnt));
		req.setAttribute("pageCount", pageCount); // 페이지넘기기 화살표를 위해 넘겨주는 것

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<MyBbs> items = new ArrayList<MyBbs>();
		for (int i = start - 1; i > end; i--) {

			items.add(mbs.get(i));
		}

		req.setAttribute("frees", items);
	}

}