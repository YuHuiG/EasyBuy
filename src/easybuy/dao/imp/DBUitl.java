package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUitl {
	Connection conn = null;

	// ��ȡ���ݿ�����
	public Connection getConn() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=EasyBuy";
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//�������
		try {
			Class.forName(driver);
			//��ȡ���ݿ�����
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
