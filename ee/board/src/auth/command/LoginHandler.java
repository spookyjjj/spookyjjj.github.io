package auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import member.service.DuplicateIdException;
import member.service.JoinRequest;
import mvc.command.CommandHandler;

//★구현 흐름!
//GET 방식으로 요청이 오면 폼을 보여주는 뷰인 loginForm.jsp를 리턴
//POST 방식으로 요청이 오면 LoginService를 이용해 로그인을 처리하고 결과를 보여주는 뷰를 리턴
//그 결과가 1)성공이면 세션에 user정보 저장하고 index.jsp로 ㄱㄱ
//그 결과가 2)로그인 실패면 LoginFailException를 추가하고 loginForm.jsp으로 다시 ㄱㄱ

public class LoginHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/loginForm.jsp";
	private LoginService loginService = new LoginService();

	// ★ControllerUsingURI에 의하여 process메소드가 실행됨~!
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) { // 대소문자 구분없이 동일일경우
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	// get방식->인덱스폼으로~
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}

	// post방식->로그인여부 확인후 갈 길 가기~
	// 한번 get방식으로 왔다가 제출눌러서 여기로 돌아온거니(post) param이 채워진 상태! 
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if (id == null || id.isEmpty()) {
			errors.put("id", Boolean.TRUE);
		}
		if (password == null || password.isEmpty()) {
			errors.put("password", Boolean.TRUE);
		}
		
		if (!errors.isEmpty()) { //에러가 존재하는 경우
			return FORM_VIEW;
		}
		
		//에러 없으면 이리로
		try {
			User user = loginService.login(id, password); //여기서 LoginFailException에러 발생가능
			req.getSession().setAttribute("authUser", user); //세션범위에서 user저장
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
			return null;
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}
