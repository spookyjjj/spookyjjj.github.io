<%
	//여기서는 다른 잡다한거 필요 없음 걍 논리만 있으면 됨~
	String select = request.getParameter("select");
	if (select == null || select.length() == 0) {
		response.sendRedirect("./want.jsp?progress=failed");
	} else if (select.equals("persons")) {
		response.sendRedirect("./persons.jsp");
	} else if (select.equals("fruit")) {
		response.sendRedirect("./fruit.jsp");
	}
	
%>