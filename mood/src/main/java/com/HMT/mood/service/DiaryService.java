package com.HMT.mood.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.HMT.mood.dao.IDiaryDAO;
import com.HMT.mood.model.DiaryVO;

@Service
public class DiaryService implements IDiaryService {
	@Autowired
	@Qualifier("IDiaryDAO")
	IDiaryDAO dao;

	@Override
	public ArrayList<DiaryVO> showDiaryList(int memNo) {
		return dao.showDiaryList(memNo);
	}

	@Override
	public Integer haveDiary(HashMap<String, Object> map) {
		return dao.haveDiary(map);
	}

	@Override
	public void insertDiary(HashMap<String, Object> map) {
		dao.insertDiary(map);
	}
	
	@Override
	public DiaryVO showDetailDiaryNo(int diaryNo) {
		return dao.showDetailDiaryNo(diaryNo);
	}

	@Override
	public DiaryVO showDetailDiaryMap(HashMap<String, Object> map) {
		return dao.showDetailDiaryMap(map);
	}

	@Override
	public void updateDiary(HashMap<String, Object> map) {
		dao.updateDiary(map);
	}
}
