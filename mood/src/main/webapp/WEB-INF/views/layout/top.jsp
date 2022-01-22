<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- Header -->
		<header>
			<div id="headerBox">
				<i class="fas fa-bars sideMenuBar"></i>
				<div class="logoImg"><a href="<c:url value='/'/>"><img src="<c:url value='/images/logo.png'/>" alt="logo"></a></div>
				
				<!-- 로그인 전 -->
				<c:if test="${ empty sessionScope.sMemNo }">
					<div id="topMenuBox" class="active"> 
						<a href="<c:url value='/loginForm'/>">로그인</a>
						<a href="<c:url value='/registerForm'/>">회원가입</a>
					</div>
				</c:if>
				
				<!-- 로그인 후 --> 
				<c:if test="${ not empty sessionScope.sMemNo }">
					<div id="profileBox">
						<div class="profileImg">
							<c:if test="${ not empty sessionScope.sImg }">
								<!-- 외부 파일 경로 설정 및 파일 이름 session에 저장 -->
								<img src="<c:url value='/image/${sessionScope.sImg}'/>" alt="profileImg"/>
							</c:if>
							<c:if test="${ empty sessionScope.sImg }">
								<img src="<c:url value='/images/default-profile.png'/>" alt="profileImg"/>
							</c:if>
						</div>
						<h3 class="profileName">${ sessionScope.sMemName }님</h3>
					</div>
					<button class="myPage">My Page</button>
					<div id="myPageBox">
						<button class="updateProfile">회원 정보 조회/수정</button>
						<button class="updateProfile">회원 탈퇴</button>
					</div>
					<a href="<c:url value='/logout'/>"><button class="logoutBtn">로그아웃</button></a>
				</c:if>
			</div>
		</header>

		<!-- Side Menu -->
		<nav>
			<div id="sideMenuBox">
				<a href="<c:url value='/diary/diaryList/${ sessionScope.sMemNo }'/>"><button class="diaryBtn">diary</button></a>
				<button class="galleryBtn">gallery</button>
			</div>
		</nav>
	</body>
</html>