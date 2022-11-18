<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jw/check.js"></script>
</head>
<body>
${r }
		<form action="LoginC" method="post"  onsubmit="return call()">
		ID <input name="id">
		PW <input name="pw">
		<button>로그인</button>
		<button onclick="location.href='AccountC'" type="button">회원가입</button>
		</form>
</body>
</html>