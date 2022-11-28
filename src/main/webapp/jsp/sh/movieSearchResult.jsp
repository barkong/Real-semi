<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.js"
	integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
	crossorigin="anonymous"></script>
<script type="text/javascript" src="js/pagination.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css" />
<!-- <script type="text/javascript">
	$(function() {
		$.ajax({
			url : "MovieSearchC2",
			data : 
			dataType : "json",
			success : function(data) {
				successCall(data);
			}
		});
	});

	function successCall(data) {
	console.log(data);

		let container = $('#pagination');
		container.pagination({
					dataSource : data.items,
					pageSize : 5,
					callback : function(data, pagination) {
					let content = "";
						$.each(data,function(index, i) {
				console.log(content);
				content += "<form action='MovieSearchC'><div id='movie'><div class='poster'>"
				+ "<a href='"+ i.link + "'>+"+
				"<img src='"+ i.img + "'/></a></div>" 
				+"<div class='content'><span class='title'>"
				+i.title
				+"</span><br><span class='subTitle> (" 
				+i.subTitle
				+")</span>'"
				+ "<div class='etc' 개봉년도 >"
				+i.pubDate + "<br> 배우 -"
				+i.actor +"<br> 감독 -" 
				+i.director +"<br> 평점" 
				+i.rating +"</div></div></div></form>"
						});

			$("#searchResultContainer").html(content);
					}
				});
	}
	
</script> -->
</head>
<body>

		<div id="searchResultContainer"></div>
		<div id="pagination"></div>

</body>
</html>