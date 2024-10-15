package com.yedam;

public class Member {
	//field
	String memberId;
	String password;
	String memberName;
	String birthday;
	String phone;
	String permission;
	String creDate;
	String bookNum;
	String bookName;
	String rentDate;
	String returnDate;
	int seatNum;

	//constructor
	
	//method
	
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getCreDate() {
		return creDate;
	}
	public void setCreDate(String creDate) {
		this.creDate = creDate;
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
	@Override
	public String toString() {
		if(bookNum == null) {
			if(seatNum != 0) {
				return memberId + "\t" + password + "\t" + memberName + "\t"
						+ birthday.substring(0,10) + "\t" + phone + "\t" + permission + "\t" + creDate.substring(0,10) + "\t"
						+ "대여좌석 "  + seatNum + "\t\t" + "대여중인 책 없음";
			}else {
				return memberId + "\t" + password + "\t" + memberName + "\t"
						+ birthday.substring(0,10) + "\t" + phone + "\t" + permission + "\t" + creDate.substring(0,10) + "\t"
						+ "대여좌석 없음" + "\t" + "대여중인 책 없음";
			}
		}else {
			if(seatNum != 0) {
				return memberId + "\t" + password + "\t" + memberName + "\t"
						+ birthday.substring(0,10) + "\t" + phone + "\t" + permission + "\t" + creDate.substring(0,10) + "\t"
						+ "대여좌석 " + seatNum + "\t\t" + bookNum + "\t" + bookName + "\t" + rentDate.substring(0,10) + "\t" + returnDate.substring(0,10);
				
			}else {
				return memberId + "\t" + password + "\t" + memberName + "\t"
						+ birthday.substring(0,10) + "\t" + phone + "\t" + permission + "\t" + creDate.substring(0,10) + "\t"
						+ "대여좌석 없음" + "\t" + bookNum + "\t" + bookName + "\t" + rentDate.substring(0,10) + "\t" + returnDate.substring(0,10);
			}
			
		}
	}//toString()
	
	
}
