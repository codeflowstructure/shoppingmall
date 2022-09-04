package com.shop.biz.product.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shop.biz.product.ProductVO;
import com.shop.biz.util.SqlSessionFactoryBean;

@Repository
public class ProductDAO {
	//@Autowired
	private SqlSession mybatis;
	
	@Autowired
	public ProductDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public void insertProduct(ProductVO vo) {
		mybatis.insert("ProductDAO.insertProduct", vo);
		mybatis.commit();
	}
	
	public void updateProduct(ProductVO vo) {
		mybatis.update("ProductDAO.updateProduct", vo);
		mybatis.commit();
	}
	
	public void deleteProduct(ProductVO vo) {
		mybatis.delete("ProductDAO.deleteProduct", vo);
		mybatis.commit();
	}
	
	public ProductVO getProduct(ProductVO vo) {
		return (ProductVO) mybatis.selectOne("ProductDAO.getProduct", vo);
	}
	
	public ProductVO getProductByPrd_Id(ProductVO vo) {
		return (ProductVO) mybatis.selectOne("ProductDAO.getProductByPrd_Id", vo);
	}
	
	public List<ProductVO> getProductList(ProductVO vo) {
		return mybatis.selectList("ProductDAO.getProductList", vo);
	}
	
	public List<ProductVO> getProductList_By_Prd_Type(ProductVO vo) {
		return mybatis.selectList("ProductDAO.getProductList_By_Prd_Type", vo);
	}
	
}