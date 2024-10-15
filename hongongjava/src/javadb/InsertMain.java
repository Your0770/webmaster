package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class InsertMain {

	public static void main(String[] args) {
		// data 추가
		Connection conn = null;
		// jdbc Driver 등록
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"java",
					"1234"
					); 
			System.out.println("connect complete");
			
			// data 추가 작업
			String sql = ""
						+ "insert into boards (bno, btitle, bcontent, bwriter, bdate) " //마지막에 공백 생성 공백없으면 쿼리문 오류
					    + "values (?, ?, ?, ?, SYSDATE)";
//						+ "values (seq_bno.nextVal, ?, ?, ?, SYSDATE)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});
																						// 무엇을 넣었는지 알고 싶을때 배열을 생성해서
																						// rs를 생성
			pstmt.setInt(1, 9);
			pstmt.setString(2, "제목10");
			pstmt.setString(3, "내용10");
			pstmt.setString(4, "작가10");
			
//			pstmt.setString(1, "제목7");
//			pstmt.setString(2, "내용7");
//			pstmt.setString(3, "작가7");
															//select - execute() (boolean)
			int rows = pstmt.executeUpdate();				//insert,delete,update  - executeUpdate() (int)
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);					// 1 : 컬럼 번호
					System.out.println("저장된 번호 : " + bno);
					String title = rs.getString(2);
					System.out.println("저장된 제목 : " + title);
				}
				System.out.println("insert complete");
				rs.close();
			}else {
				System.out.println("insert failed");
			}
			pstmt.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("중복된 값은 넣을수 없습니다.");
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
