package com.HMT.mood.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.HMT.mood.model.DiaryVO;
import com.HMT.mood.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	DiaryService service;
	
	// 일기 목록 조회
	@RequestMapping("/diary/diaryList/{memNo}")
	public String showDiaryList(@PathVariable int memNo, Model model) {
		ArrayList<DiaryVO> diaryList = service.showDiaryList(memNo);
		model.addAttribute("diaryList", diaryList);
		return "diary/diaryListView";
	}
	
	// 일기 작성 폼 이동 - 해당 날짜로 이동
	@RequestMapping("/diary/diaryForm/{date}")
	public String diaryForm(@PathVariable String date, Model model) {
		// String -> LocalDate 변환
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		// System.out.println(localDate);
		
		// 요일 구하기
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		String day = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
		
		date += (" " + day);  // "2022-01-17 월요일" 형태의 String
		model.addAttribute("date", date);

		return "diary/diaryForm";
	}
}