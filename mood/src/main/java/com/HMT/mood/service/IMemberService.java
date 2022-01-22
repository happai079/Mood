package com.HMT.mood.service;

import java.util.HashMap;

import com.HMT.mood.model.MemberVO;

public interface IMemberService {
	void insertMember(MemberVO memVo);					// 회원 가입
	void deleteMember(String memNo);					// 회원 탈퇴
	void updateMember(HashMap<String, Object> map);		// 회원 정보 수정
	String emailCheck(String memEmail);					// 이메일 중복 체크
	MemberVO loginCheck(HashMap<String, Object> map);	// 로그인
}
