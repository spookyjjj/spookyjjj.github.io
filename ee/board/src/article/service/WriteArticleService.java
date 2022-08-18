package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.management.RuntimeErrorException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class WriteArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();
	
	//WriteRequest와 dao를 이용해서 DB에 넣는데.. 트렌잭션도 걸고.. 성공하면 게시글 번호를 리턴할거임
	public Integer write(WriteRequest req) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			//WriteRequest에는 글쓴이와 제목만 있는데, toArticle()메소드를 거쳐서 등록시간 등도 넣어놓은 찐 Article로 바꿈
			Article article = toArticle(req);
			//articleDao에서 성공했으면 고대로 article을 반환(number도 제대로 됨!), 안됐으면 null반환
			Article savedArticle = articleDao.insert(conn, article);
			if (savedArticle == null) {
				throw new RuntimeException("fail to insert article");
			}
			
			//savedArticle에서 제대로된 number받아온 대로 ArticleContent number도 채워넣음
			ArticleContent content = new ArticleContent(savedArticle.getNumber(), req.getContent());
			//contentDao에서 성공했으면 고대로 ArticleContent을 반환, 안됐으면 null반환
			ArticleContent savedContent = contentDao.insert(conn, content);
			if (savedContent == null) {
				throw new RuntimeException("fail to insert article_content");
			}
			
			conn.commit();
			
			//성공하면 게시글 번호를 리턴할거임
			return savedArticle.getNumber();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.closeConn(conn);
		}
	}

	private Article toArticle(WriteRequest req) {
		Date now = new Date();
		return new Article(null, req.getWriter(), req.getTitle(), now, now, 0);
	}
}
