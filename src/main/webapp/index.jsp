<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/index.css" />
  </head>
  <body>
    <div id="Container">
      <div id="top">
        <div id="title">영화정보페이지</div>

        <div class="btn1">
          <jsp:include page="${loginPage }"></jsp:include>
        </div>
      </div>

      <div id="menus">
        <div class="mainMenu">
          <a href="#">영화 추천</a>
        </div>
        <div class="mainMenu">
          <a href="#">영화 리뷰</a>
        </div>
        <div class="mainMenu">
          <a href="#">주변영화관 찾기</a>
        </div>
        <div class="mainMenu">
          <a href="#">검색</a>
        </div>
      </div>

      <div id="content">
        <jsp:include page="${contentPage }"></jsp:include>
      </div>
    </div>
  </body>
</html>
