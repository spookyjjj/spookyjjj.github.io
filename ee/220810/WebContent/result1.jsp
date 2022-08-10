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
<title>국가보기</title>
</head>
<body>
	<%
      List<String> list = (List<String>) request.getAttribute("continentList");
	%>
<p>대룩을 선택하시면 해당 대륙의 국가들과 인구가 인구 내림차순으로 나옵니다</p>

<form action="./world.jsp">
<select name="continent">
    <%
    for (String s : list) {
    	out.println("<option value=\"" + s + "\">" + s + "</option>");
    }
    %>
</select>
<input type="submit" />
</form>

</body>
</html>