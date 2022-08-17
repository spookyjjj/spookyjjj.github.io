package kr.co.greenart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class MyContextListener implements ServletContextListener {
//	private static String dburl;
//	private static String dbpw;
//	private static String dbid;
	//connection pool 사용을 위해 다시 지역변수로 되돌림
	private static DataSource dataSource;
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("웹 어플리케이션 시작 시 이벤트가 발생합니다.");
		
		//웹 어플리케이션 첫 구동 시 필요한 설정을 할 수 있음.
		ServletContext context = sce.getServletContext();
		//context.get어쩌구
		//context.add저쩌구
		
		String driver = context.getInitParameter("driver");
//		System.out.println("설정값 확인: " + driver);
		String dburl = context.getInitParameter("dburl");
		String dbid = context.getInitParameter("dbid");
		String dbpw = context.getInitParameter("dbpw");
		
//		try {
//			Class.forName(driver); //드라이버 매니저에 자기자신을 등록
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		//connection pool 사용을 위해 주석처리
		
		//DataSource인터페이스의 구현체 BasicDataSource <-get, set만 있다!
		BasicDataSource ds = new BasicDataSource(); //tomcat이 아니라 commons붙은걸로 임포트
		ds.setDriverClassName(driver);
		ds.setUrl(dburl);
		ds.setUsername(dbid);
		ds.setPassword(dbpw);
		
		dataSource = ds;
	}
	
	public static Connection getConnection() throws SQLException {
//		return DriverManager.getConnection(dburl, dbid, dbpw);
		//connection pool 사용을 위해 주석처리
		
		return dataSource.getConnection();
	}
}
