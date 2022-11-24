<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
    
      $(function () {
        let y = new Date();
        y.setDate(y.getDate() - 1);
        let str =
          y.getFullYear() +
          "-" +
          ("0" + (y.getMonth() + 1)).slice(-2) +
          "-" +
          ("0" + y.getDate()).slice(-2);
        $("#date").attr("max", str);

        // 버튼의 클릭 이벤트
        $("#mybtn").click(function () {
          let d = $("#date").val(); //YYYY-MM-dd
          const regex = /-/g;
          let d_str = d.replace(regex, ""); //YYYYMMdd

          let url =
            "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" +
            d_str;

          $.getJSON(url, function (data) {
            let movieList = data.boxOfficeResult.dailyBoxOfficeList;
            $("#boxoffice").empty();

            let img = "";
            for (let i in movieList) {
              $.ajax({
                url: "jsp/dw/getMovie.jsp", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
                data: { title: movieList[i].movieNm }, // HTTP 요청과 함께 서버로 보낼 데이터
                method: "GET", // HTTP 요청 메소드(GET, POST 등)
                dataType: "json", // 서버에서 보내줄 데이터의 타입
              })
              
                // HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
                .done(function (json) {
                  img = console.log(json.img);
                  director = console.log(json.director);
                  actor = console.log(json.actor);
                  
                  $("#boxoffice").append(
                    "<img src= '" +
                      json.img +
                      "'> <br>" + 
                      "<span id= '" +
                      movieList[i].movieCd + 
                      "'>" +
                      (parseInt(i) + 1) +
                      " " +
                    "<h1>" + movieList[i].movieNm +"</h1>"
                    +  json.director +"<br>"+ json.actor + "<br>" +
                      movieList[i].openDt +
                      "개봉 </span><hr>"
                  );
                })
                .fail(function (xhr, status, errorThrown) {
                  $("#text")
                    .html("오류가 발생했다.<br>")
                    .append("오류명: " + errorThrown + "<br>")
                    .append("상태: " + status);
                });
              // 이름값을 쿼리로 네이버에 전송해서 이미지값 받아오기
            }
          });
        }); //button click
      }); //ready
    </script>
  </head>
  <body>
    <div>
      <input type="date" id="date" />
      <button id="mybtn">확인</button>

      <div id="boxoffice">
        <h1>박스 오피스 순위</h1>
      
      </div>
      
    </div>
  </body>
</html>