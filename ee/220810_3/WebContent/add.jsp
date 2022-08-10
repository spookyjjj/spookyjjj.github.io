<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>사람 등록 페이지</h3>
	<form action="./addServlet">
		<label>이름<input type="text" name="firstname" required /></label> <br />
		<label>성<input type="text" name="lastname" required /></label> <br />
		<label>나이<input type="number" name="age" required /></label> <br />
		<label>이메일<input type="text" name="email" required /></label> <br />
		<input type="submit" />
	</form>
</body>
</html>