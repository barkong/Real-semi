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

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int r_no, String r_id, String r_movie, String r_title, String r_detail, String r_img, Date r_date,
			int r_count) {
		super();
		this.r_no = r_no;
		this.r_id = r_id;
		this.r_movie = r_movie;
		this.r_title = r_title;
		this.r_detail = r_detail;
		this.r_img = r_img;
		this.r_date = r_date;
		this.r_count = r_count;
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

}
