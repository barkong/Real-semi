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
	<c:forEach var="i" items="${ news}">
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
		<%-- <span><a href="<c:url value='${ i.link }'/>">${ i.link }</a></span><br><hr> --%>


	</c:forEach>
	
	</div>
</body>
</html>