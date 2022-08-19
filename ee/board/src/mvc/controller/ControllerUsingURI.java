package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingURI extends HttpServlet {
	
	//<커멘드, 핸들러인스턴스> 매핑 정보 저장
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	public void init()  throws ServletException {
		//web.xml에 가보면 servlet에 initParam으로 configFile가 있음
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		//우리 app에 관련된 모든것을 다 알고있는 ServletContext에게 
		//'configFile(경로임!! : /WEB-INF/commandHandlerURI.properties)'의
		//realpath가 뭐냐고 물어본다음 configFilePath로 담아 둠
		String configFilePath = getServletContext().getRealPath(configFile);
		try (FileReader fis = new FileReader(configFilePath)) {
			prop.load(fis);
		} catch (IOException e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				//★해당 클래스 내용을 클래스라는 객체에 투영(reflection)
				//-> 클래스라는 객체는 getMethod, getConstructor, getField 등등 가능
				//즉, 해당 클래스의 인스턴스를 만드는게 아니라 아예 그 클래스를 가져오는거라서 걔를 들여다 보는거, 수정하는거, 인스턴스만드는거 다 가능~!!
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getRequestURI();
		if (command.indexOf(req.getContextPath()) == 0) {
			command = command.substring(req.getContextPath().length());
		}
		CommandHandler handler = commandHandlerMap.get(command);
		if (handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		try {
			//★handler의 proess메소드를 여기서 실행시키고, 그 반환값으로 이동할 페이지경로를 String으로 받아옴
			viewPage = handler.process(req, resp);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		if (viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage); //여기서 흐름 이어줌~
			dispatcher.forward(req, resp);
		}
	}
}
