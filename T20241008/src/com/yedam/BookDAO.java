package com.yedam;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends DAO {
	public Book searchBook(String bookNum) {
		Book result = null;
		sql = ""
			+ "select book_num, book_name, writer, publisher, "
			+ "price, rent_member, rent_date, return_date "
			+ "from book "
			+ "where book_num = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookNum);
			rs = psmt.executeQuery();
			if(rs.next()) {
				result = new Book();
				result.bookNum = rs.getString(1);
				result.bookName = rs.getString(2);
				result.writer = rs.getString(3);
				result.publisher = rs.getString(4);
				result.price = rs.getInt(5);
				result.rentMember = rs.getString(6);
				result.rentDate = rs.getString(7);
				result.returnDate = rs.getString(8);
				return result;
			}
			rs.close();
			psmt.close();
		} catch (java.sql.SQLSyntaxErrorException e) {
			System.out.println("책을 찾을수 없습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return null;
	}//Book searchBook()

	public int rentBook(String bookNum, Member login) {
		rows = 0;
		sql = ""
			+ "update book "
			+ "set rent_member = ?, rent_date = sysdate, return_date = sysdate + 7 "
			+ "where book_num = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, login.memberName);
			psmt.setString(2, bookNum);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//rentBook()
	
	public List<Book> searchBookName(String bookName) {
		List<Book> result = new ArrayList<>();
		 sql = ""
		 	 + "select * from book "
		 	 + "where book_name = ? ";
		 getOpen();
		 try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookName);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.bookNum = rs.getString(1); 
				book.bookName = rs.getString(2);
				book.writer = rs.getString(3);
				book.publisher = rs.getString(4);
				book.price = rs.getInt(5);
				book.rentMember = rs.getString(6);
				book.rentDate = rs.getString(7);
				book.returnDate = rs.getString(8);
				result.add(book);
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
	}//searchBookName()

	public List<Book> serchBookWriter(String writer) {
		List<Book> result = new ArrayList<>();
		 sql = ""
		 	 + "select * from book "
		 	 + "where writer = ? ";
		 getOpen();
		 try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, writer);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.bookNum = rs.getString(1); 
				book.bookName = rs.getString(2);
				book.writer = rs.getString(3);
				book.publisher = rs.getString(4);
				book.price = rs.getInt(5);
				book.rentMember = rs.getString(6);
				book.rentDate = rs.getString(7);
				book.returnDate = rs.getString(8);
				result.add(book);
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
	}//searchBookWriter()

	public List<Book> searchBookOrderName() {
		List<Book> result = new ArrayList<>();
		 sql = ""
		 	 + "select * from book "
		 	 + "order by book_name ";
		 getOpen();
		 try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.bookNum = rs.getString(1); 
				book.bookName = rs.getString(2);
				book.writer = rs.getString(3);
				book.publisher = rs.getString(4);
				book.price = rs.getInt(5);
				book.rentMember = rs.getString(6);
				book.rentDate = rs.getString(7);
				book.returnDate = rs.getString(8);
				result.add(book);
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
	}//searchBookOrderName()

	public List<Book> searchBookOrderWriter() {
		List<Book> result = new ArrayList<>();
		 sql = ""
		 	 + "select * from book "
		 	 + "order by writer ";
		 getOpen();
		 try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Book book = new Book();
				book.bookNum = rs.getString(1); 
				book.bookName = rs.getString(2);
				book.writer = rs.getString(3);
				book.publisher = rs.getString(4);
				book.price = rs.getInt(5);
				book.rentMember = rs.getString(6);
				book.rentDate = rs.getString(7);
				book.returnDate = rs.getString(8);
				result.add(book);
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
	}//searchBookOrderWriter()

	public int returnBook(String bookNum, Member login) {
		rows = 0;
		sql = ""
			+ "update book "
			+ "set rent_member = null, rent_date = null, return_date = null "
			+ "where book_num = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookNum);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//returnBook()

	public int insertBook(String bookNum, String bookName, String writer, String publisher, int price) {
		rows = 0;
		sql = ""
			+ "insert into book (book_num, book_name, writer, publisher, price) "
			+ "values (?, ?, ?, ?, ?) ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookNum);
			psmt.setString(2, bookName);
			psmt.setString(3, writer);
			psmt.setString(4, publisher);
			psmt.setInt(5, price);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("중복된 도서번호가 있습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//insertBook()

	public int deleteBook(String bookNum) {
		rows = 0;
		sql = ""
			+ "delete from book "
			+ "where book_num = ? ";
		getOpen();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookNum);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//deleteBook()

	public int updateBook(String bookNum, String bookName, String writer, String publisher, int price) {
		 rows = 0;
		 sql = ""
	 		 + "update book "
	 		 + "set book_name = ?, writer = ?, publisher = ?, price = ? "
	 		 + "where book_num = ? ";
		 getOpen();
		 try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookName);
			psmt.setString(2, writer);
			psmt.setString(3, publisher);
			psmt.setInt(4, price);
			psmt.setString(5, bookNum);
			rows = psmt.executeUpdate();
			psmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			getClose();
		}
		return rows;
	}//updateBook()
	
}
