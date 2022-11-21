<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1>Semi Review</h1>

	<table id="review_tbl1" align="center">
		<tr>
			<td><a href="ReviewRegC">글쓰기</a></td>
			<td><a href="FreeC">자유게시판</a></td>
		</tr>
	</table>

	<table border=1 id="review_tbl2" align="center">
		<!-- 게시판 페이지 : (순번)/영화제목/글제목/작성날짜 -->
		<tr>
			<td>[영화]</td>
			<td>[글제목]</td>
			<td>[작성자]</td>
			<td>[작성시간]</td>
			<td>[조회수]</td>
		</tr>

		<c:forEach var="r" items="${reviews }">
			<tr>
				<td>${r.r_movie }</td>
				<td><a href="ReviewDetailC?no=${r.r_no }">${r.r_title }</a></td>
				<td>${r.r_id }</td>
				<td><fmt:formatDate value="${r.r_date }" type="both"
						dateStyle="short" timeStyle="short" /></td>
				<td>${r.r_count }</td>
			</tr>
		</c:forEach>
	</table>
	
	<span><a href="ReviewPageC?p=1">[맨처음]</a></span>
	<c:forEach var="i" begin="1" end="${pageCount }">
		<a href="ReviewPageC?p=${i }"> [${i }] </a>
	</c:forEach>
	<span><a href="ReviewPageC?p=${pageCount }">[맨끝]</a></span>
	
</body>
</html>