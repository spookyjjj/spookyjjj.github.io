<%@page import="java.sql.*"%>
<%@page import="jdbc.connection.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연결테스트</title>
</head>
<body>
	<% 
		try (Connection conn = ConnectionProvider.getConnection()) {
			out.println("커넥션 연결 성공함");
		} catch(SQLException ex) {
			out.println("커넥션 연결 실패함: "+ ex.getMessage());
			application.log("커넥션 연결 실패", ex);
		}
	%>
</body>
</html>