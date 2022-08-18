package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import article.model.Article;
import jdbc.JdbcUtil;

public class ArticleDao {
	
	//게시글 작성시 DB에 넣는거
	//리턴이 article(number필드 제대로 된놈)이면 잘 들어간 것이고 null이면 안들어간 것
	public Article insert(Connection conn, Article article) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//파라미터로 받아온 article의 number필드는 중요하지 않다! DB에 넣고나서, 번호표 발급받은걸 article number에 넣어주면 됨
			pstmt = conn.prepareStatement("insert into article (writer_id, writer_name, title, regdate, moddate, read_cnt) values (?, ?, ?, ?, ?, 0)");
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
			pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				//★last_insert_id() 테이블의 마지막 auto_increment를 반환한다 <- 원래 있는 함수
				rs = stmt.executeQuery("select last_insert_id() from article");
				if (rs.next() ) {
					Integer newNum = rs.getInt(1);
					//이게 db를 통해 자동 할당받은 번호~ 이걸로 article number 세팅해주면 됨ㅎㅎ
					return new Article(newNum, article.getWriter(), article.getTitle(), article.getRegDate(), article.getModifiedDate(), 0);
				}
			} return null;
		} finally {
			JdbcUtil.closeRS(rs);
			JdbcUtil.closeStmt(stmt);
			JdbcUtil.closeStmt(pstmt);
		}
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}
}
