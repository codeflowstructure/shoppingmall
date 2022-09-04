package com.shop.biz.product;

import java.util.List;

import com.shop.biz.product.ProductVO;

public interface ProductService {
	// CRUD ����� �޼ҵ� ����
	// ��ǰ ��� 
	void insertProduct(ProductVO vo);

	// ��ǰ ���� 
	void updateProduct(ProductVO vo);

	// ��ǰ ���� 
	void deleteProduct(ProductVO vo);

	// ��ǰ �� ��ȸ 
	ProductVO getProduct(ProductVO vo);

	// ��ǰ �� ��ȸ 
	ProductVO getProductByPrd_Id(ProductVO vo);
	
	// ��ǰ ��� ��ȸ 
	List<ProductVO> getProductList(ProductVO vo);
	
	// ��ǰ ��� ��ȸ 
	List<ProductVO> getProductList_By_Prd_Type(ProductVO vo);
}

