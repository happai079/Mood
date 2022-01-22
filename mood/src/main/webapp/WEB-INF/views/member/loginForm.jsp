<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>	
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="How was your mood today?">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Login</title>
		<link rel="shortcut icon" type="image/x-icon" href="images/diary.ico"/>
		<link href="https://fonts.googleapis.com/css2?family=Gaegu:wght@300;400;700&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/common.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script src="js/jquery-3.6.0.min.js"></script>
		<script src="js/login.js"></script>	
	</head>
	<body>
		<div id="wrap">
			<div id="logoBox">
				<div class="logoImg"><a href="<c:url value='/'/>"><img src="images/background-circle.png" alt="background-circle"></a></div>
				<h1 class="logoTitle">How was your mood today?</h1>
			</div>
			<div id="verticalline"></div>
			<div id="loginBox">
				<h3 class="loginTitle">Welcome</h3>
				<form name="loginForm" class="loginForm">
					<input type="email" id="email" name="memEmail" placeholder="email" required/>
					<input type="password" id="pw" name="memPwd" placeholder="******" maxlength="12" required/>
					<span id ="alert"></span>
					<input type="submit" class="submitBtn" value="LogIn" />
				</form>
				<a href="#" class="bottomBtn">Forgotten your password?</a>
				<a href="<c:url value='/registerForm'/>" class="bottomBtn">Register</a>
			</div>
		</div>
	</body>
</html>