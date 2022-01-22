package com.HMT.mood.service;

import java.util.HashMap;

import com.HMT.mood.model.MemberVO;
import com.HMT.mood.model.ProfileVO;

public interface IMemberService {
	String emailCheck(String memEmail);					// 이메일 중복 체크
	void insertMember(MemberVO memVo);					// 회원 가입
	MemberVO loginCheck(HashMap<String, Object> map);	// 로그인
	String getProfile(int memNo);						// 프로필 사진 경로 가져오기
	void uploadProfile(ProfileVO profileVo);			// 프로필 사진 추가
	void updateProfile(ProfileVO profileVo);			// 프로필 사진 수정
	void updateMember(HashMap<String, Object> map);		// 회원 정보 수정
	void deleteMember(int memNo);						// 회원 탈퇴
}	
