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
<form action="MovieGenreRecommendC" >
<h5>영화검색</h5><input name=movie >

 <c:forEach var="i" items="${ movies2}"> 
제목 : ${ i.movieNm } <br>
배우 : ${ i.directors }<br>
제목 : ${ i.genre }<br>

</c:forEach> 

</form>
</body>
</html>