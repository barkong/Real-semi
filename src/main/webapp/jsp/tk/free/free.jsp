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
			</ul>
		</c:if>
		<a href="#" class="navbar__toggleBtn"> <i class=""></i>
		</a>
	</nav>



<div class="bbsdiv">
	<h1 class="bbsh1">Free BBS</h1>
	<c:choose>
		<c:when test="${sessionScope.accountInfo eq null}">
			<a class="bbsnewa" href="FreeRegC" onclick="alert('로그인하세요')">새글쓰기</a>
		</c:when>
		<c:otherwise>
			<a class="bbsnewa" href="FreeRegC"> 새글쓰기</a>
		</c:otherwise>
	</c:choose>
</div>
	<div>
		<div class="bbsdiv">
			<table class="bbsTable"
				style="text-align: center; border: 1px solid #dddddd" align="center">
				<thead class="bbsthead">
					<tr class="bbstr">
						<th class="bbsnumber" style="background-color: gray; text-align: center;">글번호</th>
						<th class="bbstitle" style="background-color: gray; text-align: center;">글제목</th>
						<th class="bbsid" style="background-color: gray; text-align: center;">작성자</th>
						<th class="bbsdate" style="background-color: gray; text-align: center;">작성시간</th>
						<th class="bbscount" style="background-color: gray; text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody class="bbstbody">
					<c:forEach var="f" items="${frees }">
						<tr class="bbstr">
							<td class="bbsnumber">${f.f_no }</td>
							<td class="bbstitle"><a class="bbsa" href="FreeDetailC?no=${f.f_no }">${f.f_title }</a></td>
							<td class="bbsid">${f.f_id }</td>
							<td class="bbsdate"><fmt:formatDate value="${f.f_date }" type="both"
									dateStyle="short" timeStyle="short" /></td>
							<td class="bbscount">${f.f_count }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="bbsdiv">
			<span><c:choose>
					<c:when test="${curPageNo == 1}">
						◀
					</c:when>
					<c:otherwise>
						<a class="bbsa" href="FreePageC?p=${curPageNo - 1 }"> ◀ </a>
					</c:otherwise>
				</c:choose></span> <a class="bbsa" href="FreePageC?p=1">[맨처음]</a>
			<c:forEach var="i" begin="1" end="${pageCount }">
				<a class="bbsa" href="FreePageC?p=${i }"> [${i }] </a>
			</c:forEach>
			<span><a class="bbsa" href="FreePageC?p=${pageCount }">[맨끝]</a></span> <span><c:choose>
					<c:when test="${curPageNo == pageCount}">
						▶
					</c:when>
					<c:otherwise>
						<a class="bbsa" href="FreePageC?p=${curPageNo + 1 }"> ▶ </a>
					</c:otherwise>
				</c:choose></span>
		</div>
	</div>
	<br><br><br>
</body>
</html>