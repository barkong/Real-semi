<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link rel="stylesheet" href="css/jw/info.css">
<link rel="stylesheet" href="css/jw/login.css">
<script type="text/javascript" src="js/jw/check.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
	<div id="contentWp">
		<!-- 사이드바 -->
		<div id="sidebar">
			<nav class="navbar">
				<div class="navbar__logo">
					<i class=""></i> <a href=""></a>
				</div>
				<ul class="navbar__menu">
					<li onclick="location.href='HC'">홈으로</li>
					<li onclick="location.href='WeeklyBoxofficeC'">박스오피스</li>
					<li onclick="location.href='MovieNewsC'">영화뉴스</li>
					<li onclick="location.href='ReviewC'">영화리뷰</li>
					<li onclick="location.href='FreeC'">자유게시판</li>
				</ul>
				<br> <br>
				<c:if test="${sessionScope.accountInfo.a_id ne null}">
					<ul class="navbar__icons">
						<li
							onclick="location.href='InfoAccountC?id=${sessionScope.accountInfo.a_id}'">마이페이지</li>
						<li onclick="location.href='MyBbsRC'">나의글목록</li>
						<li onclick="location.href='UpdateAccountC'">회원정보</li>
					</ul>
				</c:if>
				<a href="#" class="navbar__toggleBtn"> <i class=""></i>
				</a>
			</nav>
		</div>

		<div class="container2">
			<form name="myForm" onsubmit="return UpdateCheck()"
				action="UpdateAccountC" method="post">
				<h2 align="center">정보 수정</h2>
				<div class="input-container">
					<b class="name">ID</b> <b class="text">${sessionScope.accountInfo.a_id }</b><br>
					<br>
				</div>
				<div class="input-container">
					<b class="name">PW</b> <b class="text"><input name="pw"
						value="${sessionScope.accountInfo.a_password }"></b><br>
					<br>
				</div>
				<div class="input-container">
					<b class="name">이름</b> <b class="text"><input name="name"
						value="${sessionScope.accountInfo.a_name }"></b><br> <br>
				</div>
				<div class="input-container">
					<c:set var="TextValue" value="${sessionScope.accountInfo.a_birth }" />
					<b class="name">생일</b> <b class="text">${fn:substring(TextValue,0,10) }

					</b><br> <br>
				</div>
				<div class="input-container">
					<b class="name">성별</b> <b class="text">${sessionScope.accountInfo.a_gender }</b><br>
					<br>
				</div>
				<div class="input-container">
					<b class="name">email</b> <b class="text"><input type="email"
						name="email" size="30" required
						value="${sessionScope.accountInfo.a_email }"></b><br> <br>
				</div>
				<div class="input-container">
					<b class="name">전화번호</b> <b class="text"><input type="tel"
						name="phone" value="${sessionScope.accountInfo.a_phone }"></b><br>
					<br>
				</div>
				<div class="input-container">
					<b class="name">좋아하는 장르</b> <b class="text">${sessionScope.accountInfo.a_interest }</b><br>
					<br>
				</div>
				<div class="button-container" style="font-size: 130%">
					All<input type="checkbox" name="chk" value=''
						onclick='selectAll(this)'><br> 액션<input
						type="checkbox" name="chk" value="액션"> 로맨스<input
						type="checkbox" name="chk" value="로맨스"> 판타지<input
						type="checkbox" name="chk" value="판타지"> SF<input
						type="checkbox" name="chk" value="SF"><br> 애니메이션<input
						type="checkbox" name="chk" value="애니메이션"> 공포<input
						type="checkbox" name="chk" value="공포"> 미스터리<input
						type="checkbox" name="chk" value="미스터리"> 호러<input
						type="checkbox" name="chk" value="호러"> <br>
				</div>
				<div class="button-container">
					<button class="sign_up">수정</button>
					<button type="button" class="sign_up" onclick="history.back()">돌아가기</button>
					<button type="button" class="sign_up" onclick="deleteID()">탈퇴</button>
				</div>
		</form>
		</div>
	</div>
</body>
</html>