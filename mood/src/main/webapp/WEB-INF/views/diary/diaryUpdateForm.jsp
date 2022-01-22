<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="How was your mood today?">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Diary 조회/수정</title>
		<link rel="shortcut icon" type="image/x-icon" href="<c:url value='/images/diary.ico'/>"/>
		<link href="https://fonts.googleapis.com/css2?family=Gaegu:wght@300;400;700&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/diary.css'/>">
		<script src="https://kit.fontawesome.com/836510a8a4.js" crossorigin="anonymous"></script>
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>	
		<script src="<c:url value='/js/index.js'/>"></script>	
		<script src="<c:url value='/js/diary.js'/>"></script>
		<script src="<c:url value='/js/profile.js'/>"></script>	
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
				<article id="diary">
					<div id="diaryBox">
						<h3>일기 조회/수정</h3>
						<form id="diaryUpdateForm" name="diaryUpdateForm">
							<c:if test="${ not empty date }"><input type="text" class="todayText" name="diaryDate" readOnly value="${date}" /></c:if>
							<input type="hidden" class="memNo" name="memNo" value="${ sessionScope.sMemNo }"/>
							<c:if test="${ not empty diary }">
							<input type="hidden" class="diaryNo" name="diaryNo" value="${ diary.diaryNo }"/>
								<!-- emoji가 선태되어 있게 -->
								<div class="emojiBox">
									<c:set var="emoji" value="${ diary.diaryEmoji }"/>
									<c:choose>
										<c:when test="${emoji eq 'happy' }">
											<input type="radio" id="happy" value="happy" checked="checked" class="emoji" name="diaryEmoji"/>
											<label class="happy" for="happy"></label>
											<input type="radio" id="soso" value="soso" class="emoji" name="diaryEmoji"/>
											<label class="soso" for="soso"></label>
											<input type="radio" id="sad" value="sad" class="emoji" name="diaryEmoji"/>
											<label class="sad" for="sad"></label>
											<input type="radio" id="angry" value="angry" class="emoji" name="diaryEmoji"/>
											<label class="angry" for="angry"></label>
										</c:when>
										<c:when test="${emoji eq 'soso' }">
											<input type="radio" id="happy" value="happy" class="emoji" name="diaryEmoji"/>
											<label class="happy" for="happy"></label>
											<input type="radio" id="soso" value="soso" checked="checked" class="emoji" name="diaryEmoji"/>
											<label class="soso" for="soso"></label>
											<input type="radio" id="sad" value="sad" class="emoji" name="diaryEmoji"/>
											<label class="sad" for="sad"></label>
											<input type="radio" id="angry" value="angry" class="emoji" name="diaryEmoji"/>
											<label class="angry" for="angry"></label>
										</c:when>
										<c:when test="${emoji eq 'sad' }">
											<input type="radio" id="happy" value="happy"  class="emoji" name="diaryEmoji"/>
											<label class="happy" for="happy"></label>
											<input type="radio" id="soso" value="soso" class="emoji" name="diaryEmoji"/>
											<label class="soso" for="soso"></label>
											<input type="radio" id="sad" value="sad"checked="checked" class="emoji" name="diaryEmoji"/>
											<label class="sad" for="sad"></label>
											<input type="radio" id="angry" value="angry" class="emoji" name="diaryEmoji"/>
											<label class="angry" for="angry"></label>
										</c:when>
										<c:when test="${emoji eq 'angry'}">
											<input type="radio" id="happy" value="happy" class="emoji" name="diaryEmoji"/>
											<label class="happy" for="happy"></label>
											<input type="radio" id="soso" value="soso" class="emoji" name="diaryEmoji"/>
											<label class="soso" for="soso"></label>
											<input type="radio" id="sad" value="sad" class="emoji" name="diaryEmoji"/>
											<label class="sad" for="sad"></label>
											<input type="radio" id="angry" checked="checked" value="angry" class="emoji" name="diaryEmoji"/>
											<label class="angry" for="angry"></label>
										</c:when>
									</c:choose>
								</div>
								<textarea class="diaryText" name="diaryText" row="30" col="10" placeholder="${ diary.diaryText }"></textarea>
							</c:if>
							<div class="bottomBtn">
								<!-- 로그인 전 -->
								<c:if test="${ empty sessionScope.sMemNo }">
									<a href="<c:url value='/loginForm'/>"><button class="loginBtn">로그인</button></a>	
								</c:if>
								<!-- 로그인 후 -->
								<c:if test="${ not empty sessionScope.sMemNo }">
									<input type="submit" value="수정" class="submitBtn"  />
									<input type="reset" value="취소" class="resetBtn"/>
								</c:if>
							</div>
						</form>
					</div>
				</article>
			</section>

			<!-- Bottom -->
			<jsp:include page="/WEB-INF/views/layout/bottom.jsp" flush="true" />
		</div>
	</body>
</html>