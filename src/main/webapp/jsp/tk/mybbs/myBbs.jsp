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

</head>
<body>

	<!-- 내비 -->
	<nav class="navbar">
		<div class="navbar__logo">
			<i class=""></i> <a href=""></a>
		</div>
		<ul class="navbar__menu">
			<li onclick="location.href='HC'">홈으로</li>
			<li onclick="location.href='WeeklyBoxofficeC'">박스오피스</li>
			<li onclick="location.href='MovieDetailC'">영화정보</li>
			<li onclick="location.href='MovieNewsC'">영화뉴스</li>
			<li onclick="location.href='ReviewC'">영화리뷰</li>
			<li onclick="location.href='FreeC'">자유게시판</li>
		</ul>
		<br> <br>
		<c:if test="${sessionScope.accountInfo.a_id ne null}">
			<ul class="navbar__icons">
				<li
					onclick="location.href='InfoAccountC?id=${sessionScope.accountInfo.a_id}'">마이페이지</li>
				<li onclick="location.href='MyBbsC'">내가쓴글목록</li>
				<li onclick="location.href='UpdateAccountC'">회원정보수정</li>
				<li onclick="deleteID()">회원탈퇴</li>
			</ul>
		</c:if>
		<a href="#" class="navbar__toggleBtn"> <i class=""></i>
		</a>
	</nav>



	<h1>나의글 목록</h1>

	<div class="container">
		<div class="row">
			<table class="bbsTable"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: gray; text-align: center;">게시판분류</th>
						<th style="background-color: gray; text-align: center;">글번호</th>
						<th style="background-color: gray; text-align: center;">글제목</th>
						<th style="background-color: gray; text-align: center;">작성자</th>
						<th style="background-color: gray; text-align: center;">작성시간</th>
						<th style="background-color: gray; text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="mb" items="${mbs }">
						<c:if test="${mb.mbf_cat ne null }">
							<tr>
								<td>${mb.mbf_no }</td>
								<td>${mb.mbf_cat }</td>
								<td><a href="FreeDetailC?no=${mb.mbf_no }">${mb.mbf_title }</a></td>
								<td>${mb.mbf_id }</td>
								<td><fmt:formatDate value="${mb.mbf_date }" type="both"
										dateStyle="short" timeStyle="short" /></td>
								<td>${mb.mbf_count }</td>
							</tr>
						</c:if>
					</c:forEach>
					<c:forEach var="mb" items="${mbs }">
						<c:if test="${mb.mbr_cat ne null }">
							<tr>
								<td>${mb.mbr_no }</td>
								<td>${mb.mbr_cat }</td>
								<td><a href="ReviewDetailC?no=${mb.mbr_no }">${mb.mbr_title }</a></td>
								<td>${mb.mbr_id }</td>
								<td><fmt:formatDate value="${mb.mbr_date }" type="both"
										dateStyle="short" timeStyle="short" /></td>
								<td>${mb.mbr_count }</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div>
			<span><c:choose>
					<c:when test="${curPageNo == 1}">
						◀
					</c:when>
					<c:otherwise>
						<a href="MyBbsPageC?p=${curPageNo - 1 }"> ◀ </a>
					</c:otherwise>
				</c:choose></span> <a href="MyBbsPageC?p=1">[맨처음]</a>
			<c:forEach var="i" begin="1" end="${pageCount }">
				<a href="MyBbsPageCC?p=${i }"> [${i }] </a>
			</c:forEach>
			<span><a href="MyBbsPageC?p=${pageCount }">[맨끝]</a></span> <span><c:choose>
					<c:when test="${curPageNo == pageCount}">
						▶
					</c:when>
					<c:otherwise>
						<a href="MyBbsPageC?p=${curPageNo + 1 }"> ▶ </a>
					</c:otherwise>
				</c:choose></span>
		</div>
	</div>



</body>
</html>