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
	<div id="contentWp">
		<div id="sidebar">
			<nav class="navbar">
				<div class="navbar__logo">
					<i class=""></i> <a href=""></a>
				</div>
				<ul class="navbar__menu">
					<li onclick="location.href='HC'">홈으로</li>
					<li onclick="location.href='WeeklyBoxofficeC'">박스오피스</li>
					<li onclick="location.href='MovieNewsC'">영화뉴스</li>
					<li onclick="location.href='ReviewC'">영화리뷰</li>
					<li onclick="location.href='FreeC'">자유게시판</li>
				</ul>
				<br> <br>
				<c:if test="${sessionScope.accountInfo.a_id ne null}">
					<ul class="navbar__icons">
						<li
							onclick="location.href='InfoAccountC?id=${sessionScope.accountInfo.a_id}'">마이페이지</li>
						<li onclick="location.href='MyBbsRC'">나의글목록</li>
						<li onclick="location.href='UpdateAccountC'">회원정보</li>
					</ul>
				</c:if>
				<a href="#" class="navbar__toggleBtn"> <i class=""></i>
				</a>
			</nav>
		</div>


		<div id="bbs_content">
			<div class="mybbsHead">
				<div>
					<button class="mybbsBt2" onclick="location.href='MyBbsRC'">[나의
						리뷰글 목록]</button>
				</div>
				<div>&nbsp; &nbsp;&nbsp;&nbsp;</div>
				<div>
					<button class="mybbsBt1" onclick="location.href='MyBbsFC'">[나의
						자유글 목록]</button>
				</div>
			</div>

			<c:choose>
				<c:when test="${mbf ne null }">
					<table class="bbsTable">
						<thead class="bbsthead">
							<tr class="bbstr">
								<th>게시판분류</th>
								<th>글번호</th>
								<th>글제목</th>
								<th>작성자</th>
								<th>작성시간</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody class="bsstbody">
							<c:forEach var="mb" items="${mbf }">
								<c:if test="${mb.mbf_cat ne null }">
									<tr>
										<td>${mb.mbf_cat }</td>
										<td>${mb.mbf_no }</td>
										<td class="bbsTable_title"><a
											href="FreeDetailC?no=${mb.mbf_no }">${mb.mbf_title }</a></td>
										<td>${mb.mbf_id }</td>
										<td><fmt:formatDate value="${mb.mbf_date }" type="both"
												dateStyle="short" timeStyle="short" /></td>
										<td>${mb.mbf_count }</td>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>

					<div class="bbsPaging">
						<span><c:choose>
								<c:when test="${curPageNo == 1}">
								</c:when>
								<c:otherwise>
									<a href="MyBbsPageFC?p=${curPageNo - 1 }"> ◀이전 </a>
								</c:otherwise>
							</c:choose></span> <a href="MyBbsPageFC?p=1">[맨처음]</a>
						<c:forEach var="i" begin="1" end="${pageCount }">
							<a href="MyBbsPageFC?p=${i }"> [${i }] </a>
						</c:forEach>
						<span><a href="MyBbsPageFC?p=${pageCount }">[맨끝]</a></span> <span><c:choose>
								<c:when test="${curPageNo == pageCount}">
								</c:when>
								<c:otherwise>
									<a href="MyBbsPageFC?p=${curPageNo + 1 }"> 다음▶ </a>
								</c:otherwise>
							</c:choose></span>
					</div>
				</c:when>
				<c:otherwise>
					<h2>[작성한 리뷰글이 없습니다.]</h2>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</body>
</html>