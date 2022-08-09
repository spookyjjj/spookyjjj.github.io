<%@page import="java.sql.DriverManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	<%-- 사용자가 대륙을 선택할 수 있게  --%>
	<%-- 선택한 대륙에 속한 국가들의 이름, 인구를 볼 수 있게 (인구내림차순 정렬)페이지  --%>
	<% 
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<String> continentList = new ArrayList<>();
	
	try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select distinct continent from country");
		while (rs.next()) {
			String continent = rs.getString("continent");
			continentList.add(continent);
		}
	} finally {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
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
<p>대룩을 선택하시면 해당 대륙의 국가들과 인구가 인구 내림차순으로 나옵니다</p>
<form action="./searchView.jsp">
<select name="continent">
    <%
    for (String s : continentList) {
    	out.println("<option value=\"" + s + "\">" + s + "</option>");
    }
    %>
</select>
<input type="submit" />
</form>

</body>
</html>