<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// scriptlet 영역
		System.out.println("사용자가 jsp 페이지를 요청했습니다.");
		int a = 10;
	%>
	<p>jsp 페이지 입니다.</p>
	<strong><%= java.time.LocalTime.now() %></strong><br />
	<p>a의 값은 <%= a %>입니다</p>
	<%--
		<p>b의 값은 <%= b %>입니다</p>
		<%
			int b = 20;
		%>
	--%>
</body>
</html>




