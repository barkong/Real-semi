package com.semi.mybbs;

import java.util.Date;

public class MyBbs {
	private String mbf_cat;
	private String mbr_cat;
	private int mbf_no; // 시퀀스
	private int mbr_no; // 시퀀스
	private String mbf_id; // 작성자 id
	private String mbr_id; // 작성자 id
	private String mbf_title; // 글제목
	private String mbr_title; // 글제목
	private String mbf_detail; // 글내용
	private String mbr_detail; // 글내용
	private String mbf_img; // 이미지
	private String mbr_img; // 이미지
	private Date mbf_date; // 작성날짜
	private Date mbr_date; // 작성날짜
	private int mbf_count; // 조회수
	private int mbr_count; // 조회수

	public MyBbs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyBbs(String mbf_cat, String mbr_cat, int mbf_no, int mbr_no, String mbf_id, String mbr_id, String mbf_title,
			String mbr_title, String mbf_detail, String mbr_detail, String mbf_img, String mbr_img, Date mbf_date,
			Date mbr_date, int mbf_count, int mbr_count) {
		super();
		this.mbf_cat = mbf_cat;
		this.mbr_cat = mbr_cat;
		this.mbf_no = mbf_no;
		this.mbr_no = mbr_no;
		this.mbf_id = mbf_id;
		this.mbr_id = mbr_id;
		this.mbf_title = mbf_title;
		this.mbr_title = mbr_title;
		this.mbf_detail = mbf_detail;
		this.mbr_detail = mbr_detail;
		this.mbf_img = mbf_img;
		this.mbr_img = mbr_img;
		this.mbf_date = mbf_date;
		this.mbr_date = mbr_date;
		this.mbf_count = mbf_count;
		this.mbr_count = mbr_count;
	}

	public String getMbf_cat() {
		return mbf_cat;
	}

	public void setMbf_cat(String mbf_cat) {
		this.mbf_cat = mbf_cat;
	}

	public String getMbr_cat() {
		return mbr_cat;
	}

	public void setMbr_cat(String mbr_cat) {
		this.mbr_cat = mbr_cat;
	}

	public int getMbf_no() {
		return mbf_no;
	}

	public void setMbf_no(int mbf_no) {
		this.mbf_no = mbf_no;
	}

	public int getMbr_no() {
		return mbr_no;
	}

	public void setMbr_no(int mbr_no) {
		this.mbr_no = mbr_no;
	}

	public String getMbf_id() {
		return mbf_id;
	}

	public void setMbf_id(String mbf_id) {
		this.mbf_id = mbf_id;
	}

	public String getMbr_id() {
		return mbr_id;
	}

	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}

	public String getMbf_title() {
		return mbf_title;
	}

	public void setMbf_title(String mbf_title) {
		this.mbf_title = mbf_title;
	}

	public String getMbr_title() {
		return mbr_title;
	}

	public void setMbr_title(String mbr_title) {
		this.mbr_title = mbr_title;
	}

	public String getMbf_detail() {
		return mbf_detail;
	}

	public void setMbf_detail(String mbf_detail) {
		this.mbf_detail = mbf_detail;
	}

	public String getMbr_detail() {
		return mbr_detail;
	}

	public void setMbr_detail(String mbr_detail) {
		this.mbr_detail = mbr_detail;
	}

	public String getMbf_img() {
		return mbf_img;
	}

	public void setMbf_img(String mbf_img) {
		this.mbf_img = mbf_img;
	}

	public String getMbr_img() {
		return mbr_img;
	}

	public void setMbr_img(String mbr_img) {
		this.mbr_img = mbr_img;
	}

	public Date getMbf_date() {
		return mbf_date;
	}

	public void setMbf_date(Date mbf_date) {
		this.mbf_date = mbf_date;
	}

	public Date getMbr_date() {
		return mbr_date;
	}

	public void setMbr_date(Date mbr_date) {
		this.mbr_date = mbr_date;
	}

	public int getMbf_count() {
		return mbf_count;
	}

	public void setMbf_count(int mbf_count) {
		this.mbf_count = mbf_count;
	}

	public int getMbr_count() {
		return mbr_count;
	}

	public void setMbr_count(int mbr_count) {
		this.mbr_count = mbr_count;
	}

}
