<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tk/review.css" />
<script type="text/javascript" src="js/tk/review.js"></script>
</head>
<body>

	<form action="ReviewUpdateC" method="post" enctype="multipart/form-data">

		<table border="1" align="center">
			<tr>
				<td colspan="2" align="center">
					<h3>
						<input value="${review.r_title }" name="title">
					</h3>
				</td>
			</tr>
			<tr>
				<td>글번호</td>
				<td>${review.r_no }</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td><fmt:formatDate value="${review.r_date }" type="both"
						dateStyle="short" timeStyle="short" /></td>
			</tr>
			<tr>
				<td>영화제목</td>
				<td><input value="${review.r_movie }" name="movie"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="detail" rows="15" cols="50"
						style="resize: none">${review.r_detail}</textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><img src="reviewImg/${review.r_img }" width="300px">
				<input name="img" value="${review.r_img }" type="hidden"> 
				<input type="file" name="img2" /></td>
			</tr>
			<tr>
				<td colspan="2"><a href="ReviewC">목록으로</a>
					<button name="no" value="${param.no}">수정</button>
					<button onclick="reviewDel(${review.r_no})">삭제</button></td>
			</tr>
		</table>
	</form>
</body>
</html>