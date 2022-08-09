<%@page import="java.util.Random"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String alphabet = request.getParameter("alphabet");
	if (alphabet.equals("a")) {
		request.setAttribute("result", LocalTime.now());
		request.getRequestDispatcher("./A.jsp").forward(request, response);
		//response.sendRedirect("./A.jsp");
	} else if (alphabet.equals("b")) {
		request.setAttribute("result", LocalDate.now());
		request.getRequestDispatcher("./B.jsp").forward(request, response);
		//response.sendRedirect("./B.jsp");
	} else if (alphabet.equals("c")) {
		Random r = new Random();
		request.setAttribute("result", r.nextInt());
		request.getRequestDispatcher("./C.jsp").forward(request, response);
		//response.sendRedirect("./C.jsp");
	}
%>