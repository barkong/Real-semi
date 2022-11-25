<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>리뷰수정하기</h1>
	<div class="container" align="center">
		<div class="row">
			<form action="ReviewUpdateC" method="post"
				enctype="multipart/form-data">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th>글제목</th>
							<th colspan="2" style="text-align: center;"><input
								class="form-control" type="text" value="${review.r_title }"
								name="title"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>영화제목</td>
							<td colspan="2"><input class="form-control" type="text"
								value="${review.r_movie }" name="movie"></td>
						</tr>
						<tr>
							<td>NO. : ${review.r_no }</td>
							<td>등록시간 : <fmt:formatDate value="${review.r_date }"
									type="both" dateStyle="short" timeStyle="short" /></td>
							<td>조회수 : ${review.r_count }</td>
						</tr>
						<tr>
							<td colspan="3"><textarea class="form-control"
									maxlength="2084" name="detail" rows="20" cols="60"
									style="resize: none">${review.r_detail}</textarea></td>
						</tr>
						<tr>
							<td colspan="3"><img src="files/reviewImg/${review.r_img }"
								width="500px"></td>
						</tr>
						<tr>
							<td colspan="3"><input type="file" name="img2" /><input
								name="img" value="${review.r_img }" type="hidden"></td>
						</tr>
						<tr>
							<td colspan="3"><a href="ReviewC">목록으로</a>
								<button name="no" value="${param.no}">수정</button>
								<button onclick="reviewDel(${review.r_no})">삭제</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>