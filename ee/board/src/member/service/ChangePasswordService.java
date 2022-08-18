package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

//Dao이용해서 트렌젝션도 걸고 다라는게 Service클래스

public class ChangePasswordService {
	private MemberDao memberDao = new MemberDao();
	
	//암호변경기능
	public void changePassword(String userId, String curPwd, String newPwd) {
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, userId);
			if (member == null) { //아이디에 맞는 회원을 못찾는경우 <- 이게 가능?? 의문임
				throw new MemberNotFoundException();
			}
			if (!member.matchPassword(curPwd)) { //현재아이디 잘못친경우
				throw new InvalidPasswordException();
			}
			//위와같은 예외가 아니면 암호 변경해줌
			member.changePassword(newPwd);
			memberDao.update(conn, member); //DB에 반영
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeConn(conn);
		}
	}
}
