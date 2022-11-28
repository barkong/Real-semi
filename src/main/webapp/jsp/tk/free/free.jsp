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
				<li onclick="location.href='myBbsC'">내가쓴글목록</li>
				<li onclick="location.href='UpdateAccountC'">회원정보수정</li>
				<li onclick="deleteID()">회원탈퇴</li>
			</ul>
		</c:if>
		<a href="#" class="navbar__toggleBtn"> <i class=""></i>
		</a>
	</nav>



	<h1>Free BBS</h1>

	<c:choose>
		<c:when test="${empty sessionScope.accountInfo.a_id}">
			<%-- <c:when test="${sessionScope.accountInfo.a_id eq null}"> --%>
			<a href="FreeRegC" onclick="alert('로그인하세요')">새글쓰기 (when)</a>
		</c:when>
		<c:otherwise>
			<a href="FreeRegC"> 새글쓰기(when)</a>
		</c:otherwise>
	</c:choose>

	<div class="container" align="center">
		<div class="row">
			<table class="bbsTable"
				style="text-align: center; border: 1px solid #dddddd" align="center">
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