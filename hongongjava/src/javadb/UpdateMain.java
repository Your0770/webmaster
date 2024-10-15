package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.ResultSet;

public class UpdateMain {

	public static void main(String[] args) {
		// 연결하기
		Connection conn = null;
		
		try {
			// jdbc Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",	//url
					"java",									//계정
					"1234"									//비밀번호
					);
			System.out.println("Connect");
			
			//data update
			String sql = ""
						+ "update boards "
						+ "set btitle=?, bcontent=?, bwriter=? "
						+ "where bno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"btitle", "bcontent", "bwriter", "bno"});
			pstmt.setString(1, "바꾸자");
			pstmt.setString(2, "1번을 바꾸래요");
			pstmt.setString(3, "아무개");
			pstmt.setInt(4, 1);								// 몇번을 바꿀지 - bno
			
			int rows = pstmt.executeUpdate();
			System.out.println("수정된 개수 : " + rows);
			
			/*
			if(rows == 1) {
				ResultSet rset = pstmt.getGeneratedKeys();
				if(rset.next()) {
					String title = rset.getString(1);
					String content = rset.getString(2);
					String writer = rset.getString(3);
					int bno = rset.getInt(4);
					System.out.printf("수정된 번호 : %d\t수정된 제목 : %s\t수정된 내용 : %s\t수정된 작가: %s\n",bno, title, content, writer);
				}
				rset.close();
				
			}
			*/
			
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
