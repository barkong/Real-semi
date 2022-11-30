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


	<!-- 상세내용 -->
	<div class="bbsdiv">
		<h1 class="bbsh1">Movie Review</h1>
		<table class="bbsTable"
			style="text-align: center; border: 1px solid #dddddd" align="center">
			<thead class="bbsthead">
				<tr class="bbstr">
					<th class="bbsth" colspan="3" style="text-align: center;">글제목
						: ${review.r_title }</th>
				</tr>
			</thead>
			<tbody class="bbstbody">
				<tr class="bbstr">
					<td class="bbstd">영화제목</td>
					<td class="bbstd" style="text-align: center;">${review.r_movie }</td>
					<td class="bbstd">&nbsp;</td>
				</tr>
				<tr class="bbstr">
					<td class="bbstd2">NO. : ${review.r_no }</td>
					<td class="bbstd2">등록시간 : <fmt:formatDate
							value="${review.r_date }" type="both" dateStyle="short"
							timeStyle="short" /></td>
					<td class="bbstd2">조회수 : ${review.r_count }</td>
				</tr>
				<tr class="bbstr">
					<td class="bbstd3" colspan="3">${review.r_detail}</td>
				</tr>
				<tr class="bbstr">
					<c:if test="${review.r_img ne null }">
						<td class="bbstd" colspan="3"><img
							src="files/reviewImg/${review.r_img }" width="500px"></td>
					</c:if>
				</tr>

				<!-- 수정 삭제 이전으로 새글쓰기 -->
				<tr class="bbstr">
					<td class="bbstd" colspan="3"><c:choose>
							<c:when test="${sessionScope.accountInfo.a_id eq review.r_id}">
								<c:choose>
									<c:when test="${sessionScope.accountInfo eq null}">
										<button class="bbsbt" onclick="alert('로그인하세요')">수정</button>
										<button class="bbsbt" onclick="alert('로그인하세요')">삭제</button>
									</c:when>
									<c:otherwise>
										<button class="bbsbt"
											onclick="location.href='ReviewUpdateC?no=${param.no}'">수정</button>
										<button class="bbsbt" onclick="reviewDel(${review.r_no})">삭제</button>
									</c:otherwise>
								</c:choose>
							</c:when>
						</c:choose></td>
				</tr>
				<tr class="bbstr">
					<td class="bbstd" colspan="3"><a class="bbsa"
						onclick="history.back()">이전으로</a> <c:choose>
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
	</div>


	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- 게시글 보여주기 -->
	<div class="bbsdiv">
		<h1 class="bbsh1">Review BBS</h1>
		<table class="bbsTable"
			style="text-align: center; border: 1px solid #dddddd" align="center">
			<thead class="bbsthead">
				<tr class="bbstr">
					<th class="bbsnumber"
						style="background-color: gray; text-align: center;">글번호</th>
					<th class="bbsmovie"
						style="background-color: gray; text-align: center;">영화</th>
					<th class="bbstitle"
						style="background-color: gray; text-align: center;">글제목</th>
					<th class="bbsid"
						style="background-color: gray; text-align: center;">작성자</th>
					<th class="bbsdate"
						style="background-color: gray; text-align: center;">작성시간</th>
					<th class="bbscount"
						style="background-color: gray; text-align: center;">조회수</th>
				</tr>
			</thead>
			<tbody class="bbstbody">
				<c:forEach var="r" items="${reviews }">
					<tr class="bbstr">
						<td class="bbsnumber">${r.r_no }</td>
						<td class="bbsmovie">${r.r_movie }</td>

						<c:choose>
							<c:when test="${sessionScope.accountInfo eq null}">
								<td class="bbstitle"><a class="bbsa"
									href="ReviewDetailC?no=${r.r_no }" onclick="alert('로그인하세요');">${r.r_title }</a></td>
							</c:when>
							<c:otherwise>
								<td class="bbstitle"><a class="bbsa"
									href="ReviewDetailC?no=${r.r_no }">${r.r_title }</a></td>
							</c:otherwise>
						</c:choose>

						<td class="bbsid">${r.r_id }</td>
						<td class="bbsdate"><fmt:formatDate value="${r.r_date }"
								type="both" dateStyle="short" timeStyle="short" /></td>
						<td class="bbscount">${r.r_count }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!--  페이징 -->
	<div class="bbsdiv">
		<span><c:choose>
				<c:when test="${curPageNo == 1}">
						◀
					</c:when>
				<c:otherwise>
					<a class="bbsa" href="ReviewPageC?p=${curPageNo - 1 }"> ◀ </a>
				</c:otherwise>
			</c:choose></span> <a class="bbsa" href="ReviewPageC?p=1">[맨처음]</a>
		<c:forEach var="i" begin="1" end="${pageCount }">
			<a class="bbsa" href="ReviewPageC?p=${i }"> [${i }] </a>
		</c:forEach>
		<span><a class="bbsa" href="ReviewPageC?p=${pageCount }">[맨끝]</a></span>
		<span><c:choose>
				<c:when test="${curPageNo == pageCount}">
						▶
					</c:when>
				<c:otherwise>
					<a class="bbsa" href="ReviewPageC?p=${curPageNo + 1 }"> ▶ </a>
				</c:otherwise>
			</c:choose></span>
	</div>
	<br>
	<br>
	<br>
</body>
</html>