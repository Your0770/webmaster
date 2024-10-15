package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteMain {

	public static void main(String[] args) {
		// 연결
		Connection conn = null;
		//등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
					
			String sql = "" + 
						"delete " + 
						"from boards " + 
						"where bno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 7);
			int rows = pstmt.executeUpdate();
			System.out.println("삭제 행 개수 : " + rows);
			pstmt.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
