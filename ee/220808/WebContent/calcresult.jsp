<!-- 
	계산결과 출력 페이지
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산결과</title>
</head>
<body>
	<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	String calc = request.getParameter("calc");
	
	out.println("<p>계산결과값은</p>");
	out.println("<br />");
	if (calc.equals("plus")) {
		out.println("<h3>" + (num1 + num2) + "</h3>");
	} else if (calc.equals("minus")) {
		out.println("<h3>" + (num1 - num2) + "</h3>");
	} else if (calc.equals("multiply")) {
		out.println("<h3>" + (num1 * num2) + "</h3>");
	} else if (calc.equals("divide") && num2 != 0){
		out.println("<h3>" + (num1 / num2) + "</h3>");
	} else {
		out.println("<h3>나누기를 할 때, 0으로 하면 안됨</h3>");
	}
	%>
</body>
</html>