package person;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/fileupload")
@MultipartConfig(location = "d:\\temp", fileSizeThreshold = 10 * 1024 * 1024, maxFileSize = 50 * 1024 *1024)
//size를 넘어가면 위치에 저장하겠다(at disc). 이 용량보다 작으면 파일형태가 아니라 메모리 상에서 다 처리하겠다
//뒤에꺼는 최대용량
public class FileServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part p = req.getPart("upload"); 
		//이진데이터는 getParam이 아니라 getPart로 가져옴
		System.out.println(p.getName()); //upload
		System.out.println(p.getSubmittedFileName()); //올린파일이름 08.jpg
		for (String header : p.getHeaderNames()) {
			System.out.println(header + " : " + p.getHeader(header));
			//content-disposition : form-data; name="upload"; filename="08.jpg"
			//content-type : image/jpeg
		}
		
		String contextPath = getServletContext().getRealPath("");
		System.out.println(contextPath); //여기가면 파일 있을거임
		Path directory = Paths.get(contextPath);
		Files.copy(p.getInputStream(), directory.resolve(p.getSubmittedFileName()), StandardCopyOption.REPLACE_EXISTING);
	
//		resp.sendRedirect("/" + p.getSubmittedFileName());
		//파일이름이 한글이면 인코딩필요함 ->
		resp.sendRedirect("/" + URLEncoder.encode(p.getSubmittedFileName(), "UTF-8"));
	}
	
}
