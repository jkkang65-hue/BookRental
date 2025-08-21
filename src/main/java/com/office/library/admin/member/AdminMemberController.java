package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@Autowired
	AdminMemberService adminMemberService;
	
	@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	public String createAccountForm() {
		
		System.out.println("[AdminMemberController] createAccountForm() is called...");
		
		return "admin/member/create_account_form";
	}
	
	@RequestMapping(value = "/createAccountConfirm", method = RequestMethod.POST)
	public String createAccountConfirm(AdminMemberVo adminMemberVo) {
		
		System.out.println("[AdminMemberController] createAccountConfirm() is called...");
		
		int result = adminMemberService.createAccountConfirm(adminMemberVo);
		
		if (result <= 0) 
			return "admin/member/create_account_ng";
		
		return "admin/member/create_account_ok";
	}
	
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm() {
		
		System.out.println("[AdminMemberController] loginForm() is called...");
		
		return "admin/member/login_form";
	}
	
	@RequestMapping(value = "/loginConfirm", method = RequestMethod.POST)
	public String loginConfirm(AdminMemberVo adminMemberVo) {
		
		System.out.println("[AdminMemberController] loginConfirm() is called...");
		
		AdminMemberVo loginedAdminMemberVo = adminMemberService.loginConfirm(adminMemberVo);
		
		if (loginedAdminMemberVo == null) {
			return "admin/member/login_ng";	
		}
		
		return "admin/member/login_ok";
		
	}
}
