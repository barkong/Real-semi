<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jw/info.css">
</head>
<body>
<nav class="navbar">

      <div class="navbar__logo">
        <i class=""></i>
        <a href=""></a>
      </div>

      <ul class="navbar__menu">
        <li onclick="location.href='HC'">홈으로</li>
        <li>마이페이지</li>
        <li>자유게시판</li>
        <li></li>
        <li>문의</li>
      </ul><br><br><br>
      <ul class="navbar__icons">
        <li onclick="location.href='UpdateAccountC'">정보수정</li>
        <li>회원탈퇴</li>
      </ul>
      <a href="#" class="navbar__toggleBtn">
        <i class=""></i>
      </a>
      
    </nav>
	<table>
		<caption>회원정보</caption>
		<tr>
			<td>ID</td>
			<td>${sessionScope.accountInfo.a_id }</td>
		</tr>
		<tr>
			<td>PW</td>
			<td>${sessionScope.accountInfo.a_password }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${sessionScope.accountInfo.a_name }</td>
		</tr>
		<tr>
			<td>생일</td>
			<td>${sessionScope.accountInfo.a_birth }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${sessionScope.accountInfo.a_gender }</td>
		</tr>
		<tr>
			<td>email</td>
			<td>${sessionScope.accountInfo.a_email }</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${sessionScope.accountInfo.a_phone }</td>
		</tr>
		<tr>
			<td>좋아하는 장르</td>
			<td>${sessionScope.accountInfo.a_interest }</td>
		</tr>
		<tr>
			<td colspan="2"><button onclick="location.href='UpdateAccountC'">수정</button>
				<button onclick="history.back()">돌아가기</button>
				<button>탈퇴</button></td>
		</tr>
	</table>

</body>
</html>