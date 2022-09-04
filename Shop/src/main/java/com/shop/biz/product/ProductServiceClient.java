package com.shop.biz.product;

import java.sql.SQLException;
import java.util.List;

import com.shop.biz.account.AccountVO;
import com.shop.biz.product.impl.ProductDAO;

public class ProductServiceClient {

	public static void main(String[] args) throws SQLException {
		
		ProductDAO productDAO = new ProductDAO();
		
		ProductVO vo = new ProductVO();
		
		vo.setPrd_id(2);
		vo.setPrd_name("테스트 상품");
		vo.setPrd_type(1110);
		vo.setPrd_option(" ");
		vo.setPrd_size("S/M/L/XL"); // String.include 정도로 해결하자.
		vo.setPrd_color("화이트"); // String.include 정도로 해결하자.
		vo.setPrd_price_1(50000);
		vo.setPrd_price_2(30000);
		vo.setPrd_desc(" ");
		vo.setPrd_image_path(" ");
		
		productDAO.insertProduct(vo);
		
		List<ProductVO> productList = productDAO.getProductList(vo);
		for (ProductVO product : productList) {
			System.out.println("--->" + product.toString());
		}

	}
}
