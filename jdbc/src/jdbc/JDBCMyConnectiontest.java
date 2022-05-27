package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.my.sql.MyConnection;

public class JDBCMyConnectiontest {
	public static void search() { // DB에서 자료 검색하기
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null; // ResultSet의 뜻 : 쿼리 실행 시 출력되는 행,열
		try {
			con = MyConnection.getConnection();
			// 4. SQL문 송신 (SELECT, INSERT/UPDATE/DELETE, CREATE/ALTER/DROP)
			stat = con.createStatement();
			// (executeQuery(), executeUpdate())
			String selectSQL = "SELECT employee_id, first_name, salary, hire_date FROM employees"; // 송신할때는 sql구문 끝에 ;를
																									// 붙이면 안됨
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			// 5. 결과 수신 (행(ResultSet), 처리건수(int), 0 )
			rs = stat.executeQuery(selectSQL); // DB에서 검색
			// ex) ResultSet rs = stat.executeQuery("SELECT ~~~"); // 행이 반환됨
			// int rowcnt = stat.executeQuery("INSERT ~~~"); // 처리건수가 반환됨
			// int rowcnt = stat.executeQuery("CREATE ~~~"); // 무조건 0이 반환됨

			// 6. 결과 출력
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id"); // employee_id column의 행 출력, getInt(1)도 가능
				String first_name = rs.getString("first_name"); // first_name column의 행 출력, getString(2)도 가능
				int salary = rs.getInt("salary"); // salary column의 행 출력, getInt(3)도 가능
				java.sql.Date hire_date = rs.getDate("hire_date"); // salary column의 행 출력, getDate(4)도 가능
				System.out.println(employee_id + ", " + first_name + ", " + salary + ", " + sdf.format(hire_date));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7. DB 와의 연결 해제
			MyConnection.close(rs, stat, con);
		}
	}
	
	public static void add() { // DB에 자료 입력하기 (INSERT)
		Connection con = null;
		Statement stat = null;
		try {
			con = MyConnection.getConnection();
			// 4. SQL문 송신 (SELECT, INSERT/UPDATE/DELETE, CREATE/ALTER/DROP)
			stat = con.createStatement();
			// (executeQuery(), executeUpdate())
			String insertSQL = "INSERT INTO customer(id, password, name, address, status) \r\n"
					+ "VALUES ('id7', 'p8', 'n8', 'a8', 1)"; // 송신할때는 sql구문 끝에 ;를 붙이면 안됨
			// 5. 결과 수신 (행(ResultSet), 처리건수(int), 0 )
			int rowcnt = stat.executeUpdate(insertSQL); // 행의 갯수
			System.out.println(rowcnt + "건이 추가 되었습니다.");
			// 6. 결과 출력
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 7. DB 와의 연결 해제
			MyConnection.close(stat, con);
		}
	}
}

