package com.shop.biz.data;

import java.util.ArrayList;
import java.util.List;

import com.shop.biz.product.ProductVO;
import com.shop.biz.product.impl.ProductDAO;

public class ProductDAOUser {

	public ProductDAO productDAO;


	
	public List<ProductVO> get_List_Product_with_category_1_category_2(String P_Str_Category_1, String P_Str_Category_2) {
		List<ProductVO> ListProductVO = new ArrayList<>();
		
		List<Integer> ListProductTypeNo = ProductDataConverter.Convert_Category_1_Category_2_To_ProductType_No(P_Str_Category_1, P_Str_Category_2);
		
		for (Integer I_ProductTypeNo : ListProductTypeNo) {
			// I_ProductTypeNo를 가지고 Product 테이블에서 검색해서 있는 ProductNo를 모두 꺼내 온다.
			ProductVO vo_for_prd_type = new ProductVO();
			vo_for_prd_type.setPrd_type(I_ProductTypeNo);
			
			//productDAO.getProductList_By_Prd_Type(vo_for_prd_type);
			
			ListProductVO.addAll(productDAO.getProductList_By_Prd_Type(vo_for_prd_type));
		}
		
		return ListProductVO;
	}
}
