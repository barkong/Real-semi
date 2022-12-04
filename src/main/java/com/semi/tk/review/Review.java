package com.semi.tk.review;

import java.util.Date;

public class Review {
	private int r_no; // 시퀀스
	private String r_id; // 작성자 id
	private String r_movie; // 영화제목
	private String r_title; // 글제목
	private String r_detail; // 글내용
	private String r_img; // 이미지
	private Date r_date; // 작성날짜
	private int r_count; // 조회수
	private String r_ip; // ip주소
// 인기조회 몇개만
	private int r_Bno; // 시퀀스
	private String r_Bid; // 작성자 id
	private String r_Bmovie; // 영화제목
	private String r_Btitle; // 글제목
	private String r_Bdetail; // 글내용
	private String r_Bimg; // 이미지
	private Date r_Bdate; // 작성날짜
	private int r_Bcount; // 조회수
	private String r_Bip; // ip주소
//	최신 몇개만
	private int r_Cno; // 시퀀스
	private String r_Cid; // 작성자 id
	private String r_Cmovie; // 영화제목
	private String r_Ctitle; // 글제목
	private String r_Cdetail; // 글내용
	private String r_Cimg; // 이미지
	private Date r_Cdate; // 작성날짜
	private int r_Ccount; // 조회수
	private String r_Cip; // ip주소

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int r_no, String r_id, String r_movie, String r_title, String r_detail, String r_img, Date r_date,
			int r_count, String r_ip, int r_Bno, String r_Bid, String r_Bmovie, String r_Btitle, String r_Bdetail,
			String r_Bimg, Date r_Bdate, int r_Bcount, String r_Bip, int r_Cno, String r_Cid, String r_Cmovie,
			String r_Ctitle, String r_Cdetail, String r_Cimg, Date r_Cdate, int r_Ccount, String r_Cip) {
		super();
		this.r_no = r_no;
		this.r_id = r_id;
		this.r_movie = r_movie;
		this.r_title = r_title;
		this.r_detail = r_detail;
		this.r_img = r_img;
		this.r_date = r_date;
		this.r_count = r_count;
		this.r_ip = r_ip;
		this.r_Bno = r_Bno;
		this.r_Bid = r_Bid;
		this.r_Bmovie = r_Bmovie;
		this.r_Btitle = r_Btitle;
		this.r_Bdetail = r_Bdetail;
		this.r_Bimg = r_Bimg;
		this.r_Bdate = r_Bdate;
		this.r_Bcount = r_Bcount;
		this.r_Bip = r_Bip;
		this.r_Cno = r_Cno;
		this.r_Cid = r_Cid;
		this.r_Cmovie = r_Cmovie;
		this.r_Ctitle = r_Ctitle;
		this.r_Cdetail = r_Cdetail;
		this.r_Cimg = r_Cimg;
		this.r_Cdate = r_Cdate;
		this.r_Ccount = r_Ccount;
		this.r_Cip = r_Cip;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getR_movie() {
		return r_movie;
	}

	public void setR_movie(String r_movie) {
		this.r_movie = r_movie;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_detail() {
		return r_detail;
	}

	public void setR_detail(String r_detail) {
		this.r_detail = r_detail;
	}

	public String getR_img() {
		return r_img;
	}

	public void setR_img(String r_img) {
		this.r_img = r_img;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public int getR_count() {
		return r_count;
	}

	public void setR_count(int r_count) {
		this.r_count = r_count;
	}

	public String getR_ip() {
		return r_ip;
	}

	public void setR_ip(String r_ip) {
		this.r_ip = r_ip;
	}

	public int getR_Bno() {
		return r_Bno;
	}

	public void setR_Bno(int r_Bno) {
		this.r_Bno = r_Bno;
	}

	public String getR_Bid() {
		return r_Bid;
	}

	public void setR_Bid(String r_Bid) {
		this.r_Bid = r_Bid;
	}

	public String getR_Bmovie() {
		return r_Bmovie;
	}

	public void setR_Bmovie(String r_Bmovie) {
		this.r_Bmovie = r_Bmovie;
	}

	public String getR_Btitle() {
		return r_Btitle;
	}

	public void setR_Btitle(String r_Btitle) {
		this.r_Btitle = r_Btitle;
	}

	public String getR_Bdetail() {
		return r_Bdetail;
	}

	public void setR_Bdetail(String r_Bdetail) {
		this.r_Bdetail = r_Bdetail;
	}

	public String getR_Bimg() {
		return r_Bimg;
	}

	public void setR_Bimg(String r_Bimg) {
		this.r_Bimg = r_Bimg;
	}

	public Date getR_Bdate() {
		return r_Bdate;
	}

	public void setR_Bdate(Date r_Bdate) {
		this.r_Bdate = r_Bdate;
	}

	public int getR_Bcount() {
		return r_Bcount;
	}

	public void setR_Bcount(int r_Bcount) {
		this.r_Bcount = r_Bcount;
	}

	public String getR_Bip() {
		return r_Bip;
	}

	public void setR_Bip(String r_Bip) {
		this.r_Bip = r_Bip;
	}

	public int getR_Cno() {
		return r_Cno;
	}

	public void setR_Cno(int r_Cno) {
		this.r_Cno = r_Cno;
	}

	public String getR_Cid() {
		return r_Cid;
	}

	public void setR_Cid(String r_Cid) {
		this.r_Cid = r_Cid;
	}

	public String getR_Cmovie() {
		return r_Cmovie;
	}

	public void setR_Cmovie(String r_Cmovie) {
		this.r_Cmovie = r_Cmovie;
	}

	public String getR_Ctitle() {
		return r_Ctitle;
	}

	public void setR_Ctitle(String r_Ctitle) {
		this.r_Ctitle = r_Ctitle;
	}

	public String getR_Cdetail() {
		return r_Cdetail;
	}

	public void setR_Cdetail(String r_Cdetail) {
		this.r_Cdetail = r_Cdetail;
	}

	public String getR_Cimg() {
		return r_Cimg;
	}

	public void setR_Cimg(String r_Cimg) {
		this.r_Cimg = r_Cimg;
	}

	public Date getR_Cdate() {
		return r_Cdate;
	}

	public void setR_Cdate(Date r_Cdate) {
		this.r_Cdate = r_Cdate;
	}

	public int getR_Ccount() {
		return r_Ccount;
	}

	public void setR_Ccount(int r_Ccount) {
		this.r_Ccount = r_Ccount;
	}

	public String getR_Cip() {
		return r_Cip;
	}

	public void setR_Cip(String r_Cip) {
		this.r_Cip = r_Cip;
	}

}
