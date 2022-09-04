package com.shop.biz.cart;

import java.util.List;

import com.shop.biz.cart.CartVO;

public interface CartService {
	// CRUD ����� �޼ҵ� ����
	// īƮ ��� 
	void insertCart(CartVO vo);

	// īƮ ���� 
	void updateCart(CartVO vo);

	// īƮ ���� 
	void deleteCart(CartVO vo);

	// īƮ �� ��ȸ 
	CartVO getCart(CartVO vo);
	
	// īƮ ��� ��ȸ 
	List<CartVO> getCartList(CartVO vo);
	
	// īƮ ��� ��ȸ 
	List<CartVO> getCartList_ByAccount(CartVO vo); 

}
