package db;

import java.sql.*;

public class DB {
	public static Connection condb() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PW);
		return conn;
	}
}
