<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jw/info.css">
<link rel="stylesheet" href="css/jw/login.css">
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
        <li>자유게시판</li>
        <li>리뷰</li>
        <li>문의</li>
      </ul><br><br><br>
      <ul class="navbar__icons">
        <li onclick="location.href='UpdateAccountC?'">정보수정</li>
        <li onclick="location.href='DeleteAccountC?'">회원탈퇴</li>
      </ul>
      <a href="#" class="navbar__toggleBtn">
        <i class=""></i>
      </a>
      
    </nav>
    <form action="UpdateAccountC" method="post">
	<h1 align="center">정보 수정</h1>
		<hr>
		<div>
		<b class="name">ID</b>
		<b class="text">${sessionScope.accountInfo.a_id }</b><br><br>
		</div>
		<div>
		<b class="name">PW</b>
		<b class="text"><input name="pw" value="${sessionScope.accountInfo.a_password }"></b><br><br>
		</div>
		<div>
		<b class="name">이름</b>
		<b class="text"><input name="name" value="${sessionScope.accountInfo.a_name }"></b><br><br>
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
		<b class="text"><input type="email" name="email" size="30" required value="${sessionScope.accountInfo.a_email }"></b><br><br>
		</div>
		<div>
		<b class="name">전화번호</b>
		<b class="text"><input class="text" type="tel" name="phone" value="${sessionScope.accountInfo.a_phone }"></b><br><br>
		</div>
		<div>
		<b class="name">좋아하는 장르</b>
		<b class="text">${sessionScope.accountInfo.a_interest }</b><br>
		All<input type="checkbox" name="chk" value='all' onclick='selectAll(this)'><br>
			액션<input type="checkbox" name="chk" value="액션"> 
			공포<input type="checkbox" name="chk" value="공포"> 
			로맨스<input type="checkbox" name="chk" value="로맨스"> 
			판타지<input type="checkbox" name="chk" value="판타지"> 
			<br>
		</div>
			<div><button class="sign_up">수정</button>
				<button type="button" class="sign_up" onclick="history.back()">돌아가기</button>
				<button type="button" class="sign_up" onclick="location.href='DeleteAccountC'">탈퇴</button></div>
				</form>
</body>
</html>