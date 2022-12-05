<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
<link rel="stylesheet" href="css/jw/login.css" />
</head>
<body>
		
				<span class="loginOkT">${sessionScope.accountInfo.a_id }(${sessionScope.accountInfo.a_name })</span>
			
				<button class="sign_in" onclick="location.href='InfoAccountC?id=${sessionScope.accountInfo.a_id}'">My Page</button><button class="sign_in" onclick="location.href='LoginC'">Logout</button>
				
				
</body>
</html>