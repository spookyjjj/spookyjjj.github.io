<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 선택창</title>
</head>
<body>
	<form action="./to.jsp">
		<select name="alphabet">
			<option value="a">A</option> <!-- 시간 -->
			<option value="b">B</option> <!-- 날짜 -->
			<option value="c">C</option> <!-- 랜덤 정수 숫자 -->
		</select>
		<input type="submit" />
	</form>
</body>
</html>