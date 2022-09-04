package com.shop.biz.cart;

import java.util.List;

import com.shop.biz.cart.CartVO;

public interface CartService {
	// CRUD 기능의 메소드 구현
	// 카트 등록 
	void insertCart(CartVO vo);

	// 카트 수정 
	void updateCart(CartVO vo);

	// 카트 삭제 
	void deleteCart(CartVO vo);

	// 카트 상세 조회 
	CartVO getCart(CartVO vo);
	
	// 카트 목록 조회 
	List<CartVO> getCartList(CartVO vo);
	
	// 카트 목록 조회 
	List<CartVO> getCartList_ByAccount(CartVO vo); 

}
