<%@page import="kr.co.greenart.Country"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.greenart.CountryDAO"%>
<% 
	String continent = request.getParameter("continent");
	CountryDAO dao = new CountryDAO();
	List<Country> list = dao.getCountryByContinent(continent);
	
	request.setAttribute("continent", continent);
	request.setAttribute("countryList", list);
	
	request.getRequestDispatcher("result2.jsp").forward(request, response);
%>