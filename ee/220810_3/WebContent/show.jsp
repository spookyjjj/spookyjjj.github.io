<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사람 목록</title>
</head>
<body>
	<c:if test="${ not empty personsList }" > <!-- empty는 list가 null, size==0등등 일때를 통칭 -->
		<ul>
			<c:forEach var="persons" items="${ personsList }">
				<li>${ persons }</li>
			</c:forEach>		
		</ul>
	</c:if>
	<a href="./">메인으로 돌아가기</a>
</body>
</html>