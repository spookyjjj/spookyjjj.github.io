package mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
//이후의 CommandHandler구현체는 process메소드 안에서,
//1. 명령어와 관련된 비지니스 로직 처리
//2. 뷰 페이지에서 사용할 정보 저장 : req.setAttribute(키, 벨류)
//3. 뷰페이지 uri리턴 : return "경로주소"
