<!-- 
	입력 폼
	숫자1
	숫자2
	연산자 + - * / 선택
	전송
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<form action="./calcresult.jsp">
		<input type="number" name="num1" required/>
		<select id="select_value" name="calc">
			<option value="plus">+</option>
			<option value="minus">-</option>
			<option value="multiply">*</option>
			<option value="divide">/</option>
		</select>
		<input type="number" name="num2" required/>
		<br />
		<input type="submit" />
	</form>
</body>
</html>