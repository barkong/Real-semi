<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>자유글수정하기</h1>
	<div class="container" align="center">
		<div class="row">
			<form action="FreeUpdateC" method="post"
				enctype="multipart/form-data">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th>글제목</th>
							<th colspan="2" style="text-align: center;"><input
								class="form-control" type="text" value="${free.f_title }"
								name="title"></th>
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
							<td colspan="3"><textarea class="form-control"
									maxlength="2084" name="detail" rows="20" cols="60"
									style="resize: none">${free.f_detail}</textarea></td>
						</tr>
						<tr>
							<td colspan="3"><img src="files/freeImg/${free.f_img }"
								width="500px"></td>
						</tr>
						<tr>
							<td colspan="3"><input type="file" name="img2" /><input
								name="img" value="${free.f_img }" type="hidden"></td>
						</tr>
						<tr>
							<td colspan="3"><a href="FreeC">목록으로</a>
								<button name="no" value="${param.no}">수정</button>
								<button onclick="freeDel(${free.f_no})">삭제</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>