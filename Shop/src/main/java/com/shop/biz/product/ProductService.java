package com.shop.biz.product;

import java.util.List;

import com.shop.biz.product.ProductVO;

public interface ProductService {
	// CRUD 기능의 메소드 구현
	// 상품 등록 
	void insertProduct(ProductVO vo);

	// 상품 수정 
	void updateProduct(ProductVO vo);

	// 상품 삭제 
	void deleteProduct(ProductVO vo);

	// 상품 상세 조회 
	ProductVO getProduct(ProductVO vo);

	// 상품 상세 조회 
	ProductVO getProductByPrd_Id(ProductVO vo);
	
	// 상품 목록 조회 
	List<ProductVO> getProductList(ProductVO vo);
	
	// 상품 목록 조회 
	List<ProductVO> getProductList_By_Prd_Type(ProductVO vo);
}

