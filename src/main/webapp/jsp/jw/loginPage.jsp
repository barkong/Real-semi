<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jw/login.css" />
<script type="text/javascript" src="js/jw/check.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
		<form action="LoginC" method="post"  onsubmit="return call()">
		<b class="name">&nbsp;ID&nbsp;</b><input name="id"><br>
		<b class="name">PW</b><input name="pw"><br>
		<button class="sign_up">로그인</button>
		<button class="sign_up" onclick="location.href='AccountC'" type="button">회원가입</button>
		</form>
</body>
</html>