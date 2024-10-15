package 도서관리;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// 목록(조회 조건), 등록, 수정, 삭제, 단건 (CRUD)
public class MemberDao extends DAO{
	//field
	// Connection conn = null;
	//싱글톤 방식
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return instance;
	}
	
	
	
	//method
	//con();
	//discon();
	
	// 아이디와 비밀번호 확인해서 값이 있으면 true / 없으면 false 반환 -> 회원 이름 반환 -> 권한 추가
	Member checkMember(String id, String pw) {
		String sql = ""
				   + "select member_name, responsibility from tbl_member "
				   + "where member_id = ? and password = ?";
		con();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				Member member = new Member();
				member.setMemberName(rs.getString("member_name"));
				member.setResponsibility(rs.getString("responsibility"));
					return member;	// id, pw 정상적
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;		// 예외 발생시
	}
	
	
	
	
	// 목록 조회
	List<Member> memberList(){
		String sql = "select member_id, "
			       + "member_name, "
			       + "password, "
			       + "phone, "
			       + "responsibility, "
		           + "creation_date "
	               + "from tbl_member ";
//		쿼리문 작성 똑바로 쉼표나 띄어쓰기 재확인!!!!!
		List<Member> result = new ArrayList<>();
		con();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();	//조회  데이터 변경이 없을 경우 executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				member.setCreationDate(rs.getDate("creation_date"));
				
				result.add(member);
				
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
		
	} // end of memberList()
	
	//목록 추가
	int memIns(String mId, String pwd, String mName, String phone) {
		int rows = 0;
		String sql = ""
			       + "insert into tbl_member(member_id, password, member_name, phone) "
			       + "values (?, ?, ?, ? )";
		con();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mId);
			psmt.setString(2, pwd);
			psmt.setString(3, mName);
			psmt.setString(4, phone);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			discon();
		}
		return rows;
	} //memIns
	
	
	//목록 검색
	List<Member> sel(String mName) {
		String sql = ""
				   + "select * from tbl_member "
				   + "where member_name = ?";
		List<Member> result = new ArrayList<>();
		con();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mName);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.setMemberId(rs.getString("member_id"));
				mb.setPassword(rs.getString("password"));
				mb.setMemberName(rs.getString("member_name"));
				mb.setPhone(rs.getString("phone"));
				mb.setResponsibility(rs.getString("responsibility"));
				mb.setCreationDate(rs.getDate("creation_date"));
				
				result.add(mb);
				
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	} //sel();
	
	//목록 삭제
	int del(String mId) {
		String sql = ""
				   + "delete from tbl_member "
				   + "where member_id = ?";
		int rows = 0;
		con();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mId);
			rows = psmt.executeUpdate();
			psmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			discon();
		}
		return rows;
	} //del()
	
	//목록 수정
	int upd(String mId, String mName, String pwd, String phone, String mRes) {
		String sql = ""
				   + "update tbl_member "
				   + "set password = ?, member_name = ?, phone = ?, responsibility = ? "
				   + "where member_id = ? ";
		int rows = 0;
		con();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.setString(2, mName);
			psmt.setString(3, phone);
			psmt.setString(4, mRes);
			psmt.setString(5, mId);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			discon();
		}
		return rows;
	}//upd()
	
	
}
