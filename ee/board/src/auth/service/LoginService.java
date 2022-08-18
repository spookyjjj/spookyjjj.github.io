package auth.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;

//★구현목표
//dao를 이용해 db에 해당회원 데이터 비교 
//-> X면 LoginFailException ㄱㄱ
//-> O면 User객체 반환

public class LoginService {
	private MemberDao memberDao = new MemberDao();
	
	public User login(String id, String password) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			Member member = memberDao.selectById(conn, id);
			if (member == null) { //해당 회원이 db에 없음
				throw new LoginFailException();
			}
			if (!member.matchPassword(password)) { //db에 저장된 비번(member안의 필드)과 입력한 비번(password)불일치
				throw new LoginFailException();
			}
			return new User(member.getId(), member.getName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
