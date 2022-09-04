package com.shop.biz.cart;

import java.util.Date;

public class CartVO {
	private int crt_no;
	private int crt_acc_no;
	private int crt_prd_no;
	private String crt_prd_option;
	private String crt_prd_size;
	private String crt_prd_color;
	private int crt_prd_price_2;
	private int crt_status;
	private Date crt_buy_date;
	private Date crt_delivery_1_date;
	private Date crt_delivery_2_date;
	private Date crt_delivery_3_date;
	
	public int getCrt_no() {
		return crt_no;
	}
	public void setCrt_no(int crt_no) {
		this.crt_no = crt_no;
	}
	public int getCrt_acc_no() {
		return crt_acc_no;
	}
	public void setCrt_acc_no(int crt_acc_no) {
		this.crt_acc_no = crt_acc_no;
	}
	public int getCrt_prd_no() {
		return crt_prd_no;
	}
	public void setCrt_prd_no(int crt_prd_no) {
		this.crt_prd_no = crt_prd_no;
	}
	public String getCrt_prd_option() {
		return crt_prd_option;
	}
	public void setCrt_prd_option(String crt_prd_option) {
		this.crt_prd_option = crt_prd_option;
	}
	public String getCrt_prd_size() {
		return crt_prd_size;
	}
	public void setCrt_prd_size(String crt_prd_size) {
		this.crt_prd_size = crt_prd_size;
	}
	public String getCrt_prd_color() {
		return crt_prd_color;
	}
	public void setCrt_prd_color(String crt_prd_color) {
		this.crt_prd_color = crt_prd_color;
	}
	public int getCrt_prd_price_2() {
		return crt_prd_price_2;
	}
	public void setCrt_prd_price_2(int crt_prd_price_2) {
		this.crt_prd_price_2 = crt_prd_price_2;
	}
	public int getCrt_status() {
		return crt_status;
	}
	public void setCrt_status(int crt_status) {
		this.crt_status = crt_status;
	}
	public Date getCrt_buy_date() {
		return crt_buy_date;
	}
	public void setCrt_buy_date(Date crt_buy_date) {
		this.crt_buy_date = crt_buy_date;
	}
	public Date getCrt_delivery_1_date() {
		return crt_delivery_1_date;
	}
	public void setCrt_delivery_1_date(Date crt_delivery_1_date) {
		this.crt_delivery_1_date = crt_delivery_1_date;
	}
	public Date getCrt_delivery_2_date() {
		return crt_delivery_2_date;
	}
	public void setCrt_delivery_2_date(Date crt_delivery_2_date) {
		this.crt_delivery_2_date = crt_delivery_2_date;
	}
	public Date getCrt_delivery_3_date() {
		return crt_delivery_3_date;
	}
	public void setCrt_delivery_3_date(Date crt_delivery_3_date) {
		this.crt_delivery_3_date = crt_delivery_3_date;
	}
	
	
}
