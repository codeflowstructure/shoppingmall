package com.shop.biz.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private int prd_no;
	private int prd_id;
	private String prd_name;
	private int prd_type; // foreign key 
	private String prd_option;
	private String prd_size;
	private String prd_color;
	private int prd_price_1;
	private int prd_price_2;
	private String prd_desc;
	private String prd_image_path;
	private MultipartFile prd_image_file;
	
	public int getPrd_no() {
		return prd_no;
	}
	public void setPrd_no(int prd_no) {
		this.prd_no = prd_no;
	}
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public int getPrd_type() {
		return prd_type;
	}
	public void setPrd_type(int prd_type) {
		this.prd_type = prd_type;
	}
	public String getPrd_option() {
		return prd_option;
	}
	public void setPrd_option(String prd_option) {
		this.prd_option = prd_option;
	}
	public String getPrd_size() {
		return prd_size;
	}
	public void setPrd_size(String prd_size) {
		this.prd_size = prd_size;
	}
	public String getPrd_color() {
		return prd_color;
	}
	public void setPrd_color(String prd_color) {
		this.prd_color = prd_color;
	}
	public int getPrd_price_1() {
		return prd_price_1;
	}
	public void setPrd_price_1(int prd_price_1) {
		this.prd_price_1 = prd_price_1;
	}
	public int getPrd_price_2() {
		return prd_price_2;
	}
	public void setPrd_price_2(int prd_price_2) {
		this.prd_price_2 = prd_price_2;
	}
	public String getPrd_desc() {
		return prd_desc;
	}
	public void setPrd_desc(String prd_desc) {
		this.prd_desc = prd_desc;
	}
	public String getPrd_image_path() {
		return prd_image_path;
	}
	public void setPrd_image_path(String prd_image_path) {
		this.prd_image_path = prd_image_path;
	}
	public MultipartFile getPrd_image_file() {
		return prd_image_file;
	}
	public void setPrd_image_file(MultipartFile prd_image_file) {
		this.prd_image_file = prd_image_file;
	}
	
	
	
}
