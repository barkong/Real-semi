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
<link rel="stylesheet" href="css/pagination.css" />
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/movie.js"></script>
<script type="text/javascript" src="js/pagination.js"></script>
</head>
<body>
	<div id="Container">
		<div id="top">
			<div id="mainIconDiv">
				<a href="HC"> <img id="mainIcon" src="icon/movieIcon.png" />
				</a>
			</div>
			<div id="searchDiv">

				<input id="searchInput" name="movie" type="text"
					placeholder="  영화 제목을 입력해 주세요." />
			</div>
			<div class="btn1">
				<jsp:include page="${loginPage }"></jsp:include>
			</div>
		</div>

		<div id="menus">
			<div class="mainMenu">
				<a href="WeeklyBoxofficeC">박스오피스</a>
			</div>
			<!-- <div class="mainMenu">
				<a href="MovieDetailC">영화정보</a>
			</div> -->
			<div class="mainMenu">
				<a href="MovieNewsC">영화뉴스</a>
			</div>
			<div class="mainMenu">
				<a href="ReviewC">영화 리뷰</a>
			</div>
			<div class="mainMenu">
				<a href="FreeC">자유게시판</a>
			</div>
			<div class="mainMenu">
				<a href="SearchCinemaC">주변영화관 찾기</a>
			</div>

		</div>

		<div id="content">
			<jsp:include page="${contentPage }"></jsp:include>
		</div>
		<div id="searchResultContainer"></div>
		<div class="page">
			<div id="pagination"></div>
		</div>
		
	</div>
</body>
</html>
