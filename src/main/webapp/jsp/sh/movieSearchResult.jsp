<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="MovieSearchC" >
<<<<<<< HEAD
<h1>검색 결과</h1><a href="MovieSearchC"><h5>검색창으로 가기</h5></a>
<input name=movie ><br>

 <c:forEach var="i" items="${ movies}"> 
포스터 :<img src="${i.img }"> <br>
제목 :${ i.title } <br>
배우 : ${ i.actor }<br>
감독 : ${ i.director }<br>
평점 : ${i.rating }<br>
<a href="<c:url value='${ i.link }'/>">영화 링크</a><br><hr>
</c:forEach> 

 <c:forEach var="i" items="${ movieInfos}"> 
 제목 : ${ i.movieNm}	<br>
 상영일 : ${i.openDt }	<br>
  감독 : ${i.directors }	<br>
  장르 : ${i.genreAlt }	<br>
  회사 : ${i.companys }	<br>
</c:forEach> 

</form>
 <c:forEach var="i" items="${ news}"> 
뉴스 제목 : ${ i.title}	<br>
뉴스 내용 : ${i.description }	<br>
뉴스 url : ${i.originallink }	<br>
</c:forEach> 
</body>
</html>