package com.yedam;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SeatDAO dao = new SeatDAO();
		
		
		int seatNo = dao.finalNum();
		System.out.println("예약할 좌석 번호를 입력하세요.");
		System.out.print("좌석번호>> ");
		int seatNum = Integer.parseInt(sc.nextLine());
		int cnt = 0;
		System.out.println("==================좌석===================");
		while(seatNo > cnt) {
			cnt++;
			String sCnt = Integer.toString(cnt);
			if(cnt == seatNum) sCnt = "X";
			System.out.printf("%2s  ", sCnt);
			if(cnt%10==0)System.out.println();
		}
		System.out.println("==================좌석===================");
		
		sc.close();
	}//main

}
