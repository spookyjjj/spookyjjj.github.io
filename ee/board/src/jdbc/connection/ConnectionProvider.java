package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	public static Connection getConnection() throws SQLException {
		//여기서 board는 web.xml에서 지정한 poolName값임! <- dbcp(connection pool)에서 찾으니깐
		return DriverManager.getConnection("jdbc:apache:commons:dbcp:board");
	}
}
