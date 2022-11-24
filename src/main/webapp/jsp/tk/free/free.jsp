<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tk/free.css" />
<script type="text/javascript" src="js/tk/review.js"></script>
</head>
<body>
	<h1>Semi Free</h1>

	<c:choose>
		<c:when test="${empty sessionScope.accountInfo.a_id}">
			<h3>로그인여도 읽을수 있지만, 글쓰고 수정은 로그인해야</h3>
		</c:when>
		<c:otherwise>
			<a href="FreeRegC">글쓰기</a>
		</c:otherwise>
	</c:choose>

	<table id="review_tbl1" align="center">
		<tr>
			<td><a href="ReviewC">리뷰게시판</a></td>
		</tr>
	</table>

	<table border=1 align="center">
		<!-- 게시판 페이지 : (순번)/영화제목/글제목/작성날짜 -->
		<tr>
			<td>[글번호]</td>
			<td>[글제목]</td>
			<td>[작성자]</td>
			<td>[작성시간]</td>
			<td>[조회수]</td>
		</tr>

		<c:forEach var="f" items="${frees }">
			<tr>
				<td>${f.f_no }</td>
				<td><a href="FreeDetailC?no=${f.f_no }">${f.f_title }</a></td>
				<td>${f.f_id }</td>
				<td><fmt:formatDate value="${f.f_date }" type="both"
						dateStyle="short" timeStyle="short" /></td>
				<td>${f.f_count }</td>
			</tr>
		</c:forEach>
	</table>

	<span><a href="FreePageC?p=1">[맨처음]</a></span>
	<c:forEach var="i" begin="1" end="${pageCount }">
		<a href="FreePageC?p=${i }"> [${i }] </a>
	</c:forEach>
	<span><a href="FreePageC?p=${pageCount }">[맨끝]</a></span>

</body>
</html>