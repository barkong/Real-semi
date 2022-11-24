<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tk/review.css" />
<script type="text/javascript" src="js/tk/review.js"></script>
</head>
<body>
	<h1>Review Content</h1>
	<div class="container" align="center">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="text-align: center;">글제목 :
							${review.r_title }</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>영화제목</td>
						<td>${review.r_movie }</td>
					</tr>
					<tr>
						<td>NO. : ${review.r_no }</td>
						<td>등록시간 : <fmt:formatDate value="${review.r_date }"
								type="both" dateStyle="short" timeStyle="short" /></td>
						<td>조회수 : ${review.r_count }</td>
					</tr>
					<tr>
						<td colspan="3">${review.r_detail}</td>
					</tr>
					<tr>
						<td colspan="3"><img src="files/reviewImg/${review.r_img }"
							width="500px"></td>
					</tr>
					<tr>
						<td colspan="3"><a href="ReviewC">목록으로</a> <c:if
								test="${sessionScope.accountInfo.a_id eq review.r_id}">
								<button onclick="location.href='ReviewUpdateC?no=${param.no}'">수정</button>
								<button onclick="reviewDel(${review.r_no})">삭제</button>
								<button onclick="location.href='ReviewRegC?no=${param.no}'">글쓰기</button>
							</c:if></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>