package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.my.sql.MyConnection;

public class TransactionTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstat = null; 
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false); // autocommit이 불가능하도록 설정
			String insertInfoSQL = 
					"INSERT INTO order_info(order_no, order_id, order_date)"
					+" VALUES     (order_seq.NEXTVAL,     ?,       SYSDATE)";
			String insertLineSQL = 
					"INSERT INTO order_line(order_no, order_product_no, order_quantity)"
					+" VALUES     (order_seq.CURRVAL,     ?,           ?)";
			pstat = con.prepareStatement(insertInfoSQL);
			pstat.setString(1, "id1");
			pstat.executeUpdate();
			System.out.println("1번째 구문 insert");
			pstat = con.prepareStatement(insertLineSQL);
			pstat.setString(1, "G0001");
			pstat.setInt(2, 10);
			pstat.executeUpdate();
			System.out.println("2번째 구문 insert");			
			pstat.setString(1, "G0001");
			pstat.setInt(2, 10);
			pstat.executeUpdate();	
			System.out.println("3번째 구문 insert");
			con.commit(); // commit하기(transaction완료)
			System.out.println("commit complete");
		} catch (SQLException e) {
			if(con != null) {
				try {
					con.rollback();// insert 중에 문제 발생시 rollback하기 (transaction 취소)
					System.out.println("rollback complete");
	 			} catch (SQLException e1) {
				}
			}
			e.printStackTrace();
		} finally {
			MyConnection.close(pstat, con);
		}
	}
}
