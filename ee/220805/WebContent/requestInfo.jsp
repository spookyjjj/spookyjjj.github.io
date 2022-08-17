<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
클라이언트IP = <%= request.getRemoteAddr() %> <br>
요청정보길이 = <%= request.getContentLength() %> <br>
요청정보 인코딩 = <%= request.getCharacterEncoding() %> <br>
요청정보 컨텐츠타입 = <%= request.getContentType() %> <br>
요청정보 프로토콜 = <%= request.getProtocol() %> <br>
요청정보 전송방식 = <%= request.getMethod() %> <br>
요청 URI = <%= request.getRequestURI() %> <br>
컨텍스트 경로 = <%= request.getContextPath() %> <br>
서버이름 = <%= request.getServerName() %> <br>
서버포트 = <%= request.getServerPort() %> <br>
--------------------------<br />
<%
	request.setCharacterEncoding("UTF-8");
%>
<%= request.getRequestURL() %><br />
<%= request.getQueryString() %><br />
사용자 이름 = <%= request.getParameter("name") %> <br />
사용자 나이 = <%= request.getParameter("age") %> <br />
사용자 성별 = <%= request.getParameter("gender") %> <br />
사용자 취미 = <%= Arrays.toString(request.getParameterValues("hobby")) %> <br />
<%
	Map<String, String[]> map = request.getParameterMap();
	for (Entry<String, String[]> e : map.entrySet()) {
		String key = e.getKey();
		String[] value = e.getValue();
%>
		<%= key %><br />
		<%= Arrays.toString(value) %><br />
<%
	}
%><br />
</body>
</html>











