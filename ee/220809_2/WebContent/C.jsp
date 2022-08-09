<%--<%@page import="java.util.Random"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C</title>
</head>
<body>
	<p>랜덤숫자</p>
	<%-- <%
	Random random = new Random();
	int ran = random.nextInt(100);
	out.println(ran);
	%> --%>
	<% Object result = request.getAttribute("result"); %>
	<p><%= result %></p>
</body>
</html>