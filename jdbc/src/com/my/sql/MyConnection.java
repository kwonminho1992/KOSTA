package com.my.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	static { // JDBC 클래스 로드는 한번만 하면 더 이상 할 필요가 없으므로 MyConnection 클래스가 로드될 때 자동호출되도록 static 블럭에 넣음
		// 1. JDBC 드라이버 설치
		// -> ojdbc8.jar 다운로드
		// 2. JDBC 드라이버 클래스 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle driver 연결
			System.out.println("Driver와 연결하였습니다");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	//db에 connect하기
	public static Connection getConnection() throws SQLException {
		// 3. DB 연결
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		con = DriverManager.getConnection(url, user, password);
		System.out.println(url + "에 연결하였습니다");
		return con;
	}
	
	//db와의 연결 해제
	public static void close(ResultSet rs, Statement stat, Connection con) {
		// 7. DB 와의 연결 해제
		if (rs != null) {
			try {
				rs.close(); // ResultSet 닫기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stat != null) {
			try {
				stat.close(); // Statement 닫기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close(); // Connection 닫기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//db와의 연결 해제
	public static void close(Statement stat, Connection con) {
		// 7. DB 와의 연결 해제
		close(null, stat, con);
	}
}
