package com.shop.biz.product.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.biz.product.ProductService;
import com.shop.biz.product.ProductVO;
import com.shop.biz.product.impl.ProductDAO;
import com.shop.biz.product.ProductService;
import com.shop.biz.product.ProductVO;

import com.shop.biz.data.ProductDataConverter;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public void insertProduct(ProductVO vo) {
		productDAO.insertProduct(vo);

	}

	@Override
	public void updateProduct(ProductVO vo) {
		productDAO.updateProduct(vo);

	}

	@Override
	public void deleteProduct(ProductVO vo) {
		productDAO.deleteProduct(vo);

	}

	@Override
	public ProductVO getProduct(ProductVO vo) {
		return productDAO.getProduct(vo);
	}

	@Override
	public List<ProductVO> getProductList(ProductVO vo) {
		return productDAO.getProductList(vo);
	}

	@Override
	public ProductVO getProductByPrd_Id(ProductVO vo) {
		return productDAO.getProductByPrd_Id(vo);
	}

	@Override
	public List<ProductVO> getProductList_By_Prd_Type(ProductVO vo) {
		return productDAO.getProductList_By_Prd_Type(vo);
	}
}
