/**
 * calendar.js
 */

$(function(){
	const date = new Date();
	
	let nowYear = date.getFullYear();
	let nowMonth = date.getMonth();	// 0~11까지
	/*const days = ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'];
	const day = days[date.getDay()];*/
	
	/* 달력 채우기 */
	function makeCalendar(year, month) {
		/*연도, 월 표시*/
		$('.yearMonth').text(`${year}년 ${month+1}월`);
		
		const firstDay = new Date(year,month,1).getDay();		// 이번달 첫째 날의 요일
		const lastDate = new Date(year,month+1,0).getDate();	// 이번달 마지막 날 (다음달의 0번째 일은 이번달의 마지막날과 같다.)
		const lastDay = new Date(year,month+1,0).getDay();	// 이번달 마지막 날의 요일
		
		/* 첫째 날 전까지 공란 */
		for(let i=0; i<firstDay; i++){
			$('.dateSel').append('<div></div>');
		}
		
		/* 날짜 채우기 */
		for(let i=1; i<=lastDate; i++){
			let dateClass = `${year}-${(month+1) < 10? `0${month+1}`: `${month+1}`}-${i <10? `0${i}` : `${i}`}`;
			$('.dateSel').append(`<div class="date ${dateClass}">${i}</div>`);
		}
		
		/* 남은 날 공란 */
		for(let i=6; i>lastDay; i--){
			$('.dateSel').append('<div></div>');
		}
	};
	makeCalendar(nowYear, nowMonth);
	
	/* 오늘 날짜 표시 */
	function checkToday() {
		$('.date').each(function(){
			if($(this).text() == date.getDate() && 
			   nowYear == date.getFullYear() && nowMonth == date.getMonth()){
				$(this).addClass('today');
			}
		})		
	};
	checkToday();
	
	/* 이전 버튼 클릭 */
	$('.prevMonthBtn').on('click', () => {
		$('.dateSel').children().remove();
		
		nowMonth--;
		if(nowMonth === -1) {		// 0월이 되면 이전 연도 12월로 변경
			nowYear--;
			nowMonth += 12;
		}
		
		makeCalendar(nowYear, nowMonth);
		checkToday();
	});
	
	/* 다음 버튼 클릭 */
	$('.nextMonthBtn').on('click', () => {
		$('.dateSel').children().remove();
		
		nowMonth++;
		if(nowMonth === 12) {		// 13월이 되면 다음 연도 1월로 변경
			nowYear++;
			nowMonth -= 12;
		}
		
		makeCalendar(nowYear, nowMonth);
		checkToday();
	});
	
	/* today 버튼 클릭 */
	$('.todayBtn').on('click', () => {
		$('.dateSel').children().remove();
		
		const date = new Date();
	
		nowYear = date.getFullYear();
		nowMonth = date.getMonth();	
		
		makeCalendar(nowYear, nowMonth);
		checkToday();
	});
});	