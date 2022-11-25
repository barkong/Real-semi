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
	<form name="myForm" action="AccountC" method="post" onsubmit="return call()">
		<fieldset>
			<legend>회원가입</legend>
			<div><b class="name">ID : </b><input class="text" name="id" maxlength="12" placeholder="중복검사를 해주세요">
			<button type="button" class="" onclick="idChk()">중복검사</button><br>
			${t }
			</div>
			<div><b class="name">PW : </b><input class="text" name="pw" maxlength="16" placeholder="영문,대문자 및 숫자를 포함해서 입력해주세요"></div>
			<div><b class="name">PW확인 : </b><input class="text" name="pw2" placeholder="비번 재확인" autocomplete="off" onkeyup="chkPW()"></div>
			<div><b class="name">이름 : </b><input class="text" name="name" placeholder="필수"></div>
			<div><b class="name">생일 : </b><input type="date" name="birth"></div>
			<div><b class="name">성별 : </b> 남<input type="radio" name="gender" value="남" checked="checked"> 여<input type="radio" name="gender" value="여"></div>
			<div><b class="name">email : </b><input class="text" type="email" name="email" size="30" required></div>
			<div><b class="name">전화번호 : </b><input class="text" type="tel" name="phone"></div>
			<div><b class="name">좋아하는 장르 : </b>
			All<input type="checkbox" name="chk" value='all' onclick='selectAll(this)'><br>
			액션<input type="checkbox" name="chk" value="액션"> 
			공포<input type="checkbox" name="chk" value="공포"> 
			로맨스<input type="checkbox" name="chk" value="로맨스"> 
			판타지<input type="checkbox" name="chk" value="판타지"> 
			</div>
			<div><button class="sign_up">가입</button></div>
		</fieldset>
	</form>
</body>
</html>