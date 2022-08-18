package article.service;

import java.util.Map;

import article.model.Writer;

//게시글 쓰기에 필요한 데이터를 제공한다
public class WriteRequest {
	private Writer writer;
	private String title;
	private String content;
	
	public WriteRequest(Writer writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) { //요청값을 넘겨받았는데 제목이 비어있으면 에러 추가
			errors.put("title", Boolean.TRUE);
		}
	}
}
