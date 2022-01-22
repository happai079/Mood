<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="How was your mood today?">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Register</title>
		<link rel="shortcut icon" type="image/x-icon" href="images/diary.ico"/>
		<link href="https://fonts.googleapis.com/css2?family=Gaegu:wght@300;400;700&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<link rel="stylesheet" type="text/css" href="css/register.css">
		<script src="js/jquery-3.6.0.min.js"></script>	
		<script src="js/register.js"></script>
		<script src="<c:url value='js/emailCheck.js'/>"></script>
	</head>
	<body>
		<div id="wrap">
			<div id="logoBox">
				<div class="logoImg"><a href="<c:url value='/'/>"><img src="images/background-circle.png" alt="background-circle"></a></div>
				<h1 class="logoTitle">How was your mood today?</h1>
			</div>
			<div id="verticalline"></div>
			<div id="registerBox">
				<h3 class="registerTitle">Register</h3>
				<form name="registerForm" class="registerForm" method="post" action="/register">
					<label>name<br><input type="text" id="name" name="memName" required/></label>
					<label>email<input type="button" id="emailCheck" value="중복 체크"/><br><input type="email" id="email" name="memEmail" required/></label>
					<input type="hidden" id="isUseable" value="false"/>
					<label>password<br><input type="password" id="pw" name="memPwd" size="12" 
												placeholder="영문, 숫자, 특수문자를 포함하여 6~12자" maxlength="12" required /></label>
					<span id ="alert"></span>
					<label>confirm password<br><input type="password" id="confirm-pw" name="confirm-pw"
					 									size="12" maxlength="12" required/></label>
					<span id ="confirm-alert"></span>
					<input type="submit" value="sign Up" class="submitBtn"/>
				</form>
				<a href="<c:url value='/loginForm'/>" class="bottomBtn">Log in</a>
			</div>
		</div>
	</body>
</html>