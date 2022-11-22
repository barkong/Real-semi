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

	<table border="1" align="center">
		<tr>
			<td colspan="2" align="center">
				<h3>글제목 : ${free.f_title }</h3>
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
			<td>조회수</td>
			<td>${free.f_count }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${free.f_detail }</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><img id="freeImg" src="files/freeImg/${free.f_img }" width="300px"></td>
		</tr>
		<tr>
			<td colspan="2"><a href="FreeC">목록으로</a>
				<button onclick="location.href='FreeUpdateC?no=${param.no}'">수정</button>
				<button onclick="freeDel(${free.f_no})">삭제</button></td>
		</tr>
	</table>
</body>
</html>