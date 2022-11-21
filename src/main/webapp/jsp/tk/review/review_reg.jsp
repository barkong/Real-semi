<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tk/review.css" />
<script type="text/javascript" src="js/tk/review.js"></script>
</head>
<body>

	<h1>Reg</h1>

	<form action="ReviewRegC" method="post" enctype="multipart/form-data">

		<table border="1" align="center">
			<tr>
				<td>영화제목</td>
				<td><input name="movie" /></td>
			</tr>
			<tr>
				<td>글제목</td>
				<td><input name="title" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="detail" rows="15" cols="50"
						style="resize: none"></textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="img"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button>등록</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>