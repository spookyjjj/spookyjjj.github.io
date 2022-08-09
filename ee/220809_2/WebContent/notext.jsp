<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = 1 + 1;
	//response.sendRedirect("./viewPage.jsp");
	
	//연산결과 보내기 1안  : 파라미터에 붙여보내기 <- (O)
	//response.sendRedirect("./viewPage.jsp?result=" + result);
	
	//연산결과 보내기 2안 : application 객체 사용하기 <- (O) but,전역변수처럼 범위가 크게 존재해서 불안정하다는 단점
	//application.setAttribute("result", result);
	//response.sendRedirect("./viewPage.jsp");
	
	//연산결과 보내기 3안 : request 객체 사용하기 <- (X) request객체는 넘어가지 못함
	//request.setAttribute("result", result);
	//response.sendRedirect("./viewPage.jsp");
	
	//연산결과 보내기 4안 : forward로 페이지 이어버리기 <- (O) 3안의 해결방안!
	request.setAttribute("result", result);
	request.getRequestDispatcher("./WEB-INF/viewPage.jsp").forward(request, response);
	//forward(request, response) -> 내가쓰던 응답객체request와 반응객체response를 그대로 전달해라~
	//★forward를 쓸거면 response가 아닌 request의 getRequestDispatcher를 이용해야 사용가능~!
%>
