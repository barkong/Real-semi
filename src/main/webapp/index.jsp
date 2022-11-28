<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/movieMapInfo.css" />
<link rel="stylesheet" href="css/index.css" />
<link rel="stylesheet" href="css/movieSearchResult.css" />
<link rel="stylesheet" href="css/newsResult.css" />
</head>
<body>
	<div id="Container">
		<div id="top">
			<div id="mainIconDiv">
				<a href="HC"> <img id="mainIcon" src="icon/movieIcon.png" />
				</a>
			</div>
			<div id="searchDiv">
				<form action="MovieSearchC">
					<input id="searchInput" name="movie" type="text"
						placeholder="  영화 제목을 입력해 주세요." />
				</form>
			</div>
			<div class="btn1">
				<jsp:include page="${loginPage }"></jsp:include>
			</div>
		</div>

		<div id="menus">
			<div class="mainMenu">
				<a href="WeeklyBoxofficeC">박스오피스</a>
			</div>
			<div class="mainMenu">
				<a href="MovieDetailC">영화정보</a>
			</div>
			<div class="mainMenu">
				<a href="MovieNewsC">영화뉴스</a>
			</div>
			<div class="mainMenu">
				<a href="ReviewC">영화 리뷰</a>
			</div>
			<div class="mainMenu">
				<a href="FreeC">커뮤니티</a>
			</div>
			<div class="mainMenu">
				<a href="SearchCinemaC">주변영화관 찾기</a>
			</div>

		</div>

		<div id="content">
			<jsp:include page="${contentPage }"></jsp:include>
		</div>
	</div>
</body>
</html>
