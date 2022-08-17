package jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
   public static void closeConn(Connection conn) {
      if (conn != null) {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   public static void closeStmt(Statement stmt) {
      if (stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   public static void closeRS(ResultSet rs) {
      if (rs != null) {
         try {
            rs.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
   
   public static void rollback(Connection conn) {
      if (conn != null) {
         try {
            conn.rollback();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}
