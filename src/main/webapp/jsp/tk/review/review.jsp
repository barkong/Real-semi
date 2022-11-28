<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jw/info.css">
<link rel="stylesheet" href="css/jw/login.css">
<link rel="stylesheet" href="css/tk/bbs.css" />
<script type="text/javascript" src="js/tk/bbs.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
	<nav class="navbar">
		<div class="navbar__logo">
			<i class=""></i> <a href=""></a>
		</div>

		<ul class="navbar__menu">
			<li onclick="location.href='HC'">홈으로</li>
			<li
				onclick="location.href='InfoAccountC?id=${sessionScope.accountInfo.a_id}'">마이페이지</li>
			<li onclick="location.href='FreeC'">자유게시판</li>
			<li onclick="location.href='ReviewC'">리뷰</li>
			<li onclick="location.href='MyBbsC'">나의글 목록</li>
		</ul>
		<br> <br> <br>
		<ul class="navbar__icons">
			<li onclick="location.href='UpdateAccountC'">정보수정</li>
			<li onclick="location.href='DeleteAccountC'">회원탈퇴</li>
		</ul>
		<a href="#" class="navbar__toggleBtn"> <i class=""></i>
		</a>
	</nav>



	<h1>Review BBS</h1>

	<table align="center">
		<tr>
			<td><a href="FreeC">자유게시판으로</a></td>
		</tr>
	</table>

	<c:choose>
		<c:when test="${empty sessionScope.accountInfo.a_id}">
			<%-- <c:when test="${sessionScope.accountInfo.a_id eq null}"> --%>
			<a href="ReviewRegC" onclick="alert('로그인하세요')">새글쓰기 (when)</a>
		</c:when>
		<c:otherwise>
			<a href="ReviewRegC"> 새글쓰기(when)</a>
		</c:otherwise>
	</c:choose>
	<!-- <a href="#" onclick="pageCheck();">새글쓰기2</a> -->


	<div class="container" align="center">
		<div class="row">
			<table class="bbsTable"
				style="text-align: center; border: 1px solid #dddddd" align="center">
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

							<c:choose>
								<c:when test="${empty sessionScope.accountInfo.a_id}">
									<td><a href="ReviewDetailC?no=${r.r_no }"
										onclick="alert('로그인하세요');">${r.r_title }</a></td>
								</c:when>
								<c:otherwise>
									<td><a href="ReviewDetailC?no=${r.r_no }">${r.r_title }</a></td>
								</c:otherwise>
							</c:choose>

							<td>${r.r_id }</td>
							<td><fmt:formatDate value="${r.r_date }" type="both"
									dateStyle="short" timeStyle="short" /></td>
							<td>${r.r_count }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<!--  페이징 -->
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