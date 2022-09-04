package com.shop.view.account;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.shop.biz.account.AccountService;
import com.shop.biz.account.AccountVO;
import com.shop.biz.account.impl.AccountDAO;

@Controller
@SessionAttributes("account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	


		// 회원 등록 
		@RequestMapping(value = "/signin", method = RequestMethod.GET)
		public String signin(Locale locale, Model model) {
			
			return "views_ver_1/signin";
		}
		
		@RequestMapping(value="/insertAccount.do", method = RequestMethod.POST )
		public String insertBoard(AccountVO vo, HttpSession session) throws IOException {
			System.out.println("회원 등록 처리");
			
			
			System.out.println(vo.toString());
			
			accountService.insertAccount(vo);
			
			session.setAttribute("accountAcc_Id", vo.getAcc_id());
			
			return "redirect:index.do";
		}

		
		// 로그인 
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String login(Locale locale, Model model) {
			
			return "views_ver_1/login";
		}
		
		@RequestMapping(value="/login.do", method = RequestMethod.POST )
		public String login(AccountVO vo, AccountDAO accountDAO, HttpSession session) throws IOException {
			System.out.println("로그인 처리");
			if(vo.getAcc_id() == null || vo.getAcc_id().equals("")) {
				throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
			}
			
			AccountVO account = accountDAO.getAccountByAcc_Id(vo);
			
			//System.out.println(vo.toString());
			//System.out.println(account.toString());
			
			if(account != null && account.getAcc_pw().equals(vo.getAcc_pw())) {
				session.setAttribute("accountAcc_Id", account.getAcc_id());
				System.out.println("로그인 성공!!");
				return "redirect:index.do";
			}
			else {
				System.out.println("로그인 실패");
				return "redirect:login.do";
			}
		}
		

		// 로그아웃 

		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logout(HttpSession session) {
			
			session.invalidate();

			return "redirect:index.do";
		}
		
		

		// 마이페이지 
		@RequestMapping(value = "/mypage", method = RequestMethod.GET)
		public String mypage(Locale locale, Model model) {
			
			return "views_ver_1/mypage";
		}

		

		@RequestMapping(value = "/mypage_account", method = RequestMethod.GET)
		public String mypage_account(Locale locale, Model model, HttpSession httpSession) {
			if(httpSession.getAttribute("accountAcc_Id") == null || httpSession.getAttribute("accountAcc_Id").equals("")) {
				return "redirect:index.do";
			}
			
			String Str_AccountAcc_Id = httpSession.getAttribute("accountAcc_Id").toString();
			
			AccountVO vo = new AccountVO();
			vo.setAcc_id(Str_AccountAcc_Id);
			
			model.addAttribute("account", accountService.getAccountByAcc_Id(vo));
			
			return "views_ver_1/mypage_account";
		}

		@RequestMapping(value = "/mypage_delivery", method = RequestMethod.GET)
		public String mypage_delivery(Locale locale, Model model) {
			
			return "views_ver_1/mypage_delivery";
		}

		@RequestMapping(value = "/mypage_review", method = RequestMethod.GET)
		public String mypage_review(Locale locale, Model model) {
			
			return "views_ver_1/mypage_review";
		}
		

		@RequestMapping(value = "/updateAccount_except_pw", method = RequestMethod.POST)
		public String updateAccount_except_pw(Locale locale, Model model, HttpSession httpSession, HttpServletRequest request) throws UnsupportedEncodingException {
			if(httpSession.getAttribute("accountAcc_Id") == null || httpSession.getAttribute("accountAcc_Id").equals("")) {
				return "redirect:index.do";
			}
			request.setCharacterEncoding("UTF-8");
			
			System.out.println(request.getParameter("acc_address").toString());
			
			String Str_AccountAcc_Id = httpSession.getAttribute("accountAcc_Id").toString();
			AccountVO vo = new AccountVO();
			vo.setAcc_id(Str_AccountAcc_Id);
			vo = accountService.getAccountByAcc_Id(vo);
					
			vo.setAcc_address(request.getParameter("acc_address").toString());
			vo.setAcc_phone_mobile(request.getParameter("acc_phone_mobile").toString());
			vo.setAcc_phone_home(request.getParameter("acc_phone_home").toString());
			
			accountService.updateAccount_Except_PW(vo);
			
			return "redirect:mypage_account.do";
		}

		@RequestMapping(value = "/updateAccount_pw_only", method = RequestMethod.POST)
		public String updateAccount_pw_only(Locale locale, Model model, HttpSession httpSession, HttpServletRequest request) throws UnsupportedEncodingException {
			if(httpSession.getAttribute("accountAcc_Id") == null || httpSession.getAttribute("accountAcc_Id").equals("")) {
				return "redirect:index.do";
			}
			request.setCharacterEncoding("UTF-8");
			
			String Str_AccountAcc_Id = httpSession.getAttribute("accountAcc_Id").toString();
			AccountVO vo = new AccountVO();
			vo.setAcc_id(Str_AccountAcc_Id);
			vo = accountService.getAccountByAcc_Id(vo);
			
			vo.setAcc_pw(request.getParameter("acc_pw").toString());
			
			accountService.updateAccount_PW_Only(vo);

			return "redirect:mypage_account.do";
		}

		@RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
		public String deleteAccount(Locale locale, Model model, HttpSession httpSession, HttpServletRequest request) {
			if(httpSession.getAttribute("accountAcc_Id") == null || httpSession.getAttribute("accountAcc_Id").equals("")) {
				return "redirect:index.do";
			}
			
			String Str_AccountAcc_Id = httpSession.getAttribute("accountAcc_Id").toString();
			AccountVO vo = new AccountVO();
			vo.setAcc_id(Str_AccountAcc_Id);
			vo = accountService.getAccountByAcc_Id(vo);
			
			
			accountService.deleteAccount(vo);
			
			httpSession.invalidate();

			return "redirect:index.do";
		}
		
		

		// 관리자페이지 
		@RequestMapping(value = "/adminpage", method = RequestMethod.GET)
		public String adminpage(Locale locale, Model model) {
			
			return "views_ver_1/adminpage";
		}
		
		@RequestMapping(value = "/adminpage_insertproduct", method = RequestMethod.GET)
		public String adminpage_insertproduct(Locale locale, Model model) {
			
			return "views_ver_1/adminpage_insertproduct";
		}

		@RequestMapping(value = "/adminpage_trade", method = RequestMethod.GET)
		public String adminpage_trade(Locale locale, Model model) {
			
			return "views_ver_1/adminpage_trade";
		}

		
}
