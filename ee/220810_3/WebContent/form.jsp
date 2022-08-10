<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력폼</title>
</head>
<body>
	<form action="./param"> <!-- ${ pageContext.request.contextPath }/param -->
		<input type="text" name="name" />
		<input type="number" name="age" />
		<input type="submit" />
	</form>
</body>
</html>