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



	<h1>Free Content</h1>
	<div class="container" align="center">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd" align="center">
				<thead>
					<tr>
						<th colspan="3" style="text-align: center;">글제목 :
							${free.f_title }</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>NO. : ${free.f_no }</td>
						<td>등록시간 : <fmt:formatDate value="${free.f_date }"
								type="both" dateStyle="short" timeStyle="short" /></td>
						<td>조회수 : ${free.f_count }</td>
					</tr>
					<tr>
						<td colspan="3">${free.f_detail}</td>
					</tr>
					<tr>
						<td colspan="3"><img src="files/freeImg/${free.f_img }"
							width="500px"></td>
					</tr>
					<tr>
						<td><c:choose>
								<c:when test="${sessionScope.accountInfo.a_id eq free.f_id}">
									<c:choose>
										<c:when test="${empty sessionScope.accountInfo.a_id}">
											<button onclick="alert('로그인하세요')">수정</button>
											<button onclick="alert('로그인하세요')">삭제</button>
										</c:when>
										<c:otherwise>
											<button onclick="location.href='FreeUpdateC?no=${param.no}'">수정</button>
											<button onclick="freeDel(${free.f_no})">삭제</button>
										</c:otherwise>
									</c:choose>
								</c:when>
							</c:choose></td>
					</tr>


					<tr>
						<td colspan="3"><a href="FreeC">목록으로</a> <c:choose>
								<c:when test="${empty sessionScope.accountInfo.a_id}">
									<a href="FreeRegC" onclick="alert('로그인하세요')">새글쓰기</a>
								</c:when>
								<c:otherwise>
									<a href="FreeRegC">새글쓰기</a>
								</c:otherwise>
							</c:choose>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>