package kr.co.greenart;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// mysql.properties파일을 읽어올거임
// mysql.properties 안에는 딱 내용 만 있어야 하고 공란이 입력되어도 에러남
public class DBUtil {
	private final static Properties properties = new Properties();
	// Properties의 load메소드-> 파라미터로 properties형태의파일(Key,Property)을 건네주면 그 파일을 읽어서(by InputStream) 객체화 함

	//static블럭은 DBUtil을 젤 처음 쓰려고 부를 때 딱 한번 실행 됨
	static {
		InputStream inStream = null;

		try {
			inStream = DBUtil.class.getClassLoader().getResourceAsStream("mysql.properties");
			properties.load(inStream); //Properties는 InputStream을 잘 받아 먹는다!
			// mysql.properties파일 안의 JDBC_DRIVER_CLASS=옆의 값을 읽어서 String으로 만들고
			String driverClass = properties.getProperty("JDBC_DRIVER_CLASS"); 
			// 그걸 이용해서 드라이버 로드(적재)
			Class.forName(driverClass);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = properties.getProperty("JDBC_URL");
		String id = properties.getProperty("JDBC_USERNAME");
		String password = properties.getProperty("JDBC_PASSWORD");

		return DriverManager.getConnection(url, id, password);
	}

	public static void closeConn(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStmt(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeRs(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
