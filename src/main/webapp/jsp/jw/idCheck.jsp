<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jw/check.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
<link rel="stylesheet" href="css/jw/login.css" />
</head>
<body>
	<form action="IdCheckC">
		<div>
			<b class="name">ID : </b><input class="text" name="id" maxlength="12"
				placeholder="영문 및 숫자만 4-12자리까지 입력해주세요">
			<button class="sign_up">중복검사</button>
			<br> ${t } <br>
			<input class="sign_up" type="button" value="창 닫기" onClick="window.close()">
		</div>
	</form>
</body>
</html>