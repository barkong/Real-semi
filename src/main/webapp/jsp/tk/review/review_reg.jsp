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
	<h1>리뷰등록하기</h1>
	<div class="container" align="center">
		<div class="row">
			<form action="ReviewRegC" method="post" enctype="multipart/form-data">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th>글제목</th>
							<th colspan="2" style="text-align: center;"><input
								class="form-control" type="text" name="title" placeholder="글제목"
								maxlength="50" /></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>영화제목</td>
							<td><input class="form-control" type="text" name="movie"
								placeholder="영화제목" maxlength="50" /></td>
						</tr>
						<tr>
							<td colspan="3"><textarea class="form-control"
									placeholder="글내용" maxlength="2084" name="detail" rows="20"
									cols="60" style="resize: none"></textarea></td>
						</tr>
						<tr>
							<td>이미지</td>
							<td><input type="file" name="img"></td>
						</tr>
						<tr>
							<td colspan="3">
								<button>등록</button>
							</td>
						<tr>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>