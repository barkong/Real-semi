<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="css/recMovie.css" />
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script>
      var naver_movie_api = ["https://openapi.naver.com/v1/search/movie.json"];

      var settings = {
        url: naver_movie_api[0],
        method: "GET",
      };

      $.ajax(settings).done(function (response) {
        console.log(response);
      });
    </script>
  </head>
  <body>
    <div id="recContainer">
      <div class="genreList">
        <div>로맨스</div>
        <div>액션</div>
        <div>판타지</div>
        <div>드라마</div>
        <div>스릴러</div>
        <div>코미디</div>
        <div>SF</div>
        <div>공포</div>
        <div>애니메이션</div>
      </div>
      <div>movie list</div>
    </div>
  </body>
</html>
