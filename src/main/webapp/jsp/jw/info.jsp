<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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