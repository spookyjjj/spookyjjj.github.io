<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Map<String, Integer> map = new LinkedHashMap<>(); //HashMap이 아닌 LinkedHashMap을 써야지 순서가 보장된다
	String select = request.getParameter("continent");
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		pstmt = conn.prepareStatement("select name, population from country where continent=? order by Population desc");
		pstmt.setString(1, select);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			map.put(rs.getString("name"), rs.getInt("population"));
		}
	} finally {
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}		
	}
	//request객체에 list를 attribute로 설정하기
	//request.setAttribute("countries", continentList);
	//다음 페이지로 forward 시키기
	//request.getRequestDispatcher("./viewWorld.jsp").forward(request, response);
%> 
<p><h2> <%= select %> </h2></p>
<ul>
	<%
	for(String key : map.keySet()) {
		int population = map.get(key);
		out.println("<li>" + key + " : " + population + "</li>");
     }
	%>
</ul>
</body>
</html>