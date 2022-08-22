<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form action="modify.do" method="post">
		<!-- modReq는 ModifyArticleHandler에서 심어놓은거임~ -->
		<input type="hidden" name="no" value="${modReq.articleNumber}">
		<p>
			번호: <br/> ${ modReq.articleNumber }
		</p>
		<p>
			제목:<br/><input type="text" name="title" value="${ modReq.title }">
			<c:if test="${ errors.title }">제목을 입력하세요.</c:if> 
		</p>
		<p>
			내용:<br/><textarea name="content" rows="5" cols="30">${ modReq.content }</textarea>
			<c:if test="${ errors.title }">제목을 입력하세요.</c:if> 
		</p>
		<input type="submit" value="글 수정">
	</form> 
</body>
</html>