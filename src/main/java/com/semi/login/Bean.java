package com.semi.login;

import java.sql.Date;

public class Bean {

	private String a_id;
	private String a_password;
	private String a_name;
	private Date a_birth;
	private String a_gender;
	private String a_email;
	private String a_phone;
	private String a_interest;
	public Bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bean(String a_id, String a_password, String a_name, Date a_birth, String a_gender, String a_email,
			String a_phone, String a_interest) {
		super();
		this.a_id = a_id;
		this.a_password = a_password;
		this.a_name = a_name;
		this.a_birth = a_birth;
		this.a_gender = a_gender;
		this.a_email = a_email;
		this.a_phone = a_phone;
		this.a_interest = a_interest;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_password() {
		return a_password;
	}
	public void setA_password(String a_password) {
		this.a_password = a_password;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public Date getA_birth() {
		return a_birth;
	}
	public void setA_birth(Date a_birth) {
		this.a_birth = a_birth;
	}
	public String getA_gender() {
		return a_gender;
	}
	public void setA_gender(String a_gender) {
		this.a_gender = a_gender;
	}
	public String getA_email() {
		return a_email;
	}
	public void setA_email(String a_email) {
		this.a_email = a_email;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	public String getA_interest() {
		return a_interest;
	}
	public void setA_interest(String a_interest) {
		this.a_interest = a_interest;
	}
	
	
}
