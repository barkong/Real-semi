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
<title>영화리뷰</title>
<link rel="stylesheet" href="css/jw/info.css">
<link rel="stylesheet" href="css/jw/login.css">
<link rel="stylesheet" href="css/jw/bbs.css">
<script type="text/javascript" src="js/tk/bbs.js"></script>
<script type="text/javascript" src="js/validCheck.js"></script>
</head>
<body>
	<div id="contentWp">
		<!-- 사이드바 -->
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
			<aside class="content_widget">
				<div>
					<a>인기 리뷰</a>
					<c:forEach var="r" items="${reviewsB }" begin="0" end="4">
						<c:if test="${r.r_id ne null }">
							<ul>
								<li><a href="ReviewDetailC?no=${r.r_no }">${r.r_title }</a>
									&nbsp; ${r.r_count  }명&nbsp;<fmt:formatDate
										value="${r.r_date }" type="date" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</div>
				<div>
					<a>최신 리뷰</a>
					<c:forEach var="r" items="${reviewsC }" begin="0" end="4">
						<c:if test="${r.r_id ne null }">
							<ul>
								<li><a href="ReviewDetailC?no=${r.r_no }">${r.r_title }</a>
									&nbsp; ${r.r_count  }명&nbsp;<fmt:formatDate
										value="${r.r_date }" type="date" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</div>
				<div class="content_widget_freeBest">
					<a>인기 자유글</a>
					<c:forEach var="f" items="${freesB }" begin="0" end="4">
						<c:if test="${f.f_id ne null }">
							<ul>
								<li><a href="FreeDetailC?no=${f.f_no }">${f.f_title }</a>
									&nbsp; ${f.f_count  }명&nbsp;<fmt:formatDate
										value="${f.f_date }" type="date" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</div>
				<div>
					<a>최신 자유글</a>
					<c:forEach var="f" items="${freesC }" begin="0" end="4">
						<c:if test="${f.f_id ne null }">
							<ul>
								<li><a href="FreeDetailC?no=${f.f_no }">${f.f_title }</a>&nbsp;${f.f_count }명&nbsp;<fmt:formatDate
										value="${f.f_date }" type="date" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</div>
			</aside>

			<br> <br>


			<!-- 메인컨텐츠 -->
			<div class="bbs_1st_wrp">
				<div class="bbsTop">
					<div class="bbsTop_fl">
						<a href="ReviewC"> 리뷰게시판 </a>
					</div>
					<div class="bbsTop_fr">
						<c:choose>
							<c:when test="${sessionScope.accountInfo eq null}">
								<a href="ReviewRegC" onclick="alert('로그인하세요')">새글쓰기</a>
							</c:when>
							<c:otherwise>
								<a href="ReviewRegC"> 새글쓰기</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<!-- 상세창 -->
				<div class="bbsWrite">
					<form action="ReviewUpdateC?no=${review.r_no }" method="post"
						name="bbsForm" enctype="multipart/form-data"
						onsubmit="return bbsCall()">

						<div class="bbsWrite_title">
							<input type="text" value="${review.r_title }" name="title">
						</div>
						<div class="bbsWrite_title">
							<input type="text" value="${review.r_movie }" name="movie">
						</div>

						<div class="bbsDetail_2nd_line">
							<div class="bbsDetail_element">작성자 : ${review.r_id }</div>
							<div class="bbsDetail_element">
								<fmt:formatDate value="${review.r_date }" type="both"
									dateStyle="short" timeStyle="short" />
							</div>
							<input name="no" value="${review.r_no }" type="hidden">
							<div class="bbsDetail_element">NO.:${review.r_no }&nbsp;&nbsp;&nbsp;조회수:${review.r_count }</div>
						</div>

						<div class="bbsWrite_detail">
							<textarea maxlength="2084" name="detail" style="resize: none">${fn:replace(review.r_detail, br, cn)}</textarea>
						</div>

						<div class="bbsDetail_img">
							<c:if test="${review.r_img ne null }">
								<img src="files/reviewImg/${review.r_img }">
							</c:if>
						</div>
						<div class="bbsDetail_img">
							<input type="file" name="img2" /> <input name="img"
								value="${review.r_img }" type="hidden">
						</div>

						<div class="bbsDetail_bot">
							<button class="bbsbt" type="button" onclick="history.back()">이전으로</button>
							<button class="bbsbt">수정완료</button>
							<button class="bbsbt" type="button"
								onclick="reviewDel(${review.r_no})">삭제하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>