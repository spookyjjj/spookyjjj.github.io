package member.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.ChangePasswordService;
import member.service.InvalidPasswordException;
import member.service.MemberNotFoundException;
import mvc.command.CommandHandler;

//★구현 흐름!
//GET 방식으로 요청이 오면 기본폼인 changePwdForm.jsp 리턴
//POST 방식으로 요청이 오면 ChangePasswordService를 이용해 처리하고, 결과를 보여주는 뷰를 리턴
//그 결과가 1)
//그 결과가 2)

public class ChangePasswordHandler implements CommandHandler{

	public static final String FORM_VIEW = "/WEB-INF/view/changePwdForm.jsp";
	private ChangePasswordService changePasswordService = new ChangePasswordService();
	
	//★ControllerUsingURI에 의하여 process메소드가 실행됨~!
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) { //대소문자 구분없이 동일일경우
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null; 
		}
	}
	
	//get방식->정보변경폼으로~
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}
	//post방식->등록여부조회 후 갈 길 가기~
	//한번 get방식으로 왔다가 제출눌러서 여기로 돌아온거니(post) param이 채워진 상태! 
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		User user = (User) req.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors); //참조를 연결시켜 놓는과정!
		
		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");
		
		if (curPwd == null || curPwd.isEmpty()) { 
			errors.put("curPwd", Boolean.TRUE);
		}
		if (newPwd == null || newPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		if (!errors.isEmpty()) { //에러가 존재하면 되돌아감
			return FORM_VIEW;
		}
		
		//위에서 발견한 오류 없으면 비번 변경 실행
		try {
			changePasswordService.changePassword(user.getId(), curPwd, newPwd);
			//changePasswordService에서 DB비번변경 실행 -> 두가지 에러발생 가능
			return "/WEB-INF/view/changePwdSuccess.jsp";
		} catch(InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		} catch(MemberNotFoundException e) { //암호를 변경할 회원 아이디가 존재하지 않는다? 잘못된요청 400코드
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
