package com.shop.biz.account;

import java.util.List;

public interface AccountService {
	// CRUD 기능의 메소드 구현
	// 회원 등록 
	void insertAccount(AccountVO vo);

	// 회원 수정 
	void updateAccount(AccountVO vo);

	// 회원 수정 
	void updateAccount_PW_Only(AccountVO vo);

	// 회원 수정 
	void updateAccount_Except_PW(AccountVO vo);

	// 회원 삭제 
	void deleteAccount(AccountVO vo);

	// 회원 상세 조회 
	AccountVO getAccount(AccountVO vo);

	// 회원 상세 조회 
	AccountVO getAccountByAcc_Id(AccountVO vo);
	
	// 회원 목록 조회 
	List<AccountVO> getAccountList(AccountVO vo);

}
