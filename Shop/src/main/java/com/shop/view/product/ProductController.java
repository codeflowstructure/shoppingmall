package com.shop.view.product;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shop.biz.data.ProductDataConverter;
import com.shop.biz.product.ProductService;
import com.shop.biz.product.ProductVO;
import com.shop.biz.product.impl.ProductDAO;
import com.shop.biz.tempcart.TempCartProductVO;

@Controller
@SessionAttributes("product")
public class ProductController {
	@Autowired
	private ProductService productService;

	
		@RequestMapping(value = "/productlist.do", method = RequestMethod.GET)
		public ModelAndView productlist(ProductVO vo, ProductDAO productDAO, ModelAndView mav, HttpServletRequest request) {
			
			ProductVO vo_for_product_type = new ProductVO();
			
			String StrCategory_1 = "5";
			if (request.getParameter("category_1") != null) {
				StrCategory_1 = request.getParameter("category_1").toString();
			}
			String StrCategory_2 = "0";
			if (request.getParameter("category_2") != null) {
				StrCategory_2 = request.getParameter("category_2").toString();
			}
			
			List<Integer> list_ProductTypeNo = ProductDataConverter.Convert_Category_1_Category_2_To_ProductType_No(StrCategory_1, StrCategory_2);
			
			List<ProductVO> listProductVO = new ArrayList<>();
			
			for (Integer productTypeNo : list_ProductTypeNo) {
				
				vo_for_product_type.setPrd_type(productTypeNo);
				
				List<ProductVO> listProductVO_Searched = productDAO.getProductList_By_Prd_Type(vo_for_product_type);
				
				if (listProductVO_Searched != null && listProductVO_Searched.size() >= 1) {
					listProductVO.addAll(listProductVO_Searched);
				}
			}
			
			mav.addObject("productList", listProductVO);
			mav.setViewName("views_ver_1/productlist.jsp" + "?" + "category_1=" + StrCategory_1 + "&&" + "category_2=" + StrCategory_2);
			
			return mav;
		}
		
		@RequestMapping(value = "/productdetail.do", method = RequestMethod.GET)
		public ModelAndView productdetail(ProductVO vo, ProductDAO productDAO, ModelAndView mav, HttpServletRequest request) {

			String StrCategory_1 = "5";
			if (request.getParameter("category_1") != null) {
				StrCategory_1 = request.getParameter("category_1").toString();
			}
			String StrCategory_2 = "0";
			if (request.getParameter("category_2") != null) {
				StrCategory_2 = request.getParameter("category_2").toString();
			}
			String StrProductId = "1";
			if (request.getParameter("product_id") != null) {
				StrProductId = request.getParameter("product_id").toString();
			}

			ProductVO vo_with_prd_id = new ProductVO();
			vo_with_prd_id.setPrd_id(Integer.parseInt(StrProductId));
			vo = productDAO.getProductByPrd_Id(vo_with_prd_id);
			
			mav.addObject("product", vo);
			mav.setViewName("views_ver_1/productdetail.jsp" + "?" + "category_1=" + StrCategory_1 + "&&" + "category_2=" + StrCategory_2 + "&&" + "product_id=" + StrProductId);
			
			return mav;
		}
		

