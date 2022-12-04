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
			<aside class="content_widget">
				<div>
					<a>인기 리뷰</a>
					<c:forEach var="r" items="${reviewsB }" begin="0" end="4">
						<c:if test="${r.r_Bid ne null }">
							<ul>
								<li><a href="ReviewDetailC?no=${r.r_Bno }">${r.r_Btitle }</a>
									&nbsp; ${r.r_Bcount  }명&nbsp;<fmt:formatDate
										value="${r.r_Bdate }" type="date" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</div>
				<div>
					<a>최신 리뷰</a>
					<c:forEach var="r" items="${reviewsC }" begin="0" end="4">
						<c:if test="${r.r_Cid ne null }">
							<ul>
								<li><a href="ReviewDetailC?no=${r.r_Cno }">${r.r_Ctitle }</a>
									&nbsp; ${r.r_Ccount  }명&nbsp;<fmt:formatDate
										value="${r.r_Cdate }" type="date" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</div>
				<div class="content_widget_freeBest">
					<a>인기 자유글</a>
					<c:forEach var="f" items="${freesB }" begin="0" end="4">
						<c:if test="${f.f_Bid ne null }">
							<ul>
								<li><a href="FreeDetailC?no=${f.f_Bno }">${f.f_Btitle }</a>
									&nbsp; ${f.f_Bcount  }명&nbsp;<fmt:formatDate
										value="${f.f_Bdate }" type="date" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</div>
				<div>
					<a>최신 자유글</a>
					<c:forEach var="f" items="${freesC }" begin="0" end="4">
						<c:if test="${f.f_Cid ne null }">
							<ul>
								<li><a href="FreeDetailC?no=${f.f_Cno }">${f.f_Ctitle }</a>&nbsp;${f.f_Ccount }명&nbsp;<fmt:formatDate
										value="${f.f_Cdate }" type="date" /></li>
							</ul>
						</c:if>
					</c:forEach>
				</div>
			</aside>

			<br> <br>

			<div class="bbs_1st_wrp">
				<div class="bbsTop">
					<div class="bbsTop_fl">
						<a href="ReviewRegC"> 영화 리뷰 </a>
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

				<table class="bbsTable">
					<thead>
						<tr>
							<th>번호</th>
							<th>영화</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>시간</th>
							<th>조회</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="r" items="${reviewsB }" begin="0" end="2">
							<c:if test="${r.r_Bid ne null }">
								<tr class="bbsTable_best">
									<td>${r.r_Bno }</td>
									<td>${r.r_Bmovie }</td>
									<td><a href="ReviewDetailC?no=${r.r_Bno }">${r.r_Btitle }</a></td>
									<td>${r.r_Bid }</td>
									<td><fmt:formatDate value="${r.r_Bdate }" type="date"
											dateStyle="short" /> <br> <fmt:formatDate
											value="${r.r_Bdate }" type="time" timeStyle="short" /></td>
									<td>${r.r_Bcount }</td>
								</tr>
							</c:if>
						</c:forEach>
						<c:forEach var="r" items="${reviews }">
							<c:if test="${r.r_id ne null }">
								<tr>
									<td>${r.r_no }</td>
									<td class="bbsTable_movie">${r.r_movie }</td>
									<c:choose>
										<c:when test="${sessionScope.accountInfo eq null}">
											<td class="bbsTable_title"><a
												href="ReviewDetailC?no=${r.r_no }"
												onclick="alert('로그인하세요');">${r.r_title }</a></td>
										</c:when>
										<c:otherwise>
											<td class="bbsTable_title"><a
												href="ReviewDetailC?no=${r.r_no }">${r.r_title }</a></td>
										</c:otherwise>
									</c:choose>
									<td>${r.r_id }</td>
									<td><fmt:formatDate value="${r.r_date }" type="date"
											dateStyle="short" /> <br> <fmt:formatDate
											value="${r.r_date }" type="time" timeStyle="short" /></td>
									<td>${r.r_count }</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>


				<div class="bbsBot">
					<div class="bbsBot_fl">
						<form action="https://www.fmkorea.com/" method="get"
							class="bd_srch_btm on" no-error-return-url="true"
							onsubmit="if(this.search_target.value=='comment'){ jQuery('[name=sort_index]', this).remove(); }">
							<input type="hidden" name="mid" value="starcraft"> <input
								type="hidden" name="category" value=""> <span
								class="btn_img itx_wrp">
								<button type="submit"
									onclick="jQuery(this).parents('form.bd_srch_btm').submit();return false;"
									class="ico_16px search">Search</button> <label
								for="bd_srch_btm_itx_6042994">검색</label> <input type="text"
								name="search_keyword" id="bd_srch_btm_itx_6042994"
								class="bd_srch_btm_itx srch_itx" value="">
							</span> <span class="btn_img select"> <select
								name="search_target">
									<option value="title_content">제목+내용</option>
									<option value="title">제목</option>
									<option value="content">내용</option>
									<option value="nick_name">작성자</option>
							</select>
							</span>
						</form>
					</div>
					<div class="bbsBot_fr">
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


				<div class="bbsPaging">
					<span><c:choose>
							<c:when test="${curPageNo == 1}">
							</c:when>
							<c:otherwise>
								<a href="ReviewPageC?p=${curPageNo - 1 }"> ◀이전 </a>
							</c:otherwise>
						</c:choose></span> <a href="ReviewPageC?p=1">[맨처음]</a>
					<c:forEach var="i" begin="1" end="${pageCount }">
						<a href="ReviewPageC?p=${i }"> [${i }] </a>
					</c:forEach>
					<span><a href="ReviewPageC?p=${pageCount }">[맨끝]</a></span> <span><c:choose>
							<c:when test="${curPageNo == pageCount}">
							</c:when>
							<c:otherwise>
								<a href="ReviewPageC?p=${curPageNo + 1 }"> 다음▶ </a>
							</c:otherwise>
						</c:choose></span>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
</body>
</html>