package com.shop.biz.account;

import java.util.List;

public interface AccountService {
	// CRUD ����� �޼ҵ� ����
	// ȸ�� ��� 
	void insertAccount(AccountVO vo);

	// ȸ�� ���� 
	void updateAccount(AccountVO vo);

	// ȸ�� ���� 
	void updateAccount_PW_Only(AccountVO vo);

	// ȸ�� ���� 
	void updateAccount_Except_PW(AccountVO vo);

	// ȸ�� ���� 
	void deleteAccount(AccountVO vo);

	// ȸ�� �� ��ȸ 
	AccountVO getAccount(AccountVO vo);

	// ȸ�� �� ��ȸ 
	AccountVO getAccountByAcc_Id(AccountVO vo);
	
	// ȸ�� ��� ��ȸ 
	List<AccountVO> getAccountList(AccountVO vo);

}
