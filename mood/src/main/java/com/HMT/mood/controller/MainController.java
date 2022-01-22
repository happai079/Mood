package com.HMT.mood.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String indexView(HttpSession session) {
		// 오늘 날짜 구해서 session에 저장
		LocalDate now = LocalDate.now();
		
		session.setAttribute("today", now);
		return "index";
	}
}
