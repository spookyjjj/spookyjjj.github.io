<%--
 jsp 페이지에
 사용자의 이름(name)과 나이(age)
 성별(gender)을 입력받을 수 있는
 <form> 양식을 작성해보세요~~~
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 입력 페이지</title>
</head>
<body>
	<form action="/minee/requestInfo.jsp" method="get" >
		<label>이름<input type="text" name="name" /></label>
		<label>나이<input type="number" name="age" /></label>
		<label><input type="radio" name="gender" value="male" />남성</label>
		<label><input type="radio" name="gender" value="female" />여성</label>
		<label><input type="checkbox" name="hobby" value="java">자바</label>
		<label><input type="checkbox" name="hobby" value="html">하이퍼 텍스트 마크업 랭귀지</label>
		<label><input type="checkbox" name="hobby" value="css">캐스캐이딩 스타일 시트</label>
		<label><input type="checkbox" name="hobby" value="javascript">자바스크립트</label>
		<input type="submit" value="입력 완료" />
	</form>
</body>
</html>













