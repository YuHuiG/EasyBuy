package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUitl {
	Connection conn = null;

	// 获取数据库联接
	public Connection getConn() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=EasyBuy";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//反射机制
		try {
			Class.forName(driver);
			//获取数据库连接
			conn=DriverManager.getConnection(url, "sa", "123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}
	public void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
