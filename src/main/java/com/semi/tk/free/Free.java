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
	
	public Free() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Free(int f_no, String f_id, String f_title, String f_detail, String f_img, Date f_date, int f_count,
			String f_ip) {
		super();
		this.f_no = f_no;
		this.f_id = f_id;
		this.f_title = f_title;
		this.f_detail = f_detail;
		this.f_img = f_img;
		this.f_date = f_date;
		this.f_count = f_count;
		this.f_ip = f_ip;
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


}
