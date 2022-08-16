<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>요청객체 값 확인 : <%= request.getAttribute("reqTest") %></p>
	<p>세션객체 값 확인 : <%= session.getAttribute("sessionTest") %></p>
</body>
</html>