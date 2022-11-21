package com.semi.tk.review;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.jw.Bean;
import com.semi.jw.DBManager;

public class ReviewDAO {

	private static ArrayList<Review> reviews;

	// 전체조회
	public static void getAllReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from semi_review order by r_date";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			Review review = null;
			reviews = new ArrayList<Review>();
			while (rs.next()) {
				review = new Review();
				review.setR_id(rs.getString("r_id"));
				review.setR_no(rs.getInt("r_no"));
				review.setR_movie(rs.getString("r_movie"));
				review.setR_title(rs.getString("r_title"));
				review.setR_detail(rs.getString("r_detail"));
				review.setR_img(rs.getString("r_img"));
				review.setR_date(rs.getDate("r_date"));
				review.setR_count(rs.getInt("r_count"));

				reviews.add(review);
			}
			request.setAttribute("reviews", reviews);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	// 선택한 게시글 1개
	public static void getReview(HttpServletRequest request) {

		String afterUpdateNo = (String) request.getAttribute("afterUpdateNo");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from semi_review where r_no=?";

		try {
			String no = request.getParameter("no");
			System.out.println("param no : " + no);

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			if(afterUpdateNo != null) {
				
				pstmt.setString(1, afterUpdateNo);
			} else {
				pstmt.setString(1, no);
				
			}
			rs = pstmt.executeQuery();

			Review review = null;
			if (rs.next()) {
				review = new Review();
				review.setR_id(rs.getString("r_id"));
				review.setR_no(rs.getInt("r_no"));
				review.setR_movie(rs.getString("r_movie"));
				review.setR_title(rs.getString("r_title"));
				review.setR_detail(rs.getString("r_detail"));
				review.setR_img(rs.getString("r_img"));
				review.setR_date(rs.getDate("r_date"));
				review.setR_count(rs.getInt("r_count"));
			}
			request.setAttribute("review", review);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버 오류..");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	// 등록하기
	public static void regReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into semi_review values(semi_review_seq.nextval,?,?,?,?,?,sysdate,?)";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String path = request.getSession().getServletContext().getRealPath("reviewImg");
			MultipartRequest mr = new MultipartRequest(request, path, 9123123, "utf-8", new DefaultFileRenamePolicy());

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			Bean a = (Bean) request.getSession().getAttribute("accountInfo");
			String movie = mr.getParameter("movie");
			String title = mr.getParameter("title");
			String detail = mr.getParameter("detail");
			String img = mr.getFilesystemName("img");
			int count = 0;

			System.out.println("session id : " + a.getA_id());
			System.out.println("param movie : " + movie);
			System.out.println("param title : " + title);
			System.out.println("param detail : " + detail);
			System.out.println("param img : " + img);
			System.out.println("초기화고정count : " + count);

			pstmt.setString(1, a.getA_id());
			pstmt.setString(2, movie);
			pstmt.setString(3, title);
			pstmt.setString(4, detail);
			pstmt.setString(5, img);
			pstmt.setInt(6, count);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "등록완료");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버 오류..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	// 수정하기
	public static void updateReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update semi_review set r_movie=?,r_title=?,r_detail=?,r_img=? where r_no=?";
		String path = request.getServletContext().getRealPath("reviewImg");
		System.out.println(path);

		try {

			MultipartRequest mr = new MultipartRequest(request, path, 9123123, "utf-8",
					new DefaultFileRenamePolicy());

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			String movie = mr.getParameter("movie");
			String title = mr.getParameter("title");
			String detail = mr.getParameter("detail");
			String oldImg = mr.getParameter("img"); // 기존사진 (조심하기)
			String newImg = mr.getFilesystemName("img2"); // 사진을 새로 추가함
			String no = mr.getParameter("no");

			System.out.println("param movie : " + movie);
			System.out.println("param title : " + title);
			System.out.println("param detail : " + detail);
			System.out.println("param oldImg : " + oldImg);
			System.out.println("param newImg : " + newImg);
			System.out.println("param no : " + no);

			pstmt.setString(1, movie);
			pstmt.setString(2, title);
			pstmt.setString(3, detail);
			
			if(newImg == null) {
				pstmt.setString(4, oldImg);
			} else {
				pstmt.setString(4, newImg);
				String delFile = path + "/" + oldImg; // 기존 파일(경로를 포함)
				File f = new File(delFile);
				f.delete();
			}
			pstmt.setString(5, no);
			request.setAttribute("afterUpdateNo", no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정완료");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버 오류..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	// 삭제
	public static void deleteReview(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE semi_review where r_no=?";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String no = request.getParameter("no");
			System.out.println("param no : " + no);

			pstmt.setString(1, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제완료");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버 오류..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

	// 페이징 : 한페이지당 10개
	public static void paging(int page, HttpServletRequest req) {

		req.setAttribute("curPageNo", page);

		// 전체 페이지수 계산
		int cnt = 3;
		int total = reviews.size();

		// 총 페이지 수
		int pageCount = (int) Math.ceil(((double) total / cnt));
		req.setAttribute("pageCount", pageCount); // 페이지넘기기 화살표를 위해 넘겨주는 것

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<Review> items = new ArrayList<Review>();
		for (int i = start - 1; i > end; i--) {

			items.add(reviews.get(i));
		}

		req.setAttribute("reviews", items);
	}
	
public static void count(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update semi_review set r_count=r_count+1 where r_no=?";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			String no = request.getParameter("no");
			System.out.println("param no : " + no);

			pstmt.setString(1, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "카운트업!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버 오류..");
		} finally {
			DBManager.close(con, pstmt, null);
		}
	}

}
