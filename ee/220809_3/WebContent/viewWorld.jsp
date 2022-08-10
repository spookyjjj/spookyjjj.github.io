<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>국가 목록</title>
</head>
<body>
	<!-- ul, li 목록 표현 -->
	<%
		List<String> list = (List<String>) request.getAttribute("countries");
		//getAttribute는 Object를 반환하니깐 다운캐스팅이 필요~!
	%>
	<ul>
	<% for (int i = 0; i < list.size(); i++) { %>
		<li> <%= list.get(i) %> </li>
	<% } %>
	</ul>
</body>
</html>