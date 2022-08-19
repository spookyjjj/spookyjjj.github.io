package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticlePage;
import article.service.ListArticleService;
import mvc.command.CommandHandler;

public class ListArticleHandler implements CommandHandler {
	private ListArticleService listService = new ListArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1; //디폴트값은 1임 <- 처음접속했을때는 req에 pageNo값이 심어져 있지 않으니 1로 ㄱㄱ
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ArticlePage articlePage = listService.getArticlePage(pageNo); //ListArticleService에서 페이지 넘버로 list불러옴
		req.setAttribute("articlePage", articlePage); //그걸 listArticle페이지로 가기 전에 심어둠
		return "/WEB-INF/view/listArticle.jsp";
	}

}
