package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.connection.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;
	
	public ArticlePage getArticlePage(int pageNum) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			//★articleDao를 두번쓴다..위에서 conn쓰고서 finall에서 닫아버리면 밑에서는 conn을 못찾음~!
			//conn관리 잘 해주기~!!
			int total = articleDao.selectCount(conn); //전체 게시글 수 구해오기
			List<Article> content = articleDao.select(conn, (pageNum - 1) * size, size);
			//limit(시작번호, 볼 개수) -> 즉, 3페이지를 요청하면  (3-1)*10인 20을 시작 행 번호로 사용
			return new ArticlePage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
