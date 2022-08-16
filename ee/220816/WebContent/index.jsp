<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
</head>
<body>
	<nav>
		<c:if test="${ empty loginid }">
			<a href="./loginform.jsp">로그인하기</a>
		</c:if>
		<c:if test="${ not empty loginid }">
			<a href="./board">게시글보기</a>
			<a href="./logout.jsp">로그아웃</a>
		</c:if>
	</nav>
</body>
</html>