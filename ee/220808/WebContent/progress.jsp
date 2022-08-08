<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<p>로그인 처리 요청이 전달되었나요?</p>
	<%
		String id = request.getParameter("userid");
		//사용자의 입력값이 있으면 xx님 반갑습니다.
		//★파라미터에, 입력 값 없이 전달 되었으면 ""
		//★없는 파라미터를 getParameter하면, null
		if (id.length() > 0) {
			out.println(id + "님 반갑습니다.");
		} else {
			out.println("입력해주세요.");
			//response.sendRedirect("http://naver.com");
			response.sendRedirect("./login.jsp");
			//response읽는순간, 출력버퍼에 있는 내용을 안보여줌. 브라우저에게 바로 redirect하라는 응답만을 보냄
			//그러면 브라우저는 그 redirect주소로 다시 요청보냄 -> 그럼 네이버/login.jsp가 응답하는거임~
			//원래는 요청 개개는 독립적이기 때문에(접속할 때만 연결하고 바로 연결 끊어버림) 얘가 리다이렉트로 온 애인지 처음 온 애인지 모름
			//아까 온 애라는걸 기억해야 리다이렉트로 넘어간 new접속 로그인페이지에서는 다른 결과를 출력할 수 있음..그 방법?
			//1. 연결 끊지말고 유지해서 기억하기
			//2. 요청마다 ip에 id를 부여해서 기억함★(클라이언트 쪽 : cookie, 서버 쪽: Session);;;;;
		}
	%>
</body>
</html>