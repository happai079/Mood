<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="How was your mood today?">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Diary List</title>
		<link rel="shortcut icon" type="image/x-icon" href="<c:url value='/images/diary.ico'/>"/>
		<link href="https://fonts.googleapis.com/css2?family=Gaegu:wght@300;400;700&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/common.css'/>">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/index.css'/>">
		<link rel="stylesheet" type="text/css" href="<c:url value='/css/diaryList.css'/>">
		<script src="https://kit.fontawesome.com/836510a8a4.js" crossorigin="anonymous"></script>
		<script src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>	
		<script src="<c:url value='/js/index.js'/>"></script>
		<script src="<c:url value='/js/profile.js'/>"></script>
		<script type="text/javascript">
			function deleteCheck(diaryNo){
					var answer = confirm("선택한 일기를 삭제하시겠습니까?");
					if(answer == true){
						// console.log(diaryNo);
						location.href="/diary/deleteDiary/"+diaryNo;
					}
			}
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
				<article id="diaryList">
					<h1 class="title">작성한 일기 목록</h1>
					<a class="writeBtn" href="<c:url value='/havediary/${ sessionScope.today }'/>"><button class="writeDiaryBtn">오늘의 일기 쓰기</button></a>
					
					<!-- 일기 목록 -->
					<div id="diaryListBox">
						<table>
							<tr>
								<th>번호</th>
								<th>날짜</th>
								<th>감정</th>
								<th>내용</th>
								<th>삭제</th>
							</tr>
							
							<c:if test="${ empty diaryList }">
								<tr><td colspan="5">아직 작성된 일기가 없습니다.</td></tr>
							</c:if>
							
							<c:forEach items="${diaryList}" var="diary" varStatus="status">
							   	<tr>
							   		<td><a href="<c:url value='/diary/showDetailDiary/no/${ diary.diaryNo }'/>">${ status.count }</a></td>		   			
							   		<td>${ diary.diaryDate }</td>		   			
							   		<td>${ diary.diaryEmoji }</td>		   			
							   		<td>${ diary.diaryText }</td>
							   		<!-- 삭제 여부 처리 -->
							   		<td><a href="javascript:deleteCheck(${diary.diaryNo});">삭제</a></td>
							   	</tr>
						   </c:forEach>
						</table>
					</div>
				</article>
			</section>

			<!-- Bottom -->
			<jsp:include page="/WEB-INF/views/layout/bottom.jsp" flush="true" />
		</div>
	</body>
</html>