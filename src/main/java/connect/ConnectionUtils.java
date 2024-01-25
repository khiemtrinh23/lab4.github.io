package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://DESKTOP-43J87RU:1433;databaseName=Lab04JspSevrletJDBC;encrypt=false";
		String user = "sa";
		String password = "khiemkhi2003";

//        // Đảm bảo driver được nạp vào bộ nhớ
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public static void  closeQuietly(Connection conn){
		try {
			conn.close();
		}catch (Exception e){

		}
	}
	public static void  rollbackQuietly(Connection conn){
		try {
			conn.rollback();
		}catch (Exception e){

		}
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException  {

		System.out.println("Get connection ... ");
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = getMSSQLConnection();
		System.out.println("Get connection " + conn);
		System.out.println("Done!");
	}
}
