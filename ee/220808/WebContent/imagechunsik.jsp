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
		String[] s;
		if ((s = request.getParameterValues("num")) != null) {
			for (int i = 0; i < s.length; i++) {
				if (s[i].equals("1")) {
					out.println("<img src=\"./images/chunsik/춘식1.png\" />");
				}
				if (s[i].equals("2")) {
					out.println("<img src=\"./images/chunsik/춘식2.png\" />");
				}
				if (s[i].equals("3")) {
					out.println("<img src=\"./images/chunsik/춘식3.png\" />");
				}
			}			
		} else {
			out.println("아무런 숫자도 선택하지 않으셨습니다");
		}
	%>

</body>
</html>