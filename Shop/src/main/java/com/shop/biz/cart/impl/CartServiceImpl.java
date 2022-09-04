package com.shop.biz.cart.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.biz.cart.CartService;
import com.shop.biz.cart.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public void insertCart(CartVO vo) {
		cartDAO.insertCart(vo);
	}

	@Override
	public void updateCart(CartVO vo) {
		cartDAO.updateCart(vo);
	}

	@Override
	public void deleteCart(CartVO vo) {
		cartDAO.deleteCart(vo);
	}

	@Override
	public CartVO getCart(CartVO vo) {
		return cartDAO.getCart(vo);
	}

	@Override
	public List<CartVO> getCartList(CartVO vo) {
		return cartDAO.getCartList(vo);
	}

	@Override
	public List<CartVO> getCartList_ByAccount(CartVO vo) {
		return cartDAO.getCartList_ByAccount(vo);
	}

}
