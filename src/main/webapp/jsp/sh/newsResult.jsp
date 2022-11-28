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
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css"/>
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
		container.pagination({
					dataSource : data.items,
					pageSize : 5,
					callback : function(data, pagination) {
					let content = "";
						$.each(data,function(index, i) {
				console.log(content);
				content += "<div class='news'><span class='time'>"
				+ i.pubDate
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
	<div id="newsContainer"></div>
	<div class="page">
	<div id="pagination">
	</div>
	</div>
</body>
</html>