<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tk/free.css" />
<script type="text/javascript" src="js/tk/free.js"></script>
</head>
<body>
	<h1>Free Content</h1>
	<div class="container" align="center">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="text-align: center;">글제목 :
							${free.f_title }</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>NO. : ${free.f_no }</td>
						<td>등록시간 : <fmt:formatDate value="${free.f_date }"
								type="both" dateStyle="short" timeStyle="short" /></td>
						<td>조회수 : ${free.f_count }</td>
					</tr>
					<tr>
						<td colspan="3">${free.f_detail}</td>
					</tr>
					<tr>
						<td colspan="3"><img src="files/reviewImg/${free.f_img }"
							width="500px"></td>
					</tr>
					<tr>
						<td colspan="3"><a href="FreeC">목록으로</a> <c:if
								test="${sessionScope.accountInfo.a_id eq free.f_id}">
								<button onclick="location.href='FreeUpdateC?no=${param.no}'">수정</button>
								<button onclick="freeDel(${free.f_no})">삭제</button>
								<button onclick="location.href='FreeRegC?no=${param.no}'">글쓰기</button>
							</c:if></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>