<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="newsContainer">
		<c:forEach var="i" items="${news}">
			<div id="news">
				<span class="time">${ i.time }</span>
				<div id="title">
					<a href="${ i.link }"><span class="newsTitle">${ i.title }</span>
					</a>
					<div class="hiddenMsg">
						<span>⬅ 뉴스 원문 보러가기</span>
					</div>
				</div>

				<span class="newsContent">${ i.description }</span>
			</div>
			</c:forEach>
			 
			<span><a href="NaverNewsPageC?p=1">[맨처음]</a></span>
			<c:forEach var="i" begin="1	" end="${pageCount }">
				<a href="NaverNewsPageC?p=${i }"> [${i }] </a>
			</c:forEach>
			<span><a href="NaverNewsPageC?p=${pageCount }">[맨끝]</a></span> 

		

	</div>
</body>
</html>