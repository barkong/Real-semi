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
			<div><b class="name">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			ID : &nbsp;&nbsp;&nbsp;</b><input class="text" name="id" maxlength="12" placeholder="중복검사를 해주세요">
			<button type="button" class="" onclick="idChk()">중복검사</button><br>
			${t }
			</div>
			<div><b class="name">&nbsp;&nbsp;PW : &nbsp;&nbsp;&nbsp;</b><input class="text" name="pw" maxlength="16" placeholder="영문,대문자 및 숫자를 포함해서 입력해주세요"></div>
			<div><b class="name">PW확인 : </b><input class="text" name="pw2" placeholder="비밀번호를 확인해주세요" autocomplete="off" onkeyup="chkPW()"></div>
			<div><b class="name">&nbsp;이름 : &nbsp;&nbsp;&nbsp;</b><input class="text" name="name"></div>
			<div><b class="name">생일 : </b><input type="date" name="birth" required pattern="\d{4}-\d{2}-\d{2}"></div>
			<div><b class="name">성별 : </b> 남<input type="radio" name="gender" value="남" checked="checked"> 여<input type="radio" name="gender" value="여"></div>
			<div><b class="name">&nbsp;email : &nbsp;&nbsp;&nbsp;</b><input class="text" type="email" name="email" size="30" required></div>
			<div><b class="name">전화번호 : </b><input class="text" type="tel" name="phone" style="width: 298px"></div>
			<div><b class="name">좋아하는 장르 : </b>
			All<input type="checkbox" name="chk" value="" onclick='selectAll(this)'><br>
			액션<input type="checkbox" name="chk" value="액션"> 
			로맨스<input type="checkbox" name="chk" value="로맨스"> 
			판타지<input type="checkbox" name="chk" value="판타지"> 
			SF<input type="checkbox" name="chk" value="SF"><br>
			애니메이션<input type="checkbox" name="chk" value="애니메이션"> 
			공포<input type="checkbox" name="chk" value="공포"> 
			미스터리<input type="checkbox" name="chk" value="미스터리"> 
			호러<input type="checkbox" name="chk" value="호러"> 
			
			</div>
			<div><button class="sign_up">가입</button>
			<button type="button" class="sign_up" onclick="history.back()">돌아가기</button>
			</div>
		</fieldset>
	</form>
</body>
</html>