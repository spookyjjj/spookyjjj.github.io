package kr.co.greenart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WorldServlet extends HttpServlet {
	private int some = 10;
	
	public WorldServlet() {
		super();
		System.out.println("월드 서블릿 생성자는 언제 호출되나요?");
		//★처음 접속할 때 한번 만들어지고, 계속 그걸 사용한다~
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//service(ServletRequest arg0, ServletResponse arg1) 를 오버라이드 해도 되지만, 어차피 http로 다운캐스팅 해서 써야하기때문에 애초에 http로 받는게 좋음~
		
		PrintWriter pw = resp.getWriter(); //out객체를 알려줌(PrintWriter꼴)
		pw.println("World Servlet"); //즉, pw가 out임
		pw.flush();
		some++;
		System.out.println("필드값: " + some);
		//★새로고침 할 때 마다 요청이 반복되므로 계속 service메소드가 호출되고, 필드값은 계속 증가~!
		
		//요청 주소에 요청 흐름 제어
//		req.setAttribute("title", "서블릿에서 설정한 제목");
//		req.setAttribute("message", "서블릿에서 설정한 메시지");
//		req.getRequestDispatcher("messageoutput.jsp").forward(req, resp);
		
		//country껄로 실습해보기
//		String continent = req.getParameter("continent");
//		CountryDAO dao = new CountryDAO();
//		List<Country> list = null;
//		try {
//			list = dao.getCountryByContinent("asia"); //<-param으로 넘겨받은거 없으니 임의로 설정해줌
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		req.setAttribute("continent", continent);
//		req.setAttribute("countryList", list);
//		
//		req.getRequestDispatcher("result2.jsp").forward(req, resp);
	}
	

}
