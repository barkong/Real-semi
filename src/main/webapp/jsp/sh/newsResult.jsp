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

<span class="newsTitle">${ i.title } </span><br>
<span class="newsContent"> ${ i.description }</span><br>
<span class="newsLink"><a href="${ i.link }">${ i.link }</a></span><hr>

</c:forEach> 
</body>
</html>