package com.shop.biz.account;

import java.sql.SQLException;
import java.util.List;

import com.shop.biz.account.impl.AccountDAO;

public class AccountServiceClient {

	public static void main(String[] args) throws SQLException {
		
		AccountDAO accountDAO = new AccountDAO();
		
		AccountVO vo = new AccountVO();
		
		vo.setAcc_id("user3");
		vo.setAcc_pw("test");
		
		//accountDAO.insertAccount(vo);
		
		List<AccountVO> accountList = accountDAO.getAccountList(vo);
		for (AccountVO account : accountList) {
			System.out.println("--->" + account.toString());
		}

	}

}
