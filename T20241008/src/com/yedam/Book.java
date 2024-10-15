package com.yedam;

public class Book {
	//field
	String bookNum;
	String bookName;
	String writer;
	String publisher;
	int price;
	String rentMember;
	String rentDate;
	String returnDate;
	

	//constructor
		
	//method
		
	
	@Override
	public String toString() {
		if(rentMember == null) {
			return bookNum + "\t\t" + bookName + "\t\t" + writer + "\t\t" + publisher + "\t\t" + "대여가능";
		}else {
			return bookNum + "\t\t" + bookName + "\t\t" + writer + "\t\t" + publisher + "\t\t" + rentMember + "\t\t" + rentDate.substring(0,10) + "\t\t" + returnDate.substring(0,10);
		}
	}
	public String getBookNum() {
		return bookNum;
	}
	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRentMember() {
		return rentMember;
	}
	public void setRentMember(String rentMember) {
		this.rentMember = rentMember;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	
}
