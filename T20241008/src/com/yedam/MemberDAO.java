package com.yedam;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO extends DAO {
	
	Member login(String mId, String pwd) {
		sql = ""
			+ "select member_id, password, member_name, birthday, phone, permission, create_date, "
			+ "book_num, book_name, rent_date, return_date , seat_num "
			+ "from member "
			+ "where member_id = ? and password = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mId);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			if(rs.next()) {
				Member result = new Member();
				result.setMemberId(rs.getString("member_id"));
				result.setPassword(rs.getString("password"));
				result.setMemberName(rs.getString("member_name"));
				result.setBirthday(rs.getString("birthday"));
				result.setPhone(rs.getString("phone"));
				result.setPermission(rs.getString("permission"));
				result.setCreDate(rs.getString("create_date"));
				result.setBookNum(rs.getString("book_num"));
				result.setBookName(rs.getString("book_name"));
				result.setRentDate(rs.getString("rent_date"));
				result.setReturnDate(rs.getString("return_date"));
				result.setSeatNum(rs.getInt("seat_num"));
				return result;
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return null;
	}//Member login()

	public int insMem(String mId, String pwd, String name, String birth, String phone) {
		rows = 0;
		sql = ""
			+ "insert into member (member_id, password, member_name, birthday, phone) "
			+ "values (?, ?, ?, ?, ?)";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mId);
			psmt.setString(2, pwd);
			psmt.setString(3, name);
			psmt.setString(4, birth);
			psmt.setString(5, phone);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("중복된 아이디가 있습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//int insMem()

	public String findId(String name, String birth, String phone) {
		String result = null;
		sql = ""
			+ "select member_id from member "
			+ "where member_name = ? and to_char(birthday, 'yyyy-mm-dd') = ? and phone = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, birth);
			psmt.setString(3, phone);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("member_id");
				return result;
			}
			rs.close();
			psmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		
		return null;
	}//String findId()

	public String findPw(String mId, String name, String birth, String phone) {
		String result = null;
		sql = ""
			+ "select password from member "
			+ "where member_id = ? and member_name = ? "
			+ "and to_char(birthday, 'yyyy-mm-dd') = ? and phone = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mId);
			psmt.setString(2, name);
			psmt.setString(3, birth);
			psmt.setString(4, phone);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("password");
				return result;
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return null;
	}//String findPw()
	
	public int renewMember(Book book, Member login) {
		rows = 0;
		sql = ""
			+ "update member "
			+ "set (book_num, book_name, rent_date, return_date) = "
			+ "(select book_num, book_name, rent_date, return_date "
			+ "from book "
			+ "where book_num = ? ) "
			+ "where member_id = ?";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.bookNum);
			psmt.setString(2, login.memberName);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//rentMember()
	
	public int returnMember(Book book, Member login) {
		rows = 0;
		sql = ""
			+ "update member "
			+ "set book_num = null, book_name = null, rent_date = null, return_date= null "
			+ "where member_id = ?";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, login.memberName);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//rentMember()

	public int updateMember(String mId, String pwd, String name, String birth, String phone) {
		rows = 0;
		sql = ""
			+ "update member "
			+ "set password = ?, member_name = ?, birthday = ?, phone = ? "
			+ "where member_id = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pwd);
			psmt.setString(2, name);
			psmt.setString(3, birth);
			psmt.setString(4, phone);
			psmt.setString(5, mId);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//updateMember()

	public int deleteMember(String mId) {
		rows = 0;
		sql = ""
		    + "delete from member "
		    + "where member_id = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mId);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}//deleteMember()

	public List<Member> memberListName() {
		List<Member> result = new ArrayList<>();
		sql = ""
			+ "select * from member "
			+ "order by member_name ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.memberId = rs.getString(1);
				mb.password = rs.getString(2);
				mb.memberName = rs.getString(3);
				mb.birthday = rs.getString(4);
				mb.phone = rs.getString(5);
				mb.permission = rs.getString(6);
				mb.creDate = rs.getString(7);
				mb.bookNum = rs.getString(8);
				mb.bookName = rs.getString(9);
				mb.rentDate = rs.getString(10);
				mb.returnDate = rs.getString(11);
				mb.seatNum = rs.getInt(12);
				result.add(mb);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}//memberListName

	public List<Member> memberListTime() {
		List<Member> result = new ArrayList<>();
		sql = ""
			+ "select * from member "
			+ "order by create_date ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.memberId = rs.getString(1);
				mb.password = rs.getString(2);
				mb.memberName = rs.getString(3);
				mb.birthday = rs.getString(4);
				mb.phone = rs.getString(5);
				mb.permission = rs.getString(6);
				mb.creDate = rs.getString(7);
				mb.bookNum = rs.getString(8);
				mb.bookName = rs.getString(9);
				mb.rentDate = rs.getString(10);
				mb.returnDate = rs.getString(11);
				result.add(mb);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}//memberListTime()

	public List<Member> memberSearchName(String name) {
		List<Member> result = new ArrayList<>();
		sql = ""
			+ "select * from member "
			+ "where member_name = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.memberId = rs.getString(1);
				mb.password = rs.getString(2);
				mb.memberName = rs.getString(3);
				mb.birthday = rs.getString(4);
				mb.phone = rs.getString(5);
				mb.permission = rs.getString(6);
				mb.creDate = rs.getString(7);
				mb.bookNum = rs.getString(8);
				mb.bookName = rs.getString(9);
				mb.rentDate = rs.getString(10);
				mb.returnDate = rs.getString(11);
				result.add(mb);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}//memberSearchName()

	public List<Member> memberSearchId(String mId) {
		List<Member> result = new ArrayList<>();
		sql = ""
			+ "select * from member "
			+ "where member_id = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mId);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Member mb = new Member();
				mb.memberId = rs.getString(1);
				mb.password = rs.getString(2);
				mb.memberName = rs.getString(3);
				mb.birthday = rs.getString(4);
				mb.phone = rs.getString(5);
				mb.permission = rs.getString(6);
				mb.creDate = rs.getString(7);
				mb.bookNum = rs.getString(8);
				mb.bookName = rs.getString(9);
				mb.rentDate = rs.getString(10);
				mb.returnDate = rs.getString(11);
				result.add(mb);
			}
			rs.close();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
	}//memberSearchId()

	public int memberSeatLoan(int seatNum, Member login) {
		int rows = 0;
		sql = ""
			+ "update member "
			+ "set seat_num = ? "
			+ "where member_id = ?";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seatNum);
			psmt.setString(2, login.memberId);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//memberSeatLoan()

	public int memberSeatReturn(Member login) {
		int rows = 0;
		sql = ""
			+ "update member "
			+ "set seat_num = 0 "
			+ "where member_id = ?";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, login.memberId);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}
	
	
	
}
