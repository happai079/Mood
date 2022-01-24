package com.HMT.mood.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.HMT.mood.model.MemberVO;
import com.HMT.mood.model.ProfileVO;
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
	
	// 로그인 처리 : email와 pwd 전달 받아서 로그인 체크
	@ResponseBody
	@RequestMapping("/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) {
		MemberVO member = service.loginCheck(param);
		String loginResult = "fail";
		
		if(member != null) {
			session.setAttribute("sMemNo", member.getMemNo());
			session.setAttribute("sMemName", member.getMemName());
			loginResult = "success";
			
			// DB에서 profile 정보 가져와서 session에 저장
			String file = service.getProfile(member.getMemNo());
			if(file != null) session.setAttribute("sProfile", file);
			
			// System.out.println(file);
		}

		return loginResult;
	}
	
	// 로그아웃 처리
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원 정보 수정 처리
	@ResponseBody
	@RequestMapping("/updateMember")
	public String[] faceRecog(@RequestParam("uploadProfile") MultipartFile file, 
						    @RequestParam("profile") String profile,
						    @RequestParam("memNo") int memNo,
						    @RequestParam("memName") String name,
						    HttpSession session) throws IOException {
		
		// System.out.println(file);
		// System.out.println(profile); 
		// System.out.println(name);
		// System.out.println(memNo);
		
		
		String savedFileName = "";
		// 1. 파일 저장 경로 설정: 실제 서비스되는 위치(프로젝트 외부에 저장)(파일 서버)
		String uploadPath = "C:/Mood/mood_file/";
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		
		// 3. 파일 이름 중복되지 않도록 이름 변경 : 서버에 저장할 이름 UUID 사용
		UUID uuid = UUID.randomUUID();
		savedFileName = uuid.toString() + "_" + originalFileName;
		
		String filePathName = uploadPath + savedFileName;
		
		// 4. 파일 생성
		File file1 = new File(filePathName);
		
		// 5. 서버로 전송
		file.transferTo(file1);
		
		// 6. 파일 정보를 ProfileVO에 담아 DB에 저장
		ProfileVO profileVo = new ProfileVO();
		profileVo.setServerFileName(savedFileName);
		profileVo.setOriginFileName(originalFileName);
		profileVo.setFilePath(filePathName);
		profileVo.setMemNo(memNo);
		
		if(profile.isEmpty() || profile == null) {
			// System.out.println("===uploadProfile===");
			service.uploadProfile(profileVo); 
			session.setAttribute("sProfile", savedFileName);
		}
		else {
			// System.out.println("===updateProfile===");
			// 기존 파일 삭제
			removeFile(session.getAttribute("sProfile"));
			
			// 새로 저장
			service.updateProfile(profileVo);
			session.setAttribute("sProfile", savedFileName);
		}
		
		// 7. memName update - 성공
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("memName", name);
		map.put("memNo", memNo);
		service.updateMember(map);
		session.setAttribute("sMemName", name);
		
		String[] result = {savedFileName, name};
		return result;
	}
	
	// 회원 탈퇴
	@RequestMapping("/deleteMember/{memNo}")
	public String deleteMember(@PathVariable int memNo, HttpSession session) {
		// 파일 삭제
		removeFile(session.getAttribute("sProfile"));
		
		service.deleteMember(memNo);
		session.invalidate();
		return "redirect:/";
	}
	
	// 서버에서 파일 삭제 메서드
	public void removeFile(Object filePathName) {
		// 서버에서 파일 삭제
		String deletePath = "C:/Mood/mood_file/";
		String filePath = deletePath + filePathName;
		File deleteFile = new File(filePath);
		
		if(deleteFile.exists()) {
            deleteFile.delete(); 
            // System.out.println("파일을 삭제하였습니다.");
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
	}
}
