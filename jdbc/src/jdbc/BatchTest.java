package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.my.sql.MyConnection;

//일괄처리
public class BatchTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstat = null;
		
		try {
			String insertSQL = "INSERT INTO a_tble (a) VALUES (?)";
			con = MyConnection.getConnection();
			pstat = con.prepareStatement(insertSQL);
			
//			for (int i = 101; i <= 200; i++) {
//				pstat.setInt(1,  i);
//				pstat.executeLargeUpdate();
//			}
//			pstat.clearBatch();
			for (int i = 101; i <= 200; i++) {
				pstat.setInt(1,  i);
				pstat.addBatch(); // 작업중인 데이터들을 buffer에 쌓아두기
			}
			System.out.println("일괄처리 완료직전");
			pstat.executeBatch();
			System.out.println("일괄처리 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(pstat, con);
		}
	}
}
