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
<link rel="stylesheet" href="css/jw/bbs.css" />

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


	<div class="bbsdiv">
			<table class="bbsTable" style="text-align: center; border: 1px solid #dddddd" align="center">
				<tr class="bbstr">
					<td class="bbstd">
						<button class="bbsbt1" onclick="location.href='MyBbsC'">[나의 리뷰글 목록]</button>
					</td>
					<td class="bbstd">
						<button class="bbsbt2" onclick="location.href='MyBbsFreeC'">[나의 자유글 목록]</button>
					</td>
				</tr>
			</table>
			<c:choose>
				<c:when test="${mbs ne null }">
					<table class="bbsTable"
						style="text-align: center; border: 1px solid #dddddd" align="center">
						<thead class="bbsthead">
							<tr class="bbstr">
								<th class="bbsnumber" style="background-color: gray; text-align: center;">게시판분류</th>
								<th class="bbsnumber" style="background-color: gray; text-align: center;">글번호</th>
								<th class="bbstitle" style="background-color: gray; text-align: center;">글제목</th>
								<th class="bbsid" style="background-color: gray; text-align: center;">작성자</th>
								<th class="bbsdate" style="background-color: gray; text-align: center;">작성시간</th>
								<th class="bbscount" style="background-color: gray; text-align: center;">조회수</th>
							</tr>
						</thead>
						<tbody class="bbstbody">
							<c:forEach var="mb" items="${mbs }">
							<c:if test="${mb.mbf_cat ne null }">
								<tr class="bbstr">
									<td class="bbsnumber" style="background-color: black;">${mb.mbf_cat }</td>
									<td class="bbsnumber">${mb.mbf_no }</td>
									<td class="bbstitle"><a class="bssa" href="ReviewDetailC?no=${mb.mbf_no }">${mb.mbf_title }</a></td>
									<td class="bbsid">${mb.mbf_id }</td>
									<td class="bbsdate"><fmt:formatDate value="${mb.mbf_date }" type="both"
											dateStyle="short" timeStyle="short" /></td>
									<td class="bbscount">${mb.mbf_count }</td>
								</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
						<span><c:choose>
								<c:when test="${curPageNo == 1}">
						◀
					</c:when>
								<c:otherwise>
									<a class="bbsa" href="MyBbsPageC?p=${curPageNo - 1 }"> ◀ </a>
								</c:otherwise>
							</c:choose></span> <a class="bbsa" href="MyBbsPageC?p=1">[맨처음]</a>

						<c:forEach var="i" begin="1" end="${pageCount }">
							<a class="bbsa" href="MyBbsPageC?p=${i }"> [${i }] </a>
						</c:forEach>

						<span><a class="bbsa" href="MyBbsPageC?p=${pageCount }">[맨끝]</a></span> <span><c:choose>
								<c:when test="${curPageNo == pageCount}">
						▶
					</c:when>
								<c:otherwise>
									<a class="bbsa" href="MyBbsPageC?p=${curPageNo + 1 }"> ▶ </a>
								</c:otherwise>
							</c:choose></span>
				</c:when>
				
				<c:otherwise>
						<h1 class="bbsh1">[작성한 자유글이 없습니다.]</h1>
				</c:otherwise>
			</c:choose>
	</div>



</body>
</html>