package himedia.myhome.dao;

import java.sql.*;


public abstract class BaseDao {
	private String dbUser = null;
	private String dbPass = null;

	public BaseDao(String dbUser, String dbPass) {
		this.dbUser = dbUser;
		this.dbPass = dbPass;
	}

	protected Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, dbUser, dbPass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
