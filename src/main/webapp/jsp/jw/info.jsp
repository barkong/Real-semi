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
			<td>생년월일</td>
			<td>${sessionScope.accountInfo.a_birth }</td>
		</tr>
		
	</table>

</body>
</html>