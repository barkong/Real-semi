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
	<h1>Review BBS</h1>

	<table align="center">
		<tr>
			<td><a href="FreeC">자유게시판으로</a></td>
		</tr>
	</table>

	<c:choose>
		<c:when test="${empty sessionScope.accountInfo.a_id}">
			<h3>로그인해야 읽고 글쓰고 수정 가능</h3>
		</c:when>
		<c:otherwise>
			<a href="ReviewRegC">글쓰기</a>
		</c:otherwise>
	</c:choose>

	<div class="container" align="center">
		<div class="row">
			<table class="review table"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: gray; text-align: center;">NO</th>
						<th style="background-color: gray; text-align: center;">영화</th>
						<th style="background-color: gray; text-align: center;">글제목</th>
						<th style="background-color: gray; text-align: center;">작성자</th>
						<th style="background-color: gray; text-align: center;">작성시간</th>
						<th style="background-color: gray; text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="r" items="${reviews }">
						<tr>
							<td>${r.r_no }</td>
							<td>${r.r_movie }</td>
							<td><a href="ReviewDetailC?no=${r.r_no }">${r.r_title }</a></td>
							<td>${r.r_id }</td>
							<td><fmt:formatDate value="${r.r_date }" type="both"
									dateStyle="short" timeStyle="short" /></td>
							<td>${r.r_count }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<span align="center"><c:choose>
					<c:when test="${curPageNo == 1}">
						◀
					</c:when>
					<c:otherwise>
						<a href="ReviewPageC?p=${curPageNo - 1 }"> ◀ </a>
					</c:otherwise>
				</c:choose></span> <a href="ReviewPageC?p=1">[맨처음]</a></span>
			<c:forEach var="i" begin="1" end="${pageCount }">
				<a href="ReviewPageC?p=${i }"> [${i }] </a>
			</c:forEach>
			<span><a href="ReviewPageC?p=${pageCount }">[맨끝]</a></span> <span
				align="center"><c:choose>
					<c:when test="${curPageNo == pageCount}">
						▶
					</c:when>
					<c:otherwise>
						<a href="ReviewPageC?p=${curPageNo + 1 }"> ▶ </a>
					</c:otherwise>
				</c:choose></span>
		</div>
	</div>
</body>
</html>