package com.HMT.mood.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.HMT.mood.dao.IMemberDAO;
import com.HMT.mood.model.MemberVO;
import com.HMT.mood.model.ProfileVO;

@Service
public class MemberService implements IMemberService {
	@Autowired
	@Qualifier("IMemberDAO")
	IMemberDAO dao;
	
	@Override
	public String emailCheck(String memEmail) {
		return dao.emailCheck(memEmail);
	}
	
	@Override
	public void insertMember(MemberVO memVo) {
		dao.insertMember(memVo);
	}
	
	@Override
	public MemberVO loginCheck(HashMap<String, Object> map) {
		return dao.loginCheck(map);
	}
	
	@Override
	public String getProfile(int memNo) {
		return dao.getProfile(memNo);
	}
	
	@Override
	public void uploadProfile(ProfileVO profileVo) {
		dao.uploadProfile(profileVo);
	}
	
	@Override
	public void updateProfile(ProfileVO profileVo) {
		dao.updateProfile(profileVo);
	}
	
	
	@Override
	public void updateMember(HashMap<String, Object> map) {
		dao.updateMember(map);
	}
	
	@Override
	public void deleteMember(int memNo) {
		dao.deleteMember(memNo);
	}
}
