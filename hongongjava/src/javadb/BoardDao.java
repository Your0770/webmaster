package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDao {
	
	public static void main(String[] args) {
		Connection conn = null;
		
		// jdbc 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					);
			System.out.println("connect");
			
			String sql = "" + 
						"select * from boards";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board bd = new Board();
				bd.setBno(rs.getInt(1));
				bd.setBtitle(rs.getString(2));
				bd.setBcontent(rs.getString(3));
				bd.setBwriter(rs.getString(4));
				bd.setBdate(rs.getDate(5));
				System.out.println(bd);
			}
			rs.close();
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	
}
			