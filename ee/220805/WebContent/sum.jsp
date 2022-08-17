<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public int getSum(int lastNumber) {
		int sum = 0;
		for (int i = 0; i <= lastNumber; i++) {
			sum += i;
		}
		return sum;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>합 구하기</title>
</head>
<body>
	<p>jsp scriptlet을 활용한 합계 구하기</p>
	<%
		int sum = 0;
		for (int i = 0; i <= 10; i++) {
			sum += i;
		}
	%>
	<p>0 ~ 10 까지의 합 : <%= sum %></p>
	<p><%= 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 %></p>
	<p>0 ~ 100 까지의 합 : <%= getSum(100) %></p>
	<p><%= "문자열값" %></p>
	<p><%= true %></p>
	<p><%= 123.456 %></p>
</body>
</html>