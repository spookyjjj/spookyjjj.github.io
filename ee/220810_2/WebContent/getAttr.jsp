<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${ requestScope.name1 }</p>
	<p>${ requestScope.name2 }</p>
	<p>${ applicationScope.name3 }</p>
	<p>${ requestScope.name4 }</p> <!-- req4 -->
	<p>${ applicationScope.name4 }</p> <!-- app4 -->
	<hr />
	<!-- 그냥 이름으로도 부를 수 있다 -->
	<p>${ name1 }</p>
	<p>${ name2 }</p>
	<p>${ name3 }</p>
	<p>${ name4 }</p> <!-- req4 -->
	<!-- ★같은 이름이면 좁은 영역의 것부터 찾는다~! request < application -->
	<hr />
	<!-- 없는값을 부르면 그냥 공백! null아님~ -->
	<p>${ none }</p>
</body>
</html>