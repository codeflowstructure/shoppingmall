package com.shop.biz.cart.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.biz.cart.CartVO;
import com.shop.biz.util.SqlSessionFactoryBean;

@Repository
public class CartDAO {
private SqlSession mybatis;
	
	@Autowired
	public CartDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertCart(CartVO vo) {
		mybatis.insert("CartDAO.insertCart", vo);
		mybatis.commit();
	}
	
	public void updateCart(CartVO vo) {
		mybatis.update("CartDAO.updateCart", vo);
		mybatis.commit();
	}
	
	public void deleteCart(CartVO vo) {
		mybatis.delete("CartDAO.deleteCart", vo);
		mybatis.commit();
	}
	
	public CartVO getCart(CartVO vo) {
		return (CartVO) mybatis.selectOne("CartDAO.getCart", vo);
	}
	
	public List<CartVO> getCartList(CartVO vo) {
		return mybatis.selectList("CartDAO.getCartList", vo);
	}
	
	public List<CartVO> getCartList_ByAccount(CartVO vo) {
		return mybatis.selectList("CartDAO.getCartList_ByAccount", vo);
	}
}
