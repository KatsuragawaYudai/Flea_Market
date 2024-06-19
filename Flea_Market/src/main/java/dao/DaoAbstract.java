package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoAbstract {
	private static final String RDB_DRIVE = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost/fleamarket_db";
	private static final String USER = "root";
	private static final String PASSWD = "root123";
	// ドライバの読み込み
	static {
		try {
			Class.forName(RDB_DRIVE);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException();
		}
	}
	
	protected static Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (SQLException e) {
			throw new IllegalStateException();
		}
	}
}
