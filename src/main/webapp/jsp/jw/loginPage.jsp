<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jw/login.css" />
<link rel="stylesheet" href="css/jw/loginPage.css" />
<script type="text/javascript" src="js/jw/check.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
	<div class="login-wrapper">
		<h2 class="loginT">Login</h2>
		<form name="myForm" action="LoginC" method="post" onsubmit="return call2()" id="login-form">
			<div align="center">${r }</div>
			<input name="id" type="text" placeholder="ID"><br>
			<input name="pw" type="password" placeholder="PW"><br><br>
			<button class="sign_up">로그인</button>
			<button class="sign_up" onclick="location.href='AccountC'" type="button">회원가입</button>
		</form>
	</div>
</body>
</html>