		@RequestMapping(value = "/productdetail_addcart.do", method = RequestMethod.POST)
		public ModelAndView productdetail_addcart(ProductVO vo, ProductDAO productDAO, ModelAndView mav, HttpServletRequest request, HttpSession session) {

			String StrCategory_1 = "5";
			if (request.getParameter("category_1") != null) {
				StrCategory_1 = request.getParameter("category_1").toString();
			}
			String StrCategory_2 = "0";
			if (request.getParameter("category_2") != null) {
				StrCategory_2 = request.getParameter("category_2").toString();
			}
			String StrProductId = "1";
			if (request.getParameter("product_id") != null) {
				StrProductId = request.getParameter("product_id").toString();
			}

			ProductVO vo_with_prd_id = new ProductVO();
			vo_with_prd_id.setPrd_id(Integer.parseInt(StrProductId));
			vo = productDAO.getProductByPrd_Id(vo_with_prd_id);
			
			
			// AddCart 처리 관련. 
			// TempCartProductVO에 상품NO와 사이즈선택 색상선택 담아서 세션 장바구니에 담는다. 
			
			TempCartProductVO tempCartProductVo = new TempCartProductVO();
			
			int prd_no = Integer.valueOf(request.getParameter("prd_no").toString());
			tempCartProductVo.setPrd_no(prd_no); 
			
			if (request.getParameter("prd_name") != null) {
				tempCartProductVo.setPrd_name(request.getParameter("prd_name").toString());
			} else {
				tempCartProductVo.setPrd_name("");
			}
			
			if (request.getParameter("prd_image_path") != null) {
				tempCartProductVo.setPrd_image_path(request.getParameter("prd_image_path").toString());
			} else {
				tempCartProductVo.setPrd_image_path("");
			}
			
			if (request.getParameter("prd_option") != null) {
				tempCartProductVo.setPrd_option(request.getParameter("prd_option").toString());
			} else {
				tempCartProductVo.setPrd_option("");
			}
			
			if (request.getParameter("prd_size") != null) {
				tempCartProductVo.setPrd_size(request.getParameter("prd_size").toString());
			} else {
				tempCartProductVo.setPrd_size("");
			}
			
			if (request.getParameter("prd_color") != null) {
				tempCartProductVo.setPrd_color(request.getParameter("prd_color").toString());
			} else {
				tempCartProductVo.setPrd_color("");
			}
			
			if (request.getParameter("prd_price_1") != null) {
				tempCartProductVo.setPrd_price_1(request.getParameter("prd_price_1").toString());
			} else {
				tempCartProductVo.setPrd_price_1("");
			}
			
			if (request.getParameter("prd_price_2") != null) {
				tempCartProductVo.setPrd_price_2(request.getParameter("prd_price_2").toString());
			} else {
				tempCartProductVo.setPrd_price_2("");
			}
			
			
			List<TempCartProductVO> ListTempCartProductVoInSession;
			if (session.getAttribute("TempCartList") != null) {
				ListTempCartProductVoInSession = (List<TempCartProductVO>)session.getAttribute("TempCartList");
			} else {
				ListTempCartProductVoInSession = new ArrayList<>();
			}
			ListTempCartProductVoInSession.add(tempCartProductVo);
			session.setAttribute("TempCartList", ListTempCartProductVoInSession);
			
			// AddCart 처리 관련 끝. 
			
			//mav.addObject("product", vo);
			//mav.setViewName("views_ver_1/productdetail.jsp" + "?" + "category_1=" + StrCategory_1 + "&&" + "category_2=" + StrCategory_2 + "&&" + "product_id=" + StrProductId);
			mav.setViewName("redirect:" + "cart.do");
			
			return mav;
		}
	
	


		// 상품 등록 
		@RequestMapping(value = "/adminpage_insertproduct_proc", method = RequestMethod.GET)
		public String signin(Locale locale, Model model) {
			
			return "redirect:adminpage_insertproduct.do";
		}
		
		@RequestMapping(value="/adminpage_insertproduct_proc.do", method = RequestMethod.POST )
		public String adminpage_insertproduct_proc(ProductVO vo, HttpSession session, HttpServletRequest request) throws UnsupportedEncodingException, IOException  {
			System.out.println("상품 등록 처리");
			
			request.setCharacterEncoding("UTF-8");
			
			
			System.out.println("상품명: " + vo.getPrd_name());
			
			// 파일 업로드 처리
			MultipartFile uploadFile = vo.getPrd_image_file();
			if(!uploadFile.isEmpty()) {
				String fileName = uploadFile.getOriginalFilename();
				uploadFile.transferTo(new File("/myimages/shop/products/" + fileName));

				vo.setPrd_image_path("/myimages/shop/products/" + uploadFile.getOriginalFilename());
			} else {
				vo.setPrd_image_path("");
			}
			
			System.out.println(vo.toString());
			
			productService.insertProduct(vo);
			
			return "redirect:adminpage_insertproduct.do";
		}

}
