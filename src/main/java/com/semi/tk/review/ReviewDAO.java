package com.semi.tk.review;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.w3c.dom.ls.LSOutput;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.jw.Bean;
import com.semi.main.DBManager;
import com.semi.tk.free.Free;

public class ReviewDAO {

	private static ArrayList<Review> reviews;
	private static ArrayList<Review> reviewsB;
	private static ArrayList<Review> reviewsC;

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
				review.setR_no(rs.getInt("r_no"));
				review.setR_id(rs.getString("r_id"));
				review.setR_movie(rs.getString("r_movie"));
				review.setR_title(rs.getString("r_title"));
				review.setR_detail(rs.getString("r_detail"));
				review.setR_img(rs.getString("r_img"));
				review.setR_date(rs.getDate("r_date"));
				review.setR_count(rs.getInt("r_count"));
				review.setR_ip(rs.getString("r_ip"));

				reviews.add(review);
			}
			request.setAttribute("reviews", reviews);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	
// 조회많은 몇개만
	public static void getReviewsB(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from(select * from semi_review order by r_count desc) where rownum <=5 order by r_count desc";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Review review = null;
			reviewsB = new ArrayList<Review>();
			while (rs.next()) {
				review = new Review();
				review.setR_Bid(rs.getString("r_id"));
				review.setR_Bno(rs.getInt("r_no"));
				review.setR_Bmovie(rs.getString("r_movie"));
				review.setR_Btitle(rs.getString("r_title"));
				review.setR_Bimg(rs.getString("r_img"));
				review.setR_Bdate(rs.getDate("r_date"));
				review.setR_Bcount(rs.getInt("r_count"));
				review.setR_Bip(rs.getString("r_ip"));

				reviewsB.add(review);
			}
			request.setAttribute("reviewsB", reviewsB);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

// 최신 리뷰 몇개만
	public static void getReviewsC(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from(select * from semi_review order by r_date desc) where rownum <=5 order by r_date desc";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Review review = null;
			reviewsC = new ArrayList<Review>();
			while (rs.next()) {
				review = new Review();
				review.setR_Cid(rs.getString("r_id"));
				review.setR_Cno(rs.getInt("r_no"));
				review.setR_Cmovie(rs.getString("r_movie"));
				review.setR_Ctitle(rs.getString("r_title"));
				review.setR_Cimg(rs.getString("r_img"));
				review.setR_Cdate(rs.getDate("r_date"));
				review.setR_Ccount(rs.getInt("r_count"));
				review.setR_Cip(rs.getString("r_ip"));

				reviewsC.add(review);
			}
			request.setAttribute("reviewsC", reviewsC);

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

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			if (afterUpdateNo != null) {

				pstmt.setString(1, afterUpdateNo);
			} else {
				pstmt.setString(1, no);

			}
			rs = pstmt.executeQuery();

			Review review = null;
			if (rs.next()) {
				review = new Review();
				review.setR_no(rs.getInt("r_no"));
				review.setR_id(rs.getString("r_id"));
				review.setR_movie(rs.getString("r_movie"));
				review.setR_title(rs.getString("r_title"));
				review.setR_detail(rs.getString("r_detail"));
				review.setR_img(rs.getString("r_img"));
				review.setR_date(rs.getDate("r_date"));
				review.setR_count(rs.getInt("r_count"));
				review.setR_ip(rs.getString("r_ip"));
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
		String sql = "insert into semi_review values(semi_review_seq.nextval,?,?,?,?,?,sysdate,?,?)";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String path = request.getSession().getServletContext().getRealPath("files/reviewImg");
			MultipartRequest mr = new MultipartRequest(request, path, 9123123, "utf-8", new DefaultFileRenamePolicy());

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			Bean a = (Bean) request.getSession().getAttribute("accountInfo");
			String movie = mr.getParameter("movie");
			String title = mr.getParameter("title");

			String detail = mr.getParameter("detail");
			detail = detail.replace("\r\n", "<br>");

			String img = mr.getFilesystemName("img");
			int count = 0;

			String regIp = request.getRemoteAddr();
			pstmt.setString(1, a.getA_id());
			pstmt.setString(2, movie);
			pstmt.setString(3, title);
			pstmt.setString(4, detail);

			if (img != null) {
				pstmt.setString(5, img);
			} else {
				pstmt.setString(5, "");
			}

			pstmt.setInt(6, count);
			pstmt.setString(7, regIp);

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
		String path = request.getServletContext().getRealPath("files/reviewImg");

		try {

			MultipartRequest mr = new MultipartRequest(request, path, 9123123, "utf-8", new DefaultFileRenamePolicy());

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			String movie = mr.getParameter("movie");
			String title = mr.getParameter("title");

			String detail = mr.getParameter("detail");
			detail = detail.replace("\r\n", "<br>");

			String oldImg = mr.getParameter("img"); // 기존사진 (조심하기)
			String newImg = mr.getFilesystemName("newImg"); // 사진을 새로 추가함
			String no = mr.getParameter("no");

			pstmt.setString(1, movie);
			pstmt.setString(2, title);
			pstmt.setString(3, detail);

			if (newImg == null) {
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

	public static void paging(int page, HttpServletRequest req) {

		req.setAttribute("curPageNo", page);

		// 전체 페이지수 계산
		int cnt = 20; // 한페이지당 보여줄 개수
		int total = reviews.size(); // 총 (데이터 게시글) 수
		int pageCount;
		// 총 페이지 수
		if (total == 0) {
			pageCount = 1;
		} else {
			pageCount = (int) Math.ceil(((double) total / cnt));
		}
		req.setAttribute("pageCount", pageCount); // 페이지넘기기 화살표를 위해 넘겨주는 것

		int start = total - (cnt * (page - 1)); // 시작데이터번호
		int end = (page == pageCount) ? -1 : start - (cnt + 1); // 끝데이터번호

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

			String no = request.getParameter("no");

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

	public static boolean ipCheck(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select r_ip from semi_review where R_NO=?";
		String regIp = null;
		String urIp = request.getRemoteAddr();
		System.out.println(urIp);

		try {
			String no = request.getParameter("no");

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, no);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				regIp = rs.getString("r_ip");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "서버 오류..");
		} finally {
			DBManager.close(con, pstmt, rs);
		}

		System.out.println("regIp : " + regIp);

		if (urIp.equals(regIp)) {
			return false;
		} else {
			return true;
		}

	}

}
