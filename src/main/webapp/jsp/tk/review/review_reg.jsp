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



	<h1>리뷰등록하기</h1>
	<div class="container" align="center">
		<div class="row">
			<form action="ReviewRegC" method="post" name="bbsForm"
				enctype="multipart/form-data" onsubmit="return bbsCall()">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd" align="center">
					<thead>
						<tr>
							<th>글제목</th>
							<th colspan="2" style="text-align: center;"><input
								class="form-control" type="text" name="title" placeholder="글제목"
								maxlength="50" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>영화제목</td>
							<td><input class="form-control" type="text" name="movie"
								placeholder="영화제목" maxlength="50" /></td>
						</tr>
						<tr>
							<td colspan="3"><textarea class="form-control"
									placeholder="글내용" maxlength="2084" name="detail" rows="20"
									cols="60" style="resize: none"></textarea></td>
						</tr>
						<tr>
							<td>이미지</td>
							<td><input type="file" name="img"></td>
						</tr>
						<tr>
							<td colspan="3">
								<button>등록</button>
							</td>
						</tr>


						<tr>
							<td colspan="3"><a href="ReviewC">목록으로</a> <c:choose>
									<c:when test="${empty sessionScope.accountInfo.a_id}">
										<a href="ReviewRegC" onclick="alert('로그인하세요')">새글쓰기</a>
									</c:when>
									<c:otherwise>
										<a href="ReviewRegC">새글쓰기</a>
									</c:otherwise>
								</c:choose>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>