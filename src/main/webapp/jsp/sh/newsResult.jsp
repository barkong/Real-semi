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
<h2>뉴스</h2>
<c:forEach var="i" items="${ news}"> 

<span>제목 : ${ i.title } </span><br>
<span>내용 : ${ i.description }</span><br>
<span>링크 : <a href="<c:url value='${ i.link }'/>">${ i.link }</a></span><br><hr>


</c:forEach> 
</body>
</html>