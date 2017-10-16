package com.ly.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	// 连接地址kingswim 为数据库
//	public final static String url = "jdbc:mysql://localhost:3306/kingswim?useUnicode=true&characterEncoding=utf-8&useSSL=false&rewriteBatchedStatements=true";
	public final static String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
	// 账号
	public final static String user = "sdj";
	// 密码
	public final static String password = "";
	// 驱动
	public final static String driver = "com.mysql.jdbc.Driver";

	static {
		try {
			// 加载驱动
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public static void release(Connection conn, Statement st, ResultSet rs) {

		if (rs != null) {
			try {
				rs.close();  
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			st = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn=null;
		}

	}

}
