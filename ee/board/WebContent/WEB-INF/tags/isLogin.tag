<%@ tag body-content="scriptless" pageEncoding="utf-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%
	HttpSession httpSession = request.getSession(false);
	if (httpSession != null && httpSession.getAttribute("authUser") != null) {
%>
		<jsp:doBody />
<%
	}
%>
<%-- 로그인세션이 존재할 때  몸체 내용을 출력한다 --%>