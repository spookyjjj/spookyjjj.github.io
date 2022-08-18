package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(false); //get을 하지만 만들어서 가져오지는 말란소리..있는애는 가져오고
		if (session != null) {
			session.invalidate();
		}
		resp.sendRedirect(req.getContextPath() + "/index.jsp"); 
		//sendRedirect는 여기서 바로 동작이 일어나는게 아님!
		//걍 response의 주소값만 설정해 줄 뿐.. 메소드 마무리 다 되고 실제로 이동 일어남 
		return null;
	}

}
