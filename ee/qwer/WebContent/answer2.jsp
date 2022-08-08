<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>quizquiz</title>
<style>
	.answer{
	color:blue;
	}
	.wrong{
	color:red;
	}
</style>
</head>
<body>
<p>정답확인</p>
	<% 
		Map<Integer,String> map2 = new HashMap<>();
		
		map2.put(1, "퀴즈퀴즈");
		map2.put(2, "이진호");
		map2.put(3, "31");
		map2.put(4, "부산");
		map2.put(5, "로스트아크");	
	
	
		String a = "";
		String c = "";
		int num =  Integer.parseInt(request.getParameter("num"));
		if (request.getParameter("answer").equals(map2.get(num))) {
			a = "정답입니다.";
			c = "answer";
		} else {
			a = "오답입니다.";
			c = "wrong";
		}
	%>
	<p id="answer" class="<%= c %>"><%= a %></p>
	<a href="http://localhost:8080/qwer/quiz2.jsp">전 페이지로 돌아가기</a>
</body>
<script>
	let answer = document.getElementById("answer");
	if (getElementById("answer").value == "정답입니다."){
		answer.className = "answer"
	}
	else if (getElementById("answer").value == "오답입니다.") {
		answer.className = "wrong"
	}
</script>
</html>