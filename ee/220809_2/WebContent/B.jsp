<%--<%@page import="java.time.LocalDate"%>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B</title>
</head>
<body>
	<p>현재날짜</p>
	<%-- <%= LocalDate.now() %> --%>
	<% Object result = request.getAttribute("result"); %>
	<p><%= result %></p>
</body>
</html>