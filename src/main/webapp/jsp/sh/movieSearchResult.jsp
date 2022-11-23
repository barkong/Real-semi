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

 <c:forEach var="i" items="${ movies}"> 
<img src="${i.img }"> <br>
제목 : ${ i.title } <br>
배우 : ${ i.actor }<br>
감독 : ${ i.director }<br>
평점 : ${i.rating }<br>
<a href="<c:url value='${ i.link }'/>">영화 링크</a><br><hr>
</c:forEach> 
</form>
 
</body>
</html>