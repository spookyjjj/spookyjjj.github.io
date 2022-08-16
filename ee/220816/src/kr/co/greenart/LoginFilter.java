package kr.co.greenart;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//서블릿이 요청 객체를 다루기 전
		System.out.println("doFilter 전!!!!");
		System.out.println("세션 값을 확인합니다");
		HttpSession session = ((HttpServletRequest) req).getSession();
		Object loginid = session.getAttribute("loginid");
		
		if (loginid != null) {
			System.out.println("로그인 확인되었습니다. 게시판 목록으로 forward합니다.");
			//원래 흐름 이어갈 수 있게! --기준--
			chain.doFilter(req, resp);
		} else {
			System.out.println("로그인 되지 않은 유저");
			((HttpServletResponse)resp).sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}
		
		//서블릿이 요청을 처리하고 응답 보내기 전
		System.out.println("doFilter 후!!!!");
	}
}
