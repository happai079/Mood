package com.HMT.mood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HMT.mood.model.MemberVO;
import com.HMT.mood.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	// 로그인 폼으로 이동
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	// 회원 가입 폼으로 이동
	@RequestMapping("/registerForm")
	public String registerForm() {
		return "member/registerForm";
	}
	
	// 이메일 중복 체크
	@ResponseBody
	@RequestMapping("/emailCheck")
	public String emailCheck(@RequestParam("memEmail") String email) {
		String emailCheck = service.emailCheck(email);
		
		String result = "use";
		if(emailCheck != null) result = "no_use";
		
		return result;
	}
	
	// 회원 가입 처리
	@RequestMapping("/register")
	public String insertMember(MemberVO memVo) {
		service.insertMember(memVo);
		return "redirect:/loginForm";	
	}
}
