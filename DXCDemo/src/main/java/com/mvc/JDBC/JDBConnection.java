package com.mvc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection {
	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/dxcdemo";
		String DBuser = "root";
		String DBpw = "mysql";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, DBuser, DBpw);
			System.out.println("Connecting to MySQL DB " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
