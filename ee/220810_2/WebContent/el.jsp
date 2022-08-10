<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>JSP Expresstion Language</p>
	${ "qwer" }
	${ 123 }
	${ 55.4321 }
	${ true }
	<br />
	<!-- 관계연산도 가능~ -->
	${ 1 + 2 }
	${ true && false }
	<br />
	<!-- 객체 접근도 가능하더라~ -->
	<!-- el에서는 모든 객체에서 get(Request)를 걍 (request)만 적어도 됨 -->
	${ pageContext.request.requestURI }
</body>
</html>