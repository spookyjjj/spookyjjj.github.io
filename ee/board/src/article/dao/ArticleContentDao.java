package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import article.model.Article;
import article.model.ArticleContent;
import jdbc.JdbcUtil;

public class ArticleContentDao {
	
	//게시글 작성시 DB에 넣는거
	//리턴이 ArticleContent이면 잘 들어간 것이고 null이면 안들어간 것 
	//-> 얘는 ArticleDao와 달리 신뢰도있는 number를 가진 ArticleContent를 파라미터로 받음 그러니깐 바로 db에 집어넣지ㅎㅎ
	//-> 애초에 article_content의 article_no는 오토인크리먼트가 아님~
	public ArticleContent insert(Connection conn, ArticleContent content) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("insert into article_content (article_no, content) values (?, ?)");
			pstmt.setLong(1, content.getNumber());
			pstmt.setString(2, content.getContent());
			int insertedCount = pstmt.executeUpdate();
			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}
		} finally {
			JdbcUtil.closeStmt(pstmt);
		}
	}
}
