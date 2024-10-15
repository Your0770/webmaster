package 도서관리;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDao extends DAO{
	//field
	static String sql = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	//method
	
	//3. insert 메소드
	public void ins(String title, String writer, int price, String bnum){
		con();
		sql = "" + 
					"insert into books (title, writer, price, bnum) " + 
					"values (?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql, new String[] {"title", "writer", "price", "bnum"});
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setInt(3, price);
			pstmt.setString(4, bnum);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					String btitle = rs.getString(1);
					String bwriter = rs.getString(2);
					int bprice = rs.getInt(3);
					String bno = rs.getString(4);
					System.out.printf("%s : %s : %d : %s\n", btitle, bwriter, bprice, bno);
				}
				System.out.println("insert complete");
				rs.close();
			}else {
				System.out.println("insert failed");
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}
	
	//4. select : 조건에 따른 검색 (책 제목) 메소드
	public void sel(String title) {
		con();
		System.out.println("번호\t제목\t\t저자\t가격");
		sql = "" + 
			"select * from books " + 
			"where title = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book bk = new Book();
				bk.setTitle(rs.getString(1));
				bk.setWriter(rs.getString(2));
				bk.setPrice(rs.getInt(3));
				bk.setbNum(rs.getString(4));
				
				System.out.println(bk);
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}
	
	//5. select : 목록 전체 조회 메소드
	public void selAll() {
		con();
		System.out.println("번호\t제목\t\t저자\t가격");
		sql = "" + 
			"select * from books"; 
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book bk = new Book();
				bk.setTitle(rs.getString(1));
				bk.setWriter(rs.getString(2));
				bk.setPrice(rs.getInt(3));
				bk.setbNum(rs.getString(4));
				
				System.out.println(bk);
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}

	//6. delete 메소드(책 번호 이용)
	public void del(String bNum) {
		con();
		sql = "" + 
			"delete from books " + 
			"where bnum = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bNum);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				System.out.println("삭제 행 개수 : " + rows);
				System.out.println("삭제 한 책 번호 : " + bNum);
			} else {
				System.out.println("책 번호를 찾을수 없습니다.");
			}
			
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}

	//7. update 메소드( 책제목의 가격과 책번호 수정)
	public void upd(String title, String bNum, int price) {
		con();
		sql = "" + 
			"update books " + 
			"set bnum = ?, price = ? " + 
			"where title = ?";
		try {
			pstmt = conn.prepareStatement(sql, new String[] {"title", "price", "bnum"});
			pstmt.setString(1, bNum);
			pstmt.setInt(2, price);
			pstmt.setString(3, title);
			int rows = pstmt.executeUpdate();
			if(rows == 1) {
				System.out.println("수정된 개수 : " + rows);
				System.out.printf("수정된 책 : %s\t수정된 가격 : %d\t수정된 책 번호 : %s\n", title, price, bNum);
			}else { 
				System.out.println("책제목을 찾을수 없습니다.");
			}
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}
	
}
