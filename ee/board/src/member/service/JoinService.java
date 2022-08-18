package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	private MemberDao memberDao = new MemberDao();
	
	public void join(JoinRequest joinReq) {
		Connection conn = null;
		try {
			//DB커넥션 구하고 트렌젝션을 시작함
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, joinReq.getId());
			//회원가입하려는 아이디로 db훑어봤을때 이미 있는 애면 (member != null)인거임 -> 중복에러처리ㄱㄱ
			if (member != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			//여기서 안걸러 졌으면 회원등록 과정 ㄱㄱ
			memberDao.insert(conn, new Member(joinReq.getId(), joinReq.getName(), joinReq.getPassword(), new Date()));
			//다 통과해야 커밋~
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeConn(conn);
		}
	}
}
