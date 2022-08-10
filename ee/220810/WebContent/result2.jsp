<%@page import="kr.co.greenart.Country"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getAttribute("continent") %></title>
</head>
<body>
	<h3><%= request.getAttribute("continent") %> 국가들 목록</h3>
	
	<%-- <%
      List<Country> list = (List<Country>) request.getAttribute("countryList");
	%>
	<ul>
	<% 
 		for(Country c : list) {
 			out.println("<li>" + c.toString() + "</li>");
 		}
    %>   
	</ul> --%>
	
	<c:if test="${ not empty countryList }" > <!-- empty는 list가 null, size==0등등 일때를 통칭 -->
		<ul>
			<c:forEach var="country" items="${ countryList }">
				<li>${ country.name } ${ country.population }</li>
			</c:forEach>		
		</ul>
	</c:if>
</body>
</html>