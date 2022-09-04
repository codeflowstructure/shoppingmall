package com.shop.biz.account.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.biz.account.AccountService;
import com.shop.biz.account.AccountVO;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;
	
	@Override
	public void insertAccount(AccountVO vo) {
		accountDAO.insertAccount(vo);

	}

	@Override
	public void updateAccount(AccountVO vo) {
		accountDAO.updateAccount(vo);

	}

	@Override
	public void deleteAccount(AccountVO vo) {
		accountDAO.deleteAccount(vo);

	}

	@Override
	public AccountVO getAccount(AccountVO vo) {
		return accountDAO.getAccount(vo);
	}

	@Override
	public List<AccountVO> getAccountList(AccountVO vo) {
		return accountDAO.getAccountList(vo);
	}

	@Override
	public AccountVO getAccountByAcc_Id(AccountVO vo) {
		return accountDAO.getAccountByAcc_Id(vo);
	}

	@Override
	public void updateAccount_PW_Only(AccountVO vo) {
		accountDAO.updateAccount_PW_Only(vo);
	}

	@Override
	public void updateAccount_Except_PW(AccountVO vo) {
		accountDAO.updateAccount_Except_PW(vo);
	}

}
