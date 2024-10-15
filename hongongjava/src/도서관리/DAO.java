package 도서관리;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	//field
		Connection conn = null;
		PreparedStatement psmt;
		ResultSet rs;
		
	//method
	//1. 연결 설정 메소드
	public void con() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			try {
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe",
						"java",
						"1234"
						);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("connect");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//2. 연결 끊기 메소드
	public void discon() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("disconnect");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
