package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import article.model.Writer;
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
	
	//페이지 개수를 구하기 위한 젠체 개시글 수 구하기
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from article");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.closeRS(rs);
//			JdbcUtil.closeConn(conn); //일부러 없애줌~~
		}
	}
	
	//지정범위의 게시글을 읽어오기 위한 select메소드
	public List<Article> select(Connection conn, int startRow, int size) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from article order by article_no desc limit ?, ?");
			pstmt.setInt(1, startRow); //startIndex <- 0번부터 시작~!!!
			pstmt.setInt(2, size); //가져올 총 개수~!!
			rs = pstmt.executeQuery();
			List<Article> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertArticle(rs));
			}
			return result;
		} finally {
			JdbcUtil.closeRS(rs);
			JdbcUtil.closeConn(conn);
		}
	}

	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(rs.getInt("article_no"), new Writer(rs.getString("writer_id"), rs.getString("writer_name")), rs.getString("title"), toDate(rs.getTimestamp("regdate")), toDate(rs.getTimestamp("moddate")), rs.getInt("read_cnt"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	//선택한 no로 article 가져오기
	public Article selectById(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from article where article_no = ?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			Article article = null;
			if (rs.next()) {
				article = convertArticle(rs);
			}
			return article;
		} finally {
			JdbcUtil.closeRS(rs);
			JdbcUtil.closeStmt(pstmt);
		}
	}
	
	//조회수 올린거 db에 등록하는 메소드
	public void increaseReadCount(Connection conn, int no) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("update article set read_cnt = read_cnt + 1 where article_no = ?")) {
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}
	}
	
	//게시글 제목 수정한걸 db에 넣는 메소드
	public int update(Connection conn, int no, String title) throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement("update article set title = ?, moddate = now() where article_no = ?")) {
			pstmt.setString(1, title);
			pstmt.setInt(2, no);
			return pstmt.executeUpdate();
		}
	}
}
