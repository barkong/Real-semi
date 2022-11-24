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
	<h1>Free BBS</h1>

	<table align="center">
		<tr>
			<td><a href="ReviewC">리뷰게시판으로</a></td>
		</tr>
	</table>

	<c:choose>
		<c:when test="${empty sessionScope.accountInfo.a_id}">
			<h3>로그인해야 읽고 글쓰고 수정 가능</h3>
		</c:when>
		<c:otherwise>
			<a href="FreeRegC">글쓰기</a>
		</c:otherwise>
	</c:choose>

	<div class="container" align="center">
		<div class="row">
			<table class="review table"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: gray; text-align: center;">NO</th>
						<th style="background-color: gray; text-align: center;">글제목</th>
						<th style="background-color: gray; text-align: center;">작성자</th>
						<th style="background-color: gray; text-align: center;">작성시간</th>
						<th style="background-color: gray; text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
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
				</tbody>
			</table>
		</div>
		<div>
			<span align="center"><c:choose>
					<c:when test="${curPageNo == 1}">
						◀
					</c:when>
					<c:otherwise>
						<a href="FreePageC?p=${curPageNo - 1 }"> ◀ </a>
					</c:otherwise>
				</c:choose></span> <a href="FreePageC?p=1">[맨처음]</a></span>
			<c:forEach var="i" begin="1" end="${pageCount }">
				<a href="FreePageC?p=${i }"> [${i }] </a>
			</c:forEach>
			<span><a href="FreePageC?p=${pageCount }">[맨끝]</a></span> <span
				align="center"><c:choose>
					<c:when test="${curPageNo == pageCount}">
						▶
					</c:when>
					<c:otherwise>
						<a href="FreePageC?p=${curPageNo + 1 }"> ▶ </a>
					</c:otherwise>
				</c:choose></span>
		</div>
	</div>
</body>
</html>