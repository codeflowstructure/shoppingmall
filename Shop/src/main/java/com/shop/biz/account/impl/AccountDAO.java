package com.shop.biz.account.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.biz.account.AccountVO;
import com.shop.biz.util.SqlSessionFactoryBean;

@Repository
public class AccountDAO {
	//@Autowired
	private SqlSession mybatis;
	
	@Autowired
	public AccountDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertAccount(AccountVO vo) {
		mybatis.insert("AccountDAO.insertAccount", vo);
		mybatis.commit();
	}
	
	public void updateAccount(AccountVO vo) {
		mybatis.update("AccountDAO.updateAccount", vo);
		mybatis.commit();
	}
	
	public void updateAccount_PW_Only(AccountVO vo) {
		mybatis.update("AccountDAO.updateAccount_PW_Only", vo);
		mybatis.commit();
	}
	
	public void updateAccount_Except_PW(AccountVO vo) {
		mybatis.update("AccountDAO.updateAccount_Except_PW", vo);
		mybatis.commit();
	}
	
	public void deleteAccount(AccountVO vo) {
		mybatis.delete("AccountDAO.deleteAccount", vo);
		mybatis.commit();
	}
	
	public AccountVO getAccount(AccountVO vo) {
		return (AccountVO) mybatis.selectOne("AccountDAO.getAccount", vo);
	}
	
	public AccountVO getAccountByAcc_Id(AccountVO vo) {
		return (AccountVO) mybatis.selectOne("AccountDAO.getAccountByAcc_Id", vo);
	}
	
	public List<AccountVO> getAccountList(AccountVO vo) {
		return mybatis.selectList("AccountDAO.getAccountList", vo);
	}
}
