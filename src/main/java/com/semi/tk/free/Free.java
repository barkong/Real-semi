package com.semi.tk.free;

import java.util.Date;

public class Free {
	private int f_no; // 시퀀스
	private String f_id; // 작성자 id
	private String f_title; // 글제목
	private String f_detail; // 글내용
	private String f_img; // 이미지
	private Date f_date; // 작성날짜
	private int f_count; // 조회수
	private String f_ip; // ip주소
// 인기조회 몇개만
	private int f_Bno; // 시퀀스
	private String f_Bid; // 작성자 id
	private String f_Btitle; // 글제목
	private String f_Bdetail; // 글내용
	private String f_Bimg; // 이미지
	private Date f_Bdate; // 작성날짜
	private int f_Bcount; // 조회수
	private String f_Bip; // ip주소
//	최신 몇개만
	private int f_Cno; // 시퀀스
	private String f_Cid; // 작성자 id
	private String f_Ctitle; // 글제목
	private String f_Cdetail; // 글내용
	private String f_Cimg; // 이미지
	private Date f_Cdate; // 작성날짜
	private int f_Ccount; // 조회수
	private String f_Cip; // ip주소
	public Free() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Free(int f_no, String f_id, String f_title, String f_detail, String f_img, Date f_date, int f_count,
			String f_ip, int f_Bno, String f_Bid, String f_Btitle, String f_Bdetail, String f_Bimg, Date f_Bdate,
			int f_Bcount, String f_Bip, int f_Cno, String f_Cid, String f_Ctitle, String f_Cdetail, String f_Cimg,
			Date f_Cdate, int f_Ccount, String f_Cip) {
		super();
		this.f_no = f_no;
		this.f_id = f_id;
		this.f_title = f_title;
		this.f_detail = f_detail;
		this.f_img = f_img;
		this.f_date = f_date;
		this.f_count = f_count;
		this.f_ip = f_ip;
		this.f_Bno = f_Bno;
		this.f_Bid = f_Bid;
		this.f_Btitle = f_Btitle;
		this.f_Bdetail = f_Bdetail;
		this.f_Bimg = f_Bimg;
		this.f_Bdate = f_Bdate;
		this.f_Bcount = f_Bcount;
		this.f_Bip = f_Bip;
		this.f_Cno = f_Cno;
		this.f_Cid = f_Cid;
		this.f_Ctitle = f_Ctitle;
		this.f_Cdetail = f_Cdetail;
		this.f_Cimg = f_Cimg;
		this.f_Cdate = f_Cdate;
		this.f_Ccount = f_Ccount;
		this.f_Cip = f_Cip;
	}
	public int getF_no() {
		return f_no;
	}
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	public String getF_id() {
		return f_id;
	}
	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	public String getF_title() {
		return f_title;
	}
	public void setF_title(String f_title) {
		this.f_title = f_title;
	}
	public String getF_detail() {
		return f_detail;
	}
	public void setF_detail(String f_detail) {
		this.f_detail = f_detail;
	}
	public String getF_img() {
		return f_img;
	}
	public void setF_img(String f_img) {
		this.f_img = f_img;
	}
	public Date getF_date() {
		return f_date;
	}
	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}
	public int getF_count() {
		return f_count;
	}
	public void setF_count(int f_count) {
		this.f_count = f_count;
	}
	public String getF_ip() {
		return f_ip;
	}
	public void setF_ip(String f_ip) {
		this.f_ip = f_ip;
	}
	public int getF_Bno() {
		return f_Bno;
	}
	public void setF_Bno(int f_Bno) {
		this.f_Bno = f_Bno;
	}
	public String getF_Bid() {
		return f_Bid;
	}
	public void setF_Bid(String f_Bid) {
		this.f_Bid = f_Bid;
	}
	public String getF_Btitle() {
		return f_Btitle;
	}
	public void setF_Btitle(String f_Btitle) {
		this.f_Btitle = f_Btitle;
	}
	public String getF_Bdetail() {
		return f_Bdetail;
	}
	public void setF_Bdetail(String f_Bdetail) {
		this.f_Bdetail = f_Bdetail;
	}
	public String getF_Bimg() {
		return f_Bimg;
	}
	public void setF_Bimg(String f_Bimg) {
		this.f_Bimg = f_Bimg;
	}
	public Date getF_Bdate() {
		return f_Bdate;
	}
	public void setF_Bdate(Date f_Bdate) {
		this.f_Bdate = f_Bdate;
	}
	public int getF_Bcount() {
		return f_Bcount;
	}
	public void setF_Bcount(int f_Bcount) {
		this.f_Bcount = f_Bcount;
	}
	public String getF_Bip() {
		return f_Bip;
	}
	public void setF_Bip(String f_Bip) {
		this.f_Bip = f_Bip;
	}
	public int getF_Cno() {
		return f_Cno;
	}
	public void setF_Cno(int f_Cno) {
		this.f_Cno = f_Cno;
	}
	public String getF_Cid() {
		return f_Cid;
	}
	public void setF_Cid(String f_Cid) {
		this.f_Cid = f_Cid;
	}
	public String getF_Ctitle() {
		return f_Ctitle;
	}
	public void setF_Ctitle(String f_Ctitle) {
		this.f_Ctitle = f_Ctitle;
	}
	public String getF_Cdetail() {
		return f_Cdetail;
	}
	public void setF_Cdetail(String f_Cdetail) {
		this.f_Cdetail = f_Cdetail;
	}
	public String getF_Cimg() {
		return f_Cimg;
	}
	public void setF_Cimg(String f_Cimg) {
		this.f_Cimg = f_Cimg;
	}
	public Date getF_Cdate() {
		return f_Cdate;
	}
	public void setF_Cdate(Date f_Cdate) {
		this.f_Cdate = f_Cdate;
	}
	public int getF_Ccount() {
		return f_Ccount;
	}

	public void setF_Ccount(int f_Ccount) {
		this.f_Ccount = f_Ccount;
	}

	public String getF_Cip() {
		return f_Cip;
	}
	public void setF_Cip(String f_Cip) {
		this.f_Cip = f_Cip;
	}



}
