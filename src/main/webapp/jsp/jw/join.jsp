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
	<form name="myForm" action="AccountC" method="post"
		onsubmit="return call()">
		<h2>회원가입</h2>
		<div class="container">
		<div align="center">${t }</div>
			<div class="input-container">
				<b class="name"> ID : </b><input class="text" name="id"
					maxlength="12" placeholder="영문 및 숫자만 4-12자리까지 입력해주세요" value=${y }>
				<button class="idChkbt" type="button" onclick="idChk()">중복검사</button>
			</div>
			
			<div class="input-container">
				<b class="name">PW : </b><input class="text" name="pw"
					type="password" maxlength="16"
					placeholder="영문,대문자 및 숫자를 포함해서 입력해주세요">
			</div>
			<div class="input-container">
				<b class="name">PW확인 : </b><input class="text" name="pw2"
					type="password" placeholder="비밀번호를 확인해주세요" autocomplete="off"
					onkeyup="chkPW()">
			</div>
			<div class="input-container">
				<b class="name">이름 : </b><input class="text" name="name">
			</div>
			<div class="input-container">
				<b class="name">생일 : </b><input type="date" name="birth" required
					pattern="\d{4}-\d{2}-\d{2}">
			</div>
			<div class="input-container">
				<b class="name">성별 : </b> 남<input type="radio" name="gender"
					value="남" checked="checked"> 여<input type="radio"
					name="gender" value="여">
			</div>
			<div class="input-container">
				<b class="name">email : </b><input class="text" type="email"
					name="email" size="30" required>
			</div>
			<div class="input-container">
				<b class="name">전화번호 : </b><input class="text" type="tel"
					name="phone">
			</div>
			<div class="input-container">
				<b class="name">좋아하는 장르 : </b>
				<div style="font-size: 130%">
					All<input type="checkbox" name="chk" value=""
						onclick='selectAll(this)'><br> 액션<input
						type="checkbox" name="chk" value="액션"> 로맨스<input
						type="checkbox" name="chk" value="로맨스"> 판타지<input
						type="checkbox" name="chk" value="판타지"> SF<input
						type="checkbox" name="chk" value="SF"><br> 애니메이션<input
						type="checkbox" name="chk" value="애니메이션"> 공포<input
						type="checkbox" name="chk" value="공포"> 미스터리<input
						type="checkbox" name="chk" value="미스터리"> 호러<input
						type="checkbox" name="chk" value="호러">
				</div>
			</div>
		</div>
		<div class="button-container">
			<button class="sign_up">가입</button>
			<button type="button" class="sign_up" onclick="history.back()">돌아가기</button>
		</div>
		<br>
		<br>
	</form>
</body>
</html>