package hello;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.DBUtil;

public class PersonsDAO {
	//사람 추가하기
	public int addPersons(Persons person) throws SQLException {
		String query = "insert into persons (firstname, lastname, age, email) values (?, ?, ?, ?)";
		try (Connection conn = DBUtil.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, person.getFirstname());
			pstmt.setString(2, person.getLastname());
			pstmt.setInt(3, person.getAge());
			pstmt.setString(4, person.getEmail());
			
			return pstmt.executeUpdate();
		}
	}
	//사람 목록보기
	public List<Persons> showPersons() throws SQLException {
		String query = "select * from persons";
		List<Persons> personsList = new ArrayList<>();
		try (Connection conn = DBUtil.getConnection()){
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				personsList.add(new Persons(firstname, lastname, age, email));
			}
		} 
		return personsList;
	}
}
