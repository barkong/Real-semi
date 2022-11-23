<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${r }			
				${sessionScope.accountInfo.a_id }(${sessionScope.accountInfo.a_name }) 님 안녕하세요 
				<button onclick="location.href='InfoAccountC?id=${sessionScope.accountInfo.a_id}'">마이페이지</button><button onclick="location.href='LoginC'">로그아웃</button>
				
				
</body>
</html>