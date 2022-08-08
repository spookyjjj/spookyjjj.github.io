<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quizquiz</title>
</head>
<body>
	<p>다음 문제의 답을 입력하세요</p>
	<!-- <p>Q : 이게임의이름은?</p> -->
	<%
		Random r = new Random();
		int num = r.nextInt(5)+1;
		Map<Integer,String> map = new HashMap<>();
	
		map.put(1,"이 게임의 이름은?");
		map.put(2,"내 이름은?");
		map.put(3,"내 나이는?");
		map.put(4,"내가 사는 도시는?");
		map.put(5,"내가 요즘 하는 게임은?");
	%>
	<%= map.get(num).toString() %>

	<form action="/qwer/answer2.jsp" method="get">
		<input type="text" name="answer">
		<input type="submit">
		<input type="hidden" name="num" value="<%= num %>" />
	</form>
</body>
</html>