package com.HMT.mood.model;

public class DiaryVO {
	private int diaryNo;
	private String diaryDate;
	private String diaryEmoji;
	private String diaryText;
	private int memNo;
	
	public int getDiaryNo() {
		return diaryNo;
	}
	public void setDiaryNo(int diaryNo) {
		this.diaryNo = diaryNo;
	}
	public String getDiaryDate() {
		return diaryDate;
	}
	public void setDiaryDate(String diaryDate) {
		this.diaryDate = diaryDate;
	}
	public String getDiaryEmoji() {
		return diaryEmoji;
	}
	public void setDiaryEmoji(String diaryEmoji) {
		this.diaryEmoji = diaryEmoji;
	}
	public String getDiaryText() {
		return diaryText;
	}
	public void setDiaryText(String diaryText) {
		this.diaryText = diaryText;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
}
