<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/boxoffice.css" />
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
            d_str

          $.getJSON(url, function (data) {
            let movieList = data.boxOfficeResult.dailyBoxOfficeList;
            
            $("#boxoffice").empty();
			console.log(movieList);
            let img = "";
            
            for (let i in movieList) {
              $.ajax({
                url: "jsp/dw/getMovie.jsp", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
                async: false,
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
							
                    "<div class='boxContainer'><div class='boxPoster'><a href='"+json.link+"'><img class='boxImg' src= '" +
                      json.img +
                      "'></a></div>" + 
                      "<span class='boxContent' id='" +
                      movieList[i].movieCd + 
                      "'>"  +
                      
                      movieList[i].rank +"위 </span> <div class='boxTable'><div class='boxTitle'><span class='boxT'>"+movieList[i].movieNm+"</span><br>"
                    +  json.subtitle +"<br> <span class='boxText Text'>개봉일 </span>" + movieList[i].openDt +"</div> <div class='boxInfo'>"
                    + "<span class='boxText'>감독</span>"+json.director +"<br><span class='boxText'>배우</span>" +json.actor +"<br> <span class='boxText yearText'>제작 년도</span>"+ json.pubDate +
                     "년</div><div class='boxEtc'><span class='boxText Text'>매출액 </span>"+movieList[i].salesAcc+"원<br> <span class='boxText Text'>관객수 </span>"+movieList[i].audiAcc+"명</div></div></div>"
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
  	function customSort(a, b) {
		   return  a.rank  -  b.rank ;
		}
    </script>

</head>
<body>
	<div class="boxofficeContainer">	
		<div class="boxofficBefore">
		<input type="date" value="" id="date" />
		<button id="mybtn">확인</button>
		<div id="boxoffice">
			<marquee behavior="alternate">
			
			<span style="color: white; position: relative;
    			width: 500px;
   				min-width: 200px;
   				display: flex;
    			text-align: left;
   		 		margin: 200px 20px;
   		 		font-size: 30pt;"
   		 		>날짜별 박스오피스 순위를 검색해보세요!</span>
   		 	</marquee>
   		 	<div style="height:700px;">
   		 </div>
   		 </div>
		</div>
	</div>


</body>
</html>
