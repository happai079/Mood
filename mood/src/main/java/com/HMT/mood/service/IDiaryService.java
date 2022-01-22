package com.HMT.mood.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.HMT.mood.model.DiaryVO;

public interface IDiaryService {
	ArrayList<DiaryVO> showDiaryList(int memNo);				// 일기 조회
	Integer haveDiary(HashMap<String, Object> map);				// 해당 날짜의 일기가 있는지 없는지 조회
	void insertDiary(HashMap<String, Object> map);				// 일기 작성
	DiaryVO showDetailDiaryNo(int diaryNo);						// 일기 상세 조회 - diaryNo 기준
	DiaryVO showDetailDiaryMap(HashMap<String, Object> map);	// 일기 상세 조회 - date, memNo 기준
	void updateDiary(HashMap<String, Object> map);				// 일기 수정
	void deleteDiary(int diaryNo);								// 일기 삭제
}
