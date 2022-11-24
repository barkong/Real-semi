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
	<form action="MovieSearchC">

		<div id="searchResultContainer">
			<c:forEach var="i" items="${ movies}">

				<div id="movie">

					<div class="poster">
						<a href="<c:url value='${ i.link }'/>"><img src="${i.img }"></a>
					</div>

					<div class="content">
						<span class="title">${ i.title }</span><br> <span
							class="subTitle">(${ i.subTitle })</span>

						<div class="etc">
							개봉년도 ${ i.pubDate }년<br> 배우 - ${ i.actor }<br>감독 - ${ i.director }<br>
							${i.rating }점
						</div>
					</div>

				</div>
			</c:forEach>
		</div>
	</form>


</body>
</html>