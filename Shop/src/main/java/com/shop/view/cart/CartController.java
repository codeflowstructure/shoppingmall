package com.shop.view.cart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.shop.biz.cart.CartService;

@Controller
@SessionAttributes("cart")
public class CartController {
	@Autowired
	private CartService cartService;

	
		@RequestMapping(value = "/cart.do", method = RequestMethod.GET)
		public ModelAndView productlist(ModelAndView mav, HttpServletRequest request) {
			
			//mav.addObject("productList", listProductVO);
			mav.setViewName("views_ver_1/cart");
			
			return mav;
		}
}
