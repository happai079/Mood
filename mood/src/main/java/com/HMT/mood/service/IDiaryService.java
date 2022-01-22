package com.HMT.mood.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.HMT.mood.model.DiaryVO;

public interface IDiaryService {
	ArrayList<DiaryVO> showDiaryList(int memNo);		// 일기 조회
	DiaryVO showDetailDiary(String diaryNo);			// 일기 상세 조회
	Integer haveDiary(HashMap<String, Object> map);		// 해당 날짜의 일기가 있는지 없는지 조회
	// void insertDiray(HashMap<String, Object> map);
	// void updateDiary(HashMap<String, Object> map);
	// void deleteDiary(String diaryNo);
}
