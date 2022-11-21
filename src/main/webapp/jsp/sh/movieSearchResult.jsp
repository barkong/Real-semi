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
<span>영화검색</span><input name=movie >

 <c:forEach var="i" items="${ movies}"> 
<span>제목 : ${ i.title } </span><br>
<span>배우 : ${ i.actor }</span><br>
<span>제목 : ${ i.director }</span><br>
<span>제목 : ${ i.link }</span><br>
<img src="${i.image }"><hr>
</c:forEach> 
 <h2>뉴스</h2>
<c:forEach var="i" items="${ news}"> 
<span>제목 : ${ i.title } </span><br>
<span>배우 : ${ i.description }</span><br>
<span>제목 : ${ i.link }</span><br>

</c:forEach> 

</form>
</body>
</html>