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
<script src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body>

	<table border="1" align="center">
		<tr>
			<td colspan="2" align="center">
				<h3>글제목 : ${review.r_title }</h3>
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
			<td>조회수</td>
			<td>${review.r_count }</td>
		</tr>
		<tr>
			<td>영화제목</td>
			<td>${review.r_movie }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${review.r_detail }</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td><img id="reviewImg" src="files/reviewImg/${review.r_img }"
				width="300px"></td>
		</tr>
		<tr>
			<th>좋아요</th>
			<td><input type="button" value="♥" onclick="goodCheck()" />
				${vo.good}</td>
		</tr>
		
		
		
		<tr>
			<td colspan="2"><a href="ReviewC">목록으로</a>
				<button onclick="location.href='ReviewUpdateC?no=${param.no}'">수정</button>
				<button onclick="reviewDel(${review.r_no})">삭제</button></td>
		</tr>
		
	</table>
</body>
</html>