package article.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.model.Writer;
import article.service.WriteArticleService;
import article.service.WriteRequest;
import auth.service.User;
import mvc.command.CommandHandler;

//★구현 흐름!
//GET 방식으로 요청이 오면 게시글작성폼을 보여주는 뷰인 newArticleForm.jsp를 리턴
//POST 방식으로 요청이 오면 WriteRequest와 writeService를 이용해 게시글작성로직 처리하고 결과를 보여주는 뷰를 리턴
//그 결과가 1)오류면 다시 newArticleForm.jsp로 ㄱㄱ
//그 결과가 2)작성된거면 newArticleSuccess.jsp로 ㄱㄱ

public class WriteArticleHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/newArticleForm.jsp";
	private WriteArticleService writeService = new WriteArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) { //대소문자 구분없이 동일일경우
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors); //참조를 연결시켜 놓는과정!
		//->★이 당시에 값이 없었어도 참조가 유지되는 한, 변화하는 값을 다 이용가능  
		
		User user = (User) req.getSession(false).getAttribute("authUser"); //로그인정보(user)가져옴
		WriteRequest writeReq = createWriteRequest(user, req); //user와 req를 이용해 writeRequest객체 생성
		writeReq.validate(errors); //title이 유효? 에러있으면 밑에서 걸러짐
		
		if (!errors.isEmpty()) { //에러가 존재하면 되돌아감
			return FORM_VIEW;
		}
		
		int newArticleNo = writeService.write(writeReq); //에러 없으면 게시글 등록하고 게시글 no 리턴받음
		req.setAttribute("newArticleNo", newArticleNo);
		
		return "/WEB-INF/view/newArticleSuccess.jsp";
	}

	private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
		return new WriteRequest (new Writer(user.getId(), user.getName()), req.getParameter("title"), req.getParameter("content"));
	}


}
