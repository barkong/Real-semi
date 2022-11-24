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

<div id="searchResultContainer">
 <c:forEach var="i" items="${ movies}"> 
 <div style="border:1px solid white" id="movie">
 <div class="poster">
<img src="${i.img }">
</div> 
<div class="content">
<span class="title">${ i.title }</span> <br>
<div class="etc">
<span>배우 : ${ i.actor }<br>
감독 : ${ i.director }<br>
평점 : ${i.rating }<br></span>
</div>
</div>
</div>
</c:forEach>
</div> 
</form>
 
</body>
</html>