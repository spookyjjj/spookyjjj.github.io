<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="u" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판 예제</title>
</head>
<body>
	<!-- <c:if test="${! empty authUser }"> --> <!-- session에 setAtrribute해온거 찾음 -->
	<u:isLogin>
		${ authUser.name }님, 안녕하세요.
		<a href="logout.do">[로그아웃하기]</a> <!-- 주소로 이동하면 get방식!! -->
		<a href="changePwd.do">[암호변경하기]</a> <!-- 주소로 이동하면 get방식!! -->
		<a href="article/list.do">[게시판가기]</a> <!-- 주소로 이동하면 get방식!! -->
	</u:isLogin>
	<!-- </c:if> -->
	
	<!-- <c:if test="${ empty authUser }"> --> <!-- session에 setAtrribute해온거 찾음 -->
	<u:notLogin>
		<a href="join.do">[회원가입하기]</a> <!-- 주소로 이동하면 get방식!! -->
		<a href="login.do">[로그인하기]</a> <!-- 주소로 이동하면 get방식!! -->
	</u:notLogin>
	<!-- </c:if> -->
	<br/>
</body>
</html>