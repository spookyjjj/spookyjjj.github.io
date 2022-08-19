package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	//게시글 조회눌렀을때 db에서 가져오는 메소드
	public ArticleContent selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from article_content where article_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			ArticleContent content = null;
			if (rs.next()) {
				content = new ArticleContent(rs.getInt("article_no"), rs.getString("content"));
			}
			return content;
		} finally {
				JdbcUtil.closeRS(rs);
				JdbcUtil.closeStmt(pstmt);
		}
	}
	
	//수정한 내용으로 db에 집어넣는 메소드
	public int update(Connection conn, int no, String content) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("update article_content set content = ? where article_no = ?")) {
			pstmt.setString(1, content);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
}
	
	