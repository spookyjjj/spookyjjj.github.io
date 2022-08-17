package kr.co.greenart;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*",
	initParams = @WebInitParam(name = "encoding", value = "UTF-8"))
public class EncodingFilter implements Filter {
	
	private String encoding;
	//init파라미터는 구동될 때 한번 사용되는 애! 근데 여기서는 annotation으로 만들었으니 이 class읽을 때!
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//chain.doFilter()전에 써서 인코딩처리하고 나서 흐름에 넘겨줌
		//인코딩값 계속 쓸꺼니깐 init에 넣어놓고 씀(final 상수처럼)
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}
}
