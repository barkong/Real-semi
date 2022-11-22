<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tk/free.css" />
<script type="text/javascript" src="js/tk/free.js"></script>
</head>
<body>

	<form action="FreeUpdateC" method="post" onsubmit="return call()"
		enctype="multipart/form-data">

		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">
					<h3>
						<input value="${free.f_title }" name="title">
					</h3>
				</td>
			</tr>
			<tr>
				<td>글번호</td>
				<td>${free.f_no }</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><fmt:formatDate value="${free.f_date }" type="both"
						dateStyle="short" timeStyle="short" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="detail" rows="15" cols="50"
						style="resize: none">${free.f_detail}</textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><img src="files/freeImg/${free.f_img }" width="300px" name="img">
				<input name="img" value="${free.f_img }" type="hidden">
				<input type="file" name="img2" /></td>
			</tr>
			<tr>
				<td colspan="2"><a href="FreeC">목록으로</a>
					<button name="no" value="${param.no}">수정</button>
					<button onclick="freeDel(${free.f_no})">삭제</button></td>
			</tr>
		</table>
	</form>
</body>
</html>