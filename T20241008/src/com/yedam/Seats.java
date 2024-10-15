package com.yedam;

public class Seats {
	//field
	int seatNum;
	String rentMember;
	String rentDate;
	String returnDate;
	

	//constructor
		
	//method
	
	
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
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
	@Override
	public String toString() {
		if(rentDate != null && returnDate != null) {
			return seatNum + "\t" + rentMember + "\t" + rentDate.substring(11) + "\t" + returnDate.substring(11);
		}else {
			return seatNum + "\t" + "대여 가능";
		}
	}
	
		
}
