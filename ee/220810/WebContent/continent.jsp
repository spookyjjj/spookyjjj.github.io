<%@page import="java.util.List"%>
<%@page import="kr.co.greenart.CountryDAO"%>
<% 
	CountryDAO dao = new CountryDAO();
	List<String> list = dao.getContinents();
	
	request.setAttribute("continentList", list);
	request.getRequestDispatcher("result1.jsp").forward(request, response);
%>