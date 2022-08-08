<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>뭘 보고 싶니?</title>
</head>
<body>
	<%= request.getParameter("progress") %>
	<form action="./interval.jsp">
		<input type="radio" name="select" value="persons" />사람
		<input type="radio" name="select" value="fruit" />과일
		<input type="submit" />
	</form>
</body>
</html>