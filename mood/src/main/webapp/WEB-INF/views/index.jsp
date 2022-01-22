<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="How was your mood today?">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>감정일기 | How was your mood today?</title>
		<link rel="shortcut icon" type="image/x-icon" href="images/diary.ico"/>
		<link href="https://fonts.googleapis.com/css2?family=Gaegu:wght@300;400;700&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<link rel="stylesheet" type="text/css" href="css/banner.css">
		<link rel="stylesheet" type="text/css" href="css/calendar.css">
		<link rel="stylesheet" type="text/css" href="css/gallery.css">
		<script src="https://kit.fontawesome.com/836510a8a4.js" crossorigin="anonymous"></script>	
		<script src="js/jquery-3.6.0.min.js"></script>
		<script src="js/index.js"></script>
		<script src="js/calendar.js"></script>
		<script src="js/gallery.js"></script>
		<script src="js/profile.js"></script>
		<script type="text/javascript">
		 	$(function(){
		 		// 회원 탈퇴
		 		let memNo = "<%=session.getAttribute("sMemNo") %>";
				$(".withdrawl").on('click', function(){
					let answer = confirm("정말로 탈퇴하시겠습니까?");
					if(answer) location.href="/deleteMember/" + memNo;
				});
		 	})
		</script>
	</head>
	<body>
		<div id="wrap">
			<!-- Modal -->
			<div id="modal">
				<jsp:include page="/WEB-INF/views/modal/profile.jsp" flush="true" />
			</div>
			
			<!-- Top -->
			<jsp:include page="/WEB-INF/views/layout/top.jsp" flush="true" />

			<!-- Content -->
			<section>
				<article id="banner">
					<div id="bannerBox">
						<img src="images/paper.jpg" alt="banner-background">
						<h1>오늘 하루도 수고하셨어요.<br>이제 편히 쉬면서 하루를 마무리해 보세요.</h1>
						<!-- <p>살야야 할 이유를 아는 사람은 어떠한 상황도 견딜 수 있다. - 니체</p> -->
					</div>
				</article>
				<article id="calendar">
					<div id="calendarBox">
						<h1>오늘 느낀 감정을 기록해보세요.</h1>
						<h3>- 달력을 클릭하면 일기를 작성할 수 있어요. -</h3>
						<h2 class="yearMonth"></h2>
						<div class="prevTodayNextBox">
							<i class="fas fa-chevron-left prevMonthBtn"></i>
							<button class="todayBtn">today</button>
							<i class="fas fa-chevron-right nextMonthBtn"></i>
						</div>
						<div class="dateBox">
							<div class="grid daySel">
								<div>일</div>
								<div>월</div>
								<div>화</div>
								<div>수</div>
								<div>목</div>
								<div>금</div>
								<div>토</div>
							</div>
							<div class="grid dateSel"></div>
						</div>
					</div>
				</article>
				<article id="gallery">
					<h1>Gallery</h1>
					<div id="galleryBox">
						<div class="slidePanel">
							<div class="photoCard">
								<img src="images/slide_img_01.jpg" alt="silde image">
								<h3>2021-12-21</h3>
								<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ultricies ac lectus vitae maximus.</span>
							</div>
							<div class="photoCard">
								<img src="images/slide_img_02.jpg" alt="silde image">
								<h3>2021-12-21</h3>
								<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ultricies ac lectus vitae maximus.</span>
							</div>
							<div class="photoCard">
								<img src="images/slide_img_03.jpg" alt="silde image">
								<h3>2021-12-21</h3>
								<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ultricies ac lectus vitae maximus.</span>
							</div>
							<div class="photoCard">
								<img src="images/slide_img_04.jpg" alt="silde image">
								<h3>2021-12-21</h3>
								<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ultricies ac lectus vitae maximus.</span>
							</div>
							<div class="photoCard">
								<img src="images/slide_img_05.jpg" alt="silde image">
								<h3>2021-12-21</h3>
								<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ultricies ac lectus vitae maximus.</span>
							</div>
							<div class="photoCard">
								<img src="images/slide_img_06.jpg" alt="silde image">
								<h3>2021-12-21</h3>
								<span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce ultricies ac lectus vitae maximus.</span>
							</div>
						</div>
					</div>
					<div id="prevNextButtonBox">
						<i class="fas fa-chevron-left prevSlideBtn"></i>
						<i class="fas fa-chevron-right nextSlideBtn"></i>
					</div>
				</article>
			</section>
			
			<!-- Bottom -->
			<jsp:include page="/WEB-INF/views/layout/bottom.jsp" flush="true" />
		</div>
	</body>
</html>