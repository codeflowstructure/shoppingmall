package com.shop.biz.account;

import java.util.Date;

public class AccountVO {
	private int acc_no;
	private String acc_id;
	private String acc_pw;
	private int acc_role;
	private Date cre_date;
	private Date log_date;
	private int acc_points;
	private String acc_address;
	private String acc_phone_mobile;
	private String acc_phone_home;
	
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public String getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(String acc_id) {
		this.acc_id = acc_id;
	}
	public String getAcc_pw() {
		return acc_pw;
	}
	public void setAcc_pw(String acc_pw) {
		this.acc_pw = acc_pw;
	}
	public int getAcc_role() {
		return acc_role;
	}
	public void setAcc_role(int acc_role) {
		this.acc_role = acc_role;
	}
	public Date getCre_date() {
		return cre_date;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	public Date getLog_date() {
		return log_date;
	}
	public void setLog_date(Date log_date) {
		this.log_date = log_date;
	}
	public int getAcc_points() {
		return acc_points;
	}
	public void setAcc_points(int acc_points) {
		this.acc_points = acc_points;
	}
	
	public String getAcc_address() {
		return acc_address;
	}
	public void setAcc_address(String acc_address) {
		this.acc_address = acc_address;
	}
	public String getAcc_phone_mobile() {
		return acc_phone_mobile;
	}
	public void setAcc_phone_mobile(String acc_phone_mobile) {
		this.acc_phone_mobile = acc_phone_mobile;
	}
	public String getAcc_phone_home() {
		return acc_phone_home;
	}
	public void setAcc_phone_home(String acc_phone_home) {
		this.acc_phone_home = acc_phone_home;
	}
	@Override
	public String toString() {
		return "[acc_no: " + acc_no + ", acc_id: " + acc_id + ", acc_pw: " + acc_pw + ", acc_role: " + acc_role + ", cre_date: " + cre_date + ", log_date: " + log_date + ", acc_points: " + acc_points + ", acc_address: " + acc_address + ", acc_phone_mobile: " + acc_phone_mobile + ", acc_phone_home: " + acc_phone_home + "]";
	}
	
	
}
