<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%
	List<String> list = new ArrayList<>();
	for (int i = 0; i < 100; i++) {
		list.add("book" + i);
	}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청에 따라 보여줄 페이지</title>
</head>
<body>
	<!--10단위일 때 범위~ : 1 -> 0~9 // 2 -> 10~19 // ... -->
	<% 
	int pageNum = Integer.parseInt(request.getParameter("page")); 
	%>
	<ul>
		<% 
		for(int i = (pageNum - 1) * 10; i < pageNum * 10; i++) {			
			out.println("<li>");
			out.println(list.get(i));
			out.println("</li>");
		}
		%>
	</ul>
</body>
</html>