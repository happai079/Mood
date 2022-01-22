package com.HMT.mood.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.HMT.mood.dao.IMemberDAO;
import com.HMT.mood.model.MemberVO;

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
	public void deleteMember(String memNo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(HashMap<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public MemberVO loginCheck(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
