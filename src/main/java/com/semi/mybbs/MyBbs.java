package com.semi.mybbs;

import java.util.Date;

public class MyBbs {
	private String mb_cat;
	private String mbr_cat;
	private int mb_no; // 시퀀스
	private int mbr_no; // 시퀀스
	private String mb_id; // 작성자 id
	private String mbr_id; // 작성자 id
	private String mb_title; // 글제목
	private String mbr_title; // 글제목
	private String mb_detail; // 글내용
	private String mbr_detail; // 글내용
	private String mb_img; // 이미지
	private String mbr_img; // 이미지
	private Date mb_date; // 작성날짜
	private Date mbr_date; // 작성날짜
	private int mb_count; // 조회수
	private int mbr_count; // 조회수
	public MyBbs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyBbs(int mb_no, int mbr_no, String mb_id, String mbr_id, String mb_title, String mbr_title,
			String mb_detail, String mbr_detail, String mb_img, String mbr_img, Date mb_date, Date mbr_date,
			int mb_count, int mbr_count) {
		super();
		this.mb_no = mb_no;
		this.mbr_no = mbr_no;
		this.mb_id = mb_id;
		this.mbr_id = mbr_id;
		this.mb_title = mb_title;
		this.mbr_title = mbr_title;
		this.mb_detail = mb_detail;
		this.mbr_detail = mbr_detail;
		this.mb_img = mb_img;
		this.mbr_img = mbr_img;
		this.mb_date = mb_date;
		this.mbr_date = mbr_date;
		this.mb_count = mb_count;
		this.mbr_count = mbr_count;
	}
	public int getMb_no() {
		return mb_no;
	}
	public void setMb_no(int mb_no) {
		this.mb_no = mb_no;
	}
	public int getMbr_no() {
		return mbr_no;
	}
	public void setMbr_no(int mbr_no) {
		this.mbr_no = mbr_no;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMbr_id() {
		return mbr_id;
	}
	public void setMbr_id(String mbr_id) {
		this.mbr_id = mbr_id;
	}
	public String getMb_title() {
		return mb_title;
	}
	public void setMb_title(String mb_title) {
		this.mb_title = mb_title;
	}
	public String getMbr_title() {
		return mbr_title;
	}
	public void setMbr_title(String mbr_title) {
		this.mbr_title = mbr_title;
	}
	public String getMb_detail() {
		return mb_detail;
	}
	public void setMb_detail(String mb_detail) {
		this.mb_detail = mb_detail;
	}
	public String getMbr_detail() {
		return mbr_detail;
	}
	public void setMbr_detail(String mbr_detail) {
		this.mbr_detail = mbr_detail;
	}
	public String getMb_img() {
		return mb_img;
	}
	public void setMb_img(String mb_img) {
		this.mb_img = mb_img;
	}
	public String getMbr_img() {
		return mbr_img;
	}
	public void setMbr_img(String mbr_img) {
		this.mbr_img = mbr_img;
	}
	public Date getMb_date() {
		return mb_date;
	}
	public void setMb_date(Date mb_date) {
		this.mb_date = mb_date;
	}
	public Date getMbr_date() {
		return mbr_date;
	}
	public void setMbr_date(Date mbr_date) {
		this.mbr_date = mbr_date;
	}
	public int getMb_count() {
		return mb_count;
	}
	public void setMb_count(int mb_count) {
		this.mb_count = mb_count;
	}
	public int getMbr_count() {
		return mbr_count;
	}
	public void setMbr_count(int mbr_count) {
		this.mbr_count = mbr_count;
	}
	public String getMb_cat() {
		return mb_cat;
	}
	public void setMb_cat(String mb_cat) {
		this.mb_cat = mb_cat;
	}
	public String getMbr_cat() {
		return mbr_cat;
	}
	public void setMbr_cat(String mbr_cat) {
		this.mbr_cat = mbr_cat;
	}
	
	
	
}
