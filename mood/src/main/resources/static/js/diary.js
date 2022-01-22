/**
 * diary.js
 */

$(function(){
	/* submit 버튼 클릭 - ajax 처리 */
	$('#diaryForm').on('submit', function(){
		// event.preventDefault();		
		let memNo = $('.memNo').val();
		let formData = $('#diaryForm').serialize();
		$.ajax({
			type: 'post',
			url: 'writeDiary',
			data: formData,
			success: function(){
				alert("일기 작성을 성공했습니다.\n일기 목록 페이지로 이동합니다.");
				location.href="/diary/diaryList/"+memNo;
			},
			error: function(){
				alert("전송 실패");
			}
		})
	});

	/* submit 버튼 클릭 - ajax 처리 */
	$('#diaryUpdateForm').on('submit', function(){
		// event.preventDefault();
		let formData = $('#diaryUpdateForm').serialize();
		console.log(formData)		
		$.ajax({
			type: 'post',
			url: 'updateDiary',
			data: formData,
			success: function(){
				alert("일기 수정을 성공했습니다.\n일기 목록 페이지로 이동합니다.");
				location.href="/diary/diaryList/"+$('.memNo').val();
			},
			error: function(){
				alert("전송 실패");
			}
		})
	});
	
	/* reset 버튼 클릭 - 다이어리 목록 페이지로 이동*/
	$('.resetBtn').on('click', () => {
		let memNo = $('.memNo').val();
		alert("일기 작성을 취소합니다.\n일기 목록 페이지로 이동합니다.");
		location.href="/diary/diaryList/"+memNo;
	});
});