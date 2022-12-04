<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/boxoffice.css" />
<link rel="stylesheet" href="css/calendar.css" />
<script src="js/calendar.js"></script>
<script>
	$(function() {
		let y = new Date();
		y.setDate(y.getDate() - 1);
		let str = y.getFullYear() + "-" + ("0" + (y.getMonth() + 1)).slice(-2)
				+ "-" + ("0" + y.getDate()).slice(-2);
		$("#date").attr("max", str);

		$("td")

				.click(
						function() {

							let yyyy = $("#cal_top_year").text();
							let mm = $("#cal_top_month").text();

							let dd = $(this).text();
							dd = dd.trim();

							dd = (dd.length == 1) ? '0' + dd : dd;

							let datee = yyyy + mm + dd;
							let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt="
									+ datee;

							$
									.getJSON(
											url,
											function(data) {
												let movieList = data.boxOfficeResult.dailyBoxOfficeList;

												$("#boxoffice").empty();
												let img = "";

												for ( let i in movieList) {
													$
															.ajax(
																	{
																		url : "jsp/dw/getMovie.jsp", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
																		async : false,
																		data : {
																			title : movieList[i].movieNm
																		}, // HTTP 요청과 함께 서버로 보낼 데이터
																		method : "GET", // HTTP 요청 메소드(GET, POST 등)
																		dataType : "json", // 서버에서 보내줄 데이터의 타입
																	})
															// HTTP 요청이 성공하면 요청한 데이터가 done() 메소드로 전달됨.
															.done(
																	function(
																			json) {

																		$(
																				"#boxoffice")
																				.append(

																						"<div class='boxContainer'><div class='boxPoster'><a href='"+json.link+"'><img class='boxImg' src= '" +
                      json.img +
                      "'></a></div>"
																								+ "<span class='boxContent' id='" +
                      movieList[i].movieCd + 
                      "'>"
																								+

																								movieList[i].rank
																								+ "위 </span> <div class='boxTable'><div class='boxTitle'><span class='boxT'>"
																								+ movieList[i].movieNm
																								+ "</span><br>"
																								+ json.subtitle
																								+ "<br> <span class='boxText Text'>개봉일 </span>"
																								+ movieList[i].openDt
																								+ "</div> <div class='boxInfo'>"
																								+ "<span class='boxText'>감독</span>"
																								+ json.director
																								+ "<br><span class='boxText'>배우</span>"
																								+ json.actor
																								+ "<br> <span class='boxText yearText'>제작 년도</span>"
																								+ json.pubDate
																								+ "년</div><div class='boxEtc'><span class='boxText Text'>매출액 </span>"
																								+ movieList[i].salesAcc
																								+ "원<br> <span class='boxText Text'>관객수 </span>"
																								+ movieList[i].audiAcc
																								+ "명</div></div></div>");

																	})

															.fail(
																	function(
																			xhr,
																			status,
																			errorThrown) {
																		$(
																				"#text")
																				.html(
																						"오류가 발생했다.<br>")
																				.append(
																						"오류명: "
																								+ errorThrown
																								+ "<br>")
																				.append(
																						"상태: "
																								+ status);
																	});
													// 이름값을 쿼리로 네이버에 전송해서 이미지값 받아오기
												}
											});
						}); //button click
	}); //ready
	function customSort(a, b) {
		return a.rank - b.rank;
	}
</script>

</head>
<body>
	<div class="cal_top">
		<a href="#" id="movePrevYear"><span id="prevYear" class="cal_tit2">◁</span></a>
		<a href="#" id="movePrevMonth"><span id="prevMonth"
			class="cal_tit">&lt;</span></a> <span id="cal_top_year"></span> <span
			id="cal_top_month"></span> <a href="#" id="moveNextMonth"><span
			id="nextMonth" class="cal_tit">&gt;</span></a> <a href="#"
			id="moveNextYear"><span id="nextYear" class="cal_tit2">▷</span></a>
	</div>
	<div id="cal_tab" class="cal"></div>
	<div class="boxofficeContainer">
		<div class="boxofficBefore">
			<div class="boxComment">※ 보고싶은 박스오피스 순위의 날짜를 선택해 주세요</div>
			<!-- <input type="date" value="" id="date" />
		<button id="mybtn">확인</button> -->
			<div id="boxoffice"></div>
		</div>

	</div>


</body>
</html>
