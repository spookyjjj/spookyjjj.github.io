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
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	out.println("<strong>" + name + "</strong>" + "(" + age + ")" + "님 반갑습니다!");
	%>
</body>
</html>