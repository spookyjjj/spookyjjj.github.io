
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정답 페이지</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
달력 문제 : 
<% 
	if(Integer.valueOf(request.getParameter("answer1")) == 15) {
%>
맞췄습니다!<br />
<%	
	} else {
%>
틀렸습니다... 15일이예요...<br />
<%	
	}
%>
소금물 문제 : 
<% 
	if(Integer.valueOf(request.getParameter("answer2")) == 10) {
%>
맞췄습니다!<br />
<%	
	} else {
%>
틀렸습니다... 10%입니다...<br />
<%	
	}
%>
왜 따로가는걸까... 문제 : 
<% 
	if(Integer.valueOf(request.getParameter("answer3")) == 2) {
%>
거리를 맞췄습니다! 
<%	
	} else {
%>
거리가 틀렸습니다... 2km입니다...
<%	
	}
%>
<% 
	if(Integer.valueOf(request.getParameter("answer4")) == 7 && Integer.valueOf(request.getParameter("answer5")) == 30) {
%>
시간을 맞췄습니다!<br />
<%	
	} else {
%>
시간이 틀렸습니다...7시 30분입니다...<br />
<%	
	}
%>
</body>
</html>