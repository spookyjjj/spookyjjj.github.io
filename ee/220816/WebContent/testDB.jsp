<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.co.greenart.MyContextListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커넥션 테스트</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = MyContextListener.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select 1");
			if(rs.next()) {
				out.println(rs.getInt(1));
			}
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		
	%>

</body>
</html>