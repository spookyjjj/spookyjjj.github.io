package hello;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//★한글 깨짐이 있을 수 있다 -> 대비하기
		req.setCharacterEncoding("UTF-8");
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		
		//★입력값이 유효한지 확인하는 절차 필요~!!
		//모든 값은 필수! not null
		//이름: 10자 , 성: 10자, 나이: 정수, 이메일: 고유 50자
		PersonValidator validator = new PersonValidator();
		Map<String, String> errors = new HashMap<>();
		//validator.isValidName(firstname)자체가 map<String,String>
		//이걸 putAll로 넣으면 개별 각각의 짝을 하나 하나 put해준다고 think
		errors.putAll(validator.isValidName(firstname));
		errors.putAll(validator.isValidName(lastname));
		errors.putAll(validator.isValidAge(age));
		errors.putAll(validator.isValidEmail(email));
		
		//그러면 잘못된 값일 때 사용자에게 뭐라고 해야하는지???
		if (errors.size() > 0) {
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("/add.jsp").forward(req, resp);
		} else {
			Persons p = new Persons(firstname, lastname, Integer.valueOf(age), email);
			try {
				new PersonsDAO().addPersons(p);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			resp.sendRedirect("./showServlet");
		}
		
	}
}
