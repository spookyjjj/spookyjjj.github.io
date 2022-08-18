<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호변경</title>
</head>
<body>
	<form action="changePwd.do" method="post">
		<p>
		현재 암호: <br/><input type="password" name="curPwd">
		<c:if test="${ errors.curPwd }">현재 암호를 입력하세요.</c:if>
		<c:if test="${ errors.badCurPwd }">현재 암호가 일치하지 않습니다.</c:if>
		</p>
		<p>
		새 암호: <br/><input type="password" name="newPwd">
		<c:if test="${ errors.newPwd }">새 암호를 입력하세요.</c:if>
		</p>
		<input type="submit" value="암호 변경">
	</form>
</body>
</html>