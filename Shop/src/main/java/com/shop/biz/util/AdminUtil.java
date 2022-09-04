package com.shop.biz.util;

public class AdminUtil {
	public boolean isIdAdmin(String Str_Acc_Id) {
		if (Str_Acc_Id.equals("admin"))
			return true;
		else 
			return false;
	}
}
