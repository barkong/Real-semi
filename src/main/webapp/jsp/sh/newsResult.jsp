<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화뉴스</title>
<link rel="stylesheet" href="css/jw/info.css">
<link rel="stylesheet" href="css/jw/login.css">
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "MovieNewsC2",
			dataType : "json",
			success : function(data) {
				successCall(data);
			}
		});
	});

	function successCall(data) {

		//$("#newsContainer").html(content);

		let container = $('#pagination');
		container
				.pagination({
					dataSource : data.items,
					pageSize : 5,
					callback : function(data, pagination) {
						let content = "";
						$
								.each(
										data,
										function(index, i) {
											content += "<div class='news'><span class='time'>"
													+ (i.pubDate).substring(0,
															16)
													+ "</span><div class='title'>"
													+ "<a href='"+ i.link + "'><span class='newsTitle'>"
													+ i.title
													+ "</span></a><div class='hiddenMsg'><span>⬅ 뉴스 원문 보러가기</span></div>"
													+ "</div><span class='newsContent'>"
													+ i.description
													+ "</span></div>";
										});

						$("#newsContainer").html(content);
					}
				});
	}
</script>
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
		<div>
			<div id="newsContainer"></div>
			<div id="searchResultContainer"></div>
			<div class="page"></div>
		</div>
	</div>
</body>
</html>