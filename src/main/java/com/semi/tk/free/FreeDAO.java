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

public class FreeDAO {

	private static ArrayList<Free> frees;

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
				free.setF_id(rs.getString("f_id"));
				free.setF_no(rs.getInt("f_no"));
				free.setF_title(rs.getString("f_title"));
				free.setF_detail(rs.getString("f_detail"));
				free.setF_img(rs.getString("f_img"));
				free.setF_date(rs.getDate("f_date"));
				free.setF_count(rs.getInt("f_count"));

				frees.add(free);
			}
			request.setAttribute("frees", frees);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
	}

	// 선택한 게시글 1개
	public static void getFree(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from semi_free where f_no=?";

		try {
			String no = request.getParameter("no");
			System.out.println("param no : " + no);

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);

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
		String sql = "insert into semi_free values(semi_free_seq.nextval,?,?,?,?,sysdate,?)";

		try {

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			String path = request.getSession().getServletContext().getRealPath("freeImg");
			MultipartRequest mr = new MultipartRequest(request, path, 9123123, "utf-8", new DefaultFileRenamePolicy());

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			Bean a = (Bean) request.getSession().getAttribute("accountInfo");
			String title = mr.getParameter("title");
			String detail = mr.getParameter("detail");
			String img = mr.getFilesystemName("img");
			int count = 0;

			System.out.println("session id : " + a.getA_id());
			System.out.println("param title : " + title);
			System.out.println("param detail : " + detail);
			System.out.println("param img : " + img);
			System.out.println("초기화고정count : " + count);

			pstmt.setString(1, a.getA_id());
			pstmt.setString(2, title);
			pstmt.setString(3, detail);
			pstmt.setString(4, img);
			pstmt.setInt(5, count);

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
		String path = request.getServletContext().getRealPath("freeImg");
		System.out.println(path);

		try {

			MultipartRequest mr = new MultipartRequest(request, path, 9123123, "utf-8", new DefaultFileRenamePolicy());

			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);

			// 콘솔창에서 확인하기 위해 이 방식을 체택
			String title = mr.getParameter("title");
			String detail = mr.getParameter("detail");
			String oldImg = mr.getParameter("img"); // 기존사진 (조심하기)
			String newImg = mr.getFilesystemName("img2"); // 사진을 새로 추가함
			String no = mr.getParameter("no");

			System.out.println("param title : " + title);
			System.out.println("param detail : " + detail);
			System.out.println("param oldImg : " + oldImg);
			System.out.println("param newImg : " + newImg);
			System.out.println("param no : " + no);

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
		int cnt = 3;
		int total = frees.size();

		// 총 페이지 수
		int pageCount = (int) Math.ceil(((double) total / cnt));
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
