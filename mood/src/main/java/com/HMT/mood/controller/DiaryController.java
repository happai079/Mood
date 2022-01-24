package com.HMT.mood.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

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
	
	/* 달력 클릭시
	 * - 해당 날짜에 작성된 일기가 있으면 일기 조회/수정 폼으로 이동(showDetailDiary/date/)
	 * - 없으면 일기 작성 폼으로 이동(diaryForm/{date})
	 */
	@RequestMapping("/havediary/{date}")
	public String haveDiary(@PathVariable String date, HttpSession session, RedirectAttributes redirectAttr) {
		int memNo = (int) session.getAttribute("sMemNo");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memNo", memNo);
		map.put("diaryDate", date);
		
		Integer diaryNo = service.haveDiary(map);
		
		String result = "";
		if(diaryNo == null) result = "redirect:/diary/diaryForm/" + date;
		else {
			// redirect로 두개 이상 parameter를 보낼 땐,  
			// RedirectAttributes의 addFlashAttribute()를 활용하여 object(map, list, vo 등)에 넣어서 전달
			redirectAttr.addFlashAttribute("diaryMap", map);
			result = "redirect:/diary/showDetailDiary/date";
		}
		
		return result;
	}
	
	// 일기 작성 기능
	@ResponseBody
	@RequestMapping("/diary/insertDiary")
	public String insertDiary(@RequestParam HashMap<String, Object> map) {
		service.insertDiary(map);
		return "redirect:/diary/diaryList/" + map.get("memNo");
	}
	
	// 일기 조회 - diaryNo 기준 (-> list 페이지 : 번호 클릭시) 
	@RequestMapping("/diary/showDetailDiary/no/{diaryNo}")
	public String showDetailDiary(@PathVariable int diaryNo, Model model) {
		DiaryVO dvo = service.showDetailDiaryNo(diaryNo);
		
		if(dvo != null) model.addAttribute("diary", dvo);
		
		// vo의 날짜 String -> LocalDate 변환
		String date = localDate(dvo.getDiaryDate());
		
		model.addAttribute("date", date);
		return "diary/diaryUpdateForm";
	}
	
	// 일기 조회 - date, memNo 기준 (-> index 페이지 : 달력 클릭시)
	@RequestMapping("/diary/showDetailDiary/date")
	public String showDetailDiary(HttpServletRequest request, Model model) {
		// 데이타를 받을 때는 RequestContextUtils의 getInputFlashMap(request) 를 이용해서 받음
		Map<String, ?> requestMap = RequestContextUtils.getInputFlashMap(request);
		HashMap<String, Object> map = (HashMap<String, Object>) requestMap.get("diaryMap");
		
		System.out.println(map);
		DiaryVO dvo = service.showDetailDiaryMap(map);
		if(dvo != null) model.addAttribute("diary", dvo);
		
		// vo의 날짜 String -> LocalDate 변환
		String date = localDate(dvo.getDiaryDate());
		
		model.addAttribute("date", date);
		return "diary/diaryUpdateForm";
	}
	
	// 일기 수정 기능
	@ResponseBody
	@RequestMapping("/diary/updateDiary")
	public String updateDiary(@RequestParam HashMap<String, Object> map) {
		service.updateDiary(map);
		return "redirect:/diary/diaryList/" + map.get("memNo");
	}
	
	// 일기 삭제 기능
	@RequestMapping("/diary/deleteDiary/{diaryNo}")
	public String deleteDiary(@PathVariable int diaryNo, HttpSession session) {
		int memNo = (int) session.getAttribute("sMemNo");
		service.deleteDiary(diaryNo);
		return "redirect:/diary/diaryList/" + memNo;
	}
	
	// 요일 구하는 메서드
	public String localDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		// System.out.println(localDate);
		
		// 요일 구하기
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		String day = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
		
		return date += (" " + day);
	}
}