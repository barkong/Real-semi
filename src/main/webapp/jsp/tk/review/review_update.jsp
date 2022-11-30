<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
pageContext.setAttribute("br", "<br>");
%>
<%
pageContext.setAttribute("cn", "\n");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/jw/info.css">
<link rel="stylesheet" href="css/jw/login.css">
<link rel="stylesheet" href="css/jw/bbs.css">
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
				<li onclick="location.href='MyBbsC'">내가쓴글목록</li>
				<li onclick="location.href='UpdateAccountC'">회원정보수정</li>
				<li onclick="deleteID()">회원탈퇴</li>
			</ul>
		</c:if>
		<a href="#" class="navbar__toggleBtn"> <i class=""></i>
		</a>
	</nav>


	<div class="bbsdiv">
	<h1 class="bbsh1">리뷰수정하기</h1>
			<form action="ReviewUpdateC" method="post" name="bbsForm"
				enctype="multipart/form-data" onsubmit="return bbsCall()">
				<table class="bbsTable"
					style="text-align: center; border: 1px solid #dddddd" align="center">

					<thead class="bbsthead">
						<tr class="bbstr">
							<th class="bbstd" style="background-color: gray;">글제목</th>
							<th class="bbsth" colspan="2"
								style="text-align: left; padding-left: 300px;"><input
								type="text" value="${review.r_title }" name="title"></th>
						</tr>
					</thead>
					<tbody class="bbstbody">
						<tr class="bbstr">
							<td class="bbstd">영화제목</td>
							<td class="bbstd" colspan="2"
								style="text-align: left; padding-left: 300px;"><input
								type="text" value="${review.r_movie }" name="movie"></td>
						</tr>
						<tr class="bbstr">
							<td class="bbstd">NO. : ${review.r_no }</td>
							<td class="bbstd">등록시간 : <fmt:formatDate
									value="${review.r_date }" type="both" dateStyle="short"
									timeStyle="short" /></td>
							<td class="bbstd">조회수 : ${review.r_count }</td>
						</tr>
						<tr class="bbstr">
							<td colspan="3"><textarea maxlength="2084" name="detail"
									rows="20" cols="60" style="resize: none">${fn:replace(review.r_detail, br, "cn")}</textarea></td>

						</tr>
						<tr class="bbstr">

							<c:if test="${review.r_img ne null }">
								<td class="bbstd" colspan="3"><img
									src="files/reviewImg/${review.r_img }" width="500px"></td>
							</c:if>
						</tr>
						<tr class="bbstr">
							<td class="bbstd" colspan="3"><input type="file" name="img2" /><input
								name="img" value="${review.r_img }" type="hidden"></td>
						</tr>
						<tr class="bbstr">
							<td class="bbstd" colspan="3">
								<button class="bbsbt">등록(수정완료)</button>
								<button class="bbsbt" type="button"
									onclick="reviewDel(${review.r_no})">삭제하기</button>
							</td>
						</tr>


						<tr class="bbstr">
							<td class="bbstd" colspan="3"><a href="ReviewC">게시판 목록으로</a>
								<c:choose>
									<c:when test="${sessionScope.accountInfo eq null}">
										<a class="bbsa" href="ReviewRegC" onclick="alert('로그인하세요')">새글쓰기</a>
									</c:when>
									<c:otherwise>
										<a class="bbsa" href="ReviewRegC">새글쓰기</a>
									</c:otherwise>
								</c:choose>
						</tr>
					</tbody>
				</table>
			</form>
	</div>
	<br><br><br>
</body>
</html>