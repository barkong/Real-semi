<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jw/info.css">
<link rel="stylesheet" href="css/jw/login.css">
<script type="text/javascript" src="js/jw/check.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
<nav class="navbar">

      <div class="navbar__logo">
        <i class=""></i>
        <a href=""></a>
      </div>

      <ul class="navbar__menu">
        <li onclick="location.href='HC'">홈으로</li>
        <li onclick="location.href='InfoAccountC?id=${sessionScope.accountInfo.a_id}'">마이페이지</li>
        <li onclick="location.href='FreeC'">자유게시판</li>
        <li onclick="location.href='ReviewC'">리뷰게시판</li>
      </ul><br><br><br>
      <ul class="navbar__icons">
        <li onclick="location.href='UpdateAccountC'">회원정보수정</li>
        <li onclick="deleteID()">회원탈퇴</li>
      </ul>
      <a href="#" class="navbar__toggleBtn">
        <i class=""></i>
      </a>
      
    </nav>
	<h1 align="center">회원정보</h1>
		<hr>
		<div>
		<b class="name">ID</b>
		<b class="text">${sessionScope.accountInfo.a_id }</b><br><br>
		</div>
		<div>
		<b class="name">PW</b>
		<b class="text">${sessionScope.accountInfo.a_password }</b><br><br>
		</div>
		<div>
		<b class="name">이름</b>
		<b class="text">${sessionScope.accountInfo.a_name }</b><br><br>
		</div>
		<div>
		<b class="name">생일</b>
		<b class="text">${sessionScope.accountInfo.a_birth }</b><br><br>
		</div>
		<div>
		<b class="name">성별</b>
		<b class="text">${sessionScope.accountInfo.a_gender }</b><br><br>
		</div>
		<div>
		<b class="name">email</b>
		<b class="text">${sessionScope.accountInfo.a_email }</b><br><br>
		</div>
		<div>
		<b class="name">전화번호</b>
		<b class="text">${sessionScope.accountInfo.a_phone }</b><br><br>
		</div>
		<div>
		<b class="name">좋아하는 장르</b>
		<b class="text">${sessionScope.accountInfo.a_interest }</b><br><br>
		</div>
			<div><button class="sign_up" onclick="location.href='UpdateAccountC'">수정</button>
				<button class="sign_up"  onclick="deleteID()">탈퇴</button></div>
		

</body>
</html>