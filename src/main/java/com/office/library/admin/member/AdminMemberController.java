package com.office.library.admin.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	public String createAccountForm() {
		
		System.out.println("[AdminMemberController] createAccountForm() is called...");
		
		return "admin/member/create_account_form";
	}
}
