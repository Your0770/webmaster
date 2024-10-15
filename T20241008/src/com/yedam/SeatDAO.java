package com.yedam;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO extends DAO {
	
	int finalNum() {
		int result = 0;
		String sql = ""
				+ "select seat_num from seats ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
		
	}//finalNum()
	
	List<Seats> selectSeat() {
		List<Seats> result = new ArrayList<>();
		sql = ""
			+ "select * from seats "
			+ "order by seat_num ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Seats seat = new Seats();
				seat.seatNum = rs.getInt(1);
				seat.rentMember = rs.getString(2);
				seat.rentDate = rs.getString(3);
				seat.returnDate = rs.getString(4);
				result.add(seat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return result;
		
	}
	
	void layOut(int[] layoutX) {
		System.out.println("==================좌석===================");
		for(int i = 1; i <= finalNum(); i++) {
			int seatNo = i;
			String seatString = Integer.toString(seatNo);
			for(int j = 0; j < layoutX.length; j++) {
				if(seatNo == layoutX[j]) seatString = "X";
			}
			System.out.printf("%2s  ", seatString);
			if(seatNo%10 == 0)System.out.println();
			
		}
		System.out.println();
		System.out.println("==================좌석===================");
	}

	public int seatLoan(int seatNum, Member login) {
		int rows = 0;
		sql = ""
			+ "update seats "
			+ "set rent_member = ?, rent_date = sysdate, "
			+ "return_date = sysdate +3/24 "
			+ "where seat_num = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, login.memberId);
			psmt.setInt(2, seatNum);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//seatLoan()
	
	int[] seatNotNull(){
		int[] result = new int[finalNum()];
		sql = ""
			+ "select seat_num from seats "
			+ "where rent_member is not null ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				result[i] = rs.getInt(1);
				i++;
			}
			rs.close();
			psmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		
		return null;
	}//seatNotNull()

	public int seatReturn(Member login) {
		int rows = 0;
		sql = ""
	 		+ "update seats "
	 		+ "set rent_member = null, rent_date = null, return_date = null "
	 		+ "where rent_member = ? ";
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
	}//seatReturn()

	public int insertSeat() {
		int rows = 0;
		sql = ""
			+ "insert into seats(seat_num) "
			+ "values (seat_no.nextval) ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		
		return rows;
	}//insertSeat()

	public int updateSeat(int beforeNo, int afterNo) {
		int rows = 0;
		sql = ""
			+ "update seats "
			+ "set seat_num = ? "
			+ "where seat_num = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, afterNo);
			psmt.setInt(2, beforeNo);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println(afterNo + "번 좌석이 이미 있습니다.");
			System.out.println("다른 번호로 변경해주세요.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		
		return rows;
	}//updateSeat()

	public int deleteSeat(int delNo) {
		int rows = 0;
		sql = ""
			+ "delete from seats "
			+ "where seat_num = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, delNo);
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

	public Seats searchSeat(int seatNum) {
		Seats result = new Seats();
		sql = ""
			+ "select seat_num, rent_member, rent_date, return_date "
			+ "from seats "
			+ "where seat_num = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seatNum);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result.seatNum = rs.getInt(1);
				result.rentMember = rs.getString(2);
				result.rentDate = rs.getString(3);
				result.returnDate = rs.getString(4);
			}
			rs.close();
			psmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;
	}
	
	
	
}
