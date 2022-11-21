<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jw/check.js"></script>
</head>
<body>
<form action="UpdateAccountC" method="post" onsubmit="return call()">
	<table>
		<caption>정보 수정</caption>
		<tr>
			<td>ID</td>
			<td>${sessionScope.accountInfo.a_id }</td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input name="pw" value="${sessionScope.accountInfo.a_password }"></td>
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
		<td colspan="2"><button onclick="UpdateAccountC">수정</button><button type="button" onclick="history.back()" >돌아가기</button></td>
		</tr>
	</table>
	</form>
</body>
</html>