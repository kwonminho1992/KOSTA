package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.my.sql.MyConnection;

public class PreparedStatementTest {

	public static void main(String[] args) {
		Connection con = null;
		//Statement stat = null;
		PreparedStatement pstat = null;
		//Statement 와 PreparedStatement의 차이 : 
		//Statement - 한번 송신할때마다 쿼리문 자체를 보냄
		//PreparedStatement - 쿼리문 자체를 한번 송신 한 뒤, 바인드변수들을 송신함 (송신횟수가 많아지지만, 송신 내용이 줄어듦) 
		Scanner scanner = new Scanner(System.in);
		try {
			con = MyConnection.getConnection();
			//stat = con.createStatement();
			String insertSQL = "INSERT INTO customer(id, password, name, status) "
					         + "VALUES (?, ?, ?, ?)"; // ?(바인드변수)는 값에 해당하는 부분만 사용가능
			pstat = con.prepareStatement(insertSQL); // ?에 값을 대입할 수 있음
			System.out.println("추가할 ID를 입력하세요");
			String id = scanner.nextLine();
			System.out.println("추가할 password를 입력하세요");
			String password = scanner.nextLine();
			System.out.println("추가할 이름을 입력하세요");
			String name = scanner.nextLine();
			System.out.println("일반고객이면 1, 기업고객이면 2를 입력하세요");
			int status = scanner.nextInt();			
			//insertSQL = "INSERT INTO customer(id, password, name) "
			//				 + "VALUES ('" + id + "', '" + password + "', '" + name + "')";
			//stat.executeUpdate(insertSQL);
			pstat.setString(1, id); // 첫번쨰 ? 에 id 입력
			pstat.setString(2, password); // 두번째 ?에 password 입력
			pstat.setString(3, name); // 세번째 ?에 name 입력
			pstat.setInt(4, status); // 네번째 ?에 status 입력			
			pstat.executeUpdate();
			System.out.println("추가완료");
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		} finally {
			MyConnection.close(pstat, con);
		}
	}
}
