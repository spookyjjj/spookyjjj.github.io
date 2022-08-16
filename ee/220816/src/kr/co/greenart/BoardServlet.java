package kr.co.greenart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자가 겟방식의 요청을 하였습니다. (게시판목록)");

//		System.out.println("세션 값을 확인합니다.");
//		HttpSession session = req.getSession();
//		Object loginid = session.getAttribute("loginid");
//
//		if (loginid != null) {
//			System.out.println("로그인 확인되었습니다. 게시판 목록으로 forward합니다.");
//			List<String> articles = new ArrayList<>(Arrays.asList("글1", "글2", "글3"));
//			req.setAttribute("articles", articles);
//			req.getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
//		} else {
//			System.out.println("로그인 되지 않은 유저");
//			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401번임
//			// 얘는 코드만 설정하고 에러 페이지로 발송하지 않으니깐 forward도 필요
//			req.getRequestDispatcher("needlogin.jsp").forward(req, resp);
//			// 위에꺼가 싫으면 밑에껄로 간편하게 가능
//			// resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//		}
		
		//-> 전부 filter(LoginFilter)에서 처리하게 하고, 여기서는 게시판 처리만 하자~
		List<String> articles = new ArrayList<>(Arrays.asList("글1", "글2", "글3"));
		req.setAttribute("articles", articles);
		req.getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	}
}
