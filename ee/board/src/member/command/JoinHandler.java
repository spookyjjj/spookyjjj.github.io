package member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.DuplicateIdException;
import member.service.JoinRequest;
import member.service.JoinService;
import mvc.command.CommandHandler;

//★구현 흐름!
//GET 방식으로 요청이 오면 폼을 보여주는 뷰인 joinForm.jsp를 리턴
//POST 방식으로 요청이 오면 JoinRequest와 JoinService를 이용해 회원 가입을 처리하고 결과를 보여주는 뷰를 리턴
//그 결과가 1)입력데이터 오류면 다시 joinForm.jsp로 ㄱㄱ
//그 결과가 2)회원가입 된거면  우 joinSuccess.jsp로 ㄱㄱ

public class JoinHandler implements CommandHandler{
	public static final String FORM_VIEW = "/WEB-INF/view/joinForm.jsp";
	private JoinService joinService = new JoinService();
	//한개의 JoinService를 만들어놓고 계속 그 애를 쓰는게 메모리 관리에 더 좋다! -> 그래서 메소드 안에서 초기화 하지 않는거임~
	//★메소드 안에서 초기화하면 메소드 호출때마다 만드는데,
	//JoinHandler의 필드로 있으면 JoinHandler인스턴스가 1개인 이상, JoinService인스턴스도 1개~
	//JoinHandler도 한개 JoinService도 한개 MemberDao도 한개!! 요청이 여러개면 있던거 계속 덮어쓰면됨
	
	//★ControllerUsingURI에 의하여 process메소드가 실행됨~!
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) { //대소문자 구분없이 동일일경우
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		}
		return null; //null이면 405응답코드임
	}
	
	//get방식->로그인폼으로~
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}
	//post방식->등록여부조회 후 갈 길 가기~
	//한번 get방식으로 왔다가 제출눌러서 여기로 돌아온거니(post) param이 채워진 상태! 
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors); //참조를 연결시켜 놓는과정!
		//->★이 당시에 값이 없었어도 참조가 유지되는 한, 변화하는 값을 다 이용가능  
		
		joinReq.validate(errors); //여기서 errors map에 값 담음
		
		if (!errors.isEmpty()) { //에러가 존재하면 되돌아감
			return FORM_VIEW;
		}
		try {
			joinService.join(joinReq); //joinService에서, 중복아이디면 DuplicateIdException발생시킴
			return "/WEB-INF/view/joinSuccess.jsp";
		} catch(DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
