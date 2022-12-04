package com.semi.tk.free;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.jw.Bean;
import com.semi.main.DBManager;
import com.semi.mybbs.MyBbs;

public class FreeDAO {

	private static ArrayList<Free> frees;
	private static ArrayList<Free> freesB;
	private static ArrayList<Free> freesC;

	// 전체조회
	public static void getAllFree(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from semi_free order by f_date";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Free free = null;
			frees = new ArrayList<Free>();
			while (rs.next()) {
				free = new Free();
				free.setF_no(rs.getInt("f_no"));
				free.setF_id(rs.getString("f_id"));
				free.setF_title(rs.getString("f_title"));
				free.setF_detail(rs.getString("f_detail"));
				free.setF_img(rs.getString("f_img"));
				free.setF_date(rs.getDate("f_date"));
				free.setF_count(rs.getInt("f_count"));
				free.setF_ip(rs.getString("f_ip"));

				frees.add(free);
			}
			request.setAttribute("frees", frees);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}
	

// 조회많은 몇개만
	public static void getFreesB(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from(select * from semi_free order by f_count desc) where rownum <=5 order by f_count desc";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Free free = null;
			freesB = new ArrayList<Free>();
			while (rs.next()) {
				free = new Free();
				free.setF_Bid(rs.getString("f_id"));
				free.setF_Bno(rs.getInt("f_no"));
				free.setF_Btitle(rs.getString("f_title"));
				free.setF_Bdetail(rs.getString("f_detail"));
				free.setF_Bimg(rs.getString("f_img"));
				free.setF_Bdate(rs.getDate("f_date"));
				free.setF_Bcount(rs.getInt("f_count"));
				free.setF_Bip(rs.getString("f_ip"));

				freesB.add(free);
			}
			request.setAttribute("freesB", freesB);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

// 최신 몇개만
	public static void getFreesC(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from(select * from semi_free order by f_date desc) where rownum <=5 order by f_date desc";

		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			Free free = null;
			freesC = new ArrayList<Free>();
			while (rs.next()) {
				free = new Free();
				free.setF_Cid(rs.getString("f_id"));
				free.setF_Cno(rs.getInt("f_no"));
				free.setF_Ctitle(rs.getString("f_title"));
				free.setF_Cdetail(rs.getString("f_detail"));
				free.setF_Cimg(rs.getString("f_img"));
				free.setF_Cdate(rs.getDate("f_date"));
				free.setF_Ccount(rs.getInt("f_count"));
				free.setF_Cip(rs.getString("f_ip"));

				freesC.add(free);
			}
			request.setAttribute("freesC", freesC);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	// 선택한 게시글 1개
	public static void getFree(HttpServletRequest request) {

		String afterUpdateNo = (String) request.getAttribute("afterUpdateNo");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from semi_free where f_no=?";

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

			Free free = null;
			if (rs.next()) {
				free = new Free();
				free.setF_id(rs.getString("f_id"));
				free.setF_no(rs.getInt("f_no"));
				free.setF_title(rs.getString("f_title"));
				free.setF_detail(rs.getString("f_detail"));
				free.setF_img(rs.getString("f_img"));
				free.setF_date(rs.getDate("f_date"));
				free.setF_count(rs.getInt("f_count"));
				free.setF_ip(rs.getString("f_ip"));
			}
			request.setAttribute("free", free);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	public static void regFree(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into semi_free values(semi_free_seq.nextval,?,?,?,?,sysdate,?,?)";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String path = request.getSession().getServletContext().getRealPath("files/freeImg");
			MultipartRequest mr = new MultipartRequest(request, path, 9123123, "utf-8", new DefaultFileRenamePolicy());

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			Bean a = (Bean) request.getSession().getAttribute("accountInfo");
			String title = mr.getParameter("title");

			String detail = mr.getParameter("detail");
			detail = detail.replace("\r\n", "<br>");

			String img = mr.getFilesystemName("img");
			int count = 0;

			String regIp = request.getRemoteAddr();

			pstmt.setString(1, a.getA_id());
			pstmt.setString(2, title);
			pstmt.setString(3, detail);

			if (img != null) {
				pstmt.setString(4, img);
			} else {
				pstmt.setString(4, "");
			}

			pstmt.setInt(5, count);
			pstmt.setString(6, regIp);

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

	// 수정
	public static void updateFree(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update semi_free set f_title=?,f_detail=?,f_img=? where f_no=?";
		String path = request.getServletContext().getRealPath("files/freeImg");

		try {

			MultipartRequest mr = new MultipartRequest(request, path, 9123123, "utf-8", new DefaultFileRenamePolicy());

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			String title = mr.getParameter("title");

			String detail = mr.getParameter("detail");
			detail = detail.replace("\r\n", "<br>");

			String oldImg = mr.getParameter("img"); // 기존사진 (조심하기)
			String newImg = mr.getFilesystemName("img2"); // 사진을 새로 추가함
			String no = mr.getParameter("no");

			pstmt.setString(1, title);
			pstmt.setString(2, detail);

			if (newImg == null) {
				pstmt.setString(3, oldImg);
			} else {
				pstmt.setString(3, newImg);
				String delFile = path + "/" + oldImg; // 기존 파일(경로를 포함)
				File f = new File(delFile);
				f.delete();
			}
			
			pstmt.setString(4, no);
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
	public static void deleteFree(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE semi_free where f_no=?";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String no = request.getParameter("no");

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
		int cnt = 20;
		int total = frees.size();
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

		ArrayList<Free> items = new ArrayList<Free>();
		for (int i = start - 1; i > end; i--) {

			items.add(frees.get(i));
		}

		req.setAttribute("frees", items);
	}

	public static void count(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update semi_free set f_count=f_count+1 where f_no=?";

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
		String sql = "select f_ip from semi_free where F_NO=?";
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
				regIp = rs.getString("f_ip");
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
