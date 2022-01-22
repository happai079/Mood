<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<link rel="stylesheet" type="text/css" href="css/profile.css">
	</head>
	<body>
		<div class="modal_contents">
			<i class="far fa-times-circle cancle"></i>
			<h1>Profile</h1>
			<img src="images/default-profile.png" alt="profileImg"/>
			<form id="profileUpdate" name="profileUpdate" action=""<c:url value='/updateMember'/> enctype="multipart/form-data">
				<!-- 커스텀 파일  -->
				<div class="filebox">
				    <input type="text" class="upload-name" value="첨부파일" placeholder="첨부파일" readOnly>
				    <label for="file">파일찾기</label> 
				    <input type="file" id="file" name="memImg">
				</div>				
				<input type="text" id="name" name="memName" placeholder="이름 : ${ sessionScope.sName }"/><br>
				<input type="submit" value="update" class="submitBtn"/>
			</form>
		</div>
	</body>
</html>