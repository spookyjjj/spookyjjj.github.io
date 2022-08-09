<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자가 볼 페이지</title>
</head>
<body>
	<p>정보</p>
	<p>연산결과</p>
	
	<!-- 연상결과 보내기 1안 -->
	<%-- <%= request.getParameter("result") %> --%>
	
	<!-- 연상결과 보내기 2안 -->
	<%-- <%= application.getAttribute("result") %> --%>
	
	<!-- 연상결과 보내기 3안 -->
	<%-- <%= request.getAttribute("result") %> --%>
	
	<!-- 연상결과 보내기 4안 -->
	<%= request.getAttribute("result") %>
</body>
</html>