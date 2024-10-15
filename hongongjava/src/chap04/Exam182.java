package chap04;

import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
		// 2
		// 3
		// 4
		// (4*x) + (5*y) == 60
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if((4*x) + (5*y) == 60) {
					System.out.printf("( %d , %d ) ", x,y);
				}
			}
		}
		System.out.println();
		
		
		// 5
		String star = "";
		for(int i = 1; i <= 4; i++) {
			star += "*";
			System.out.println(star);
		}
		
		// 6
		String stars = "";
		for(int i = 1; i <= 4; i++) {
			stars += "*";
			System.out.printf("%4s\n",stars);
		}
		
//		//for문에 변수 두개
		stars = "";
		String blanc = "   ";
		for(int i = 1,j = 1; i <= 4 && j < i; i++,j++) {
			stars += "*";
			blanc.substring(j);
			String layout = blanc + stars;
			System.out.println(layout);
			
		}
//		중첩 for문
		stars = "";
		for(int i = 1; i <= 4; i++) {
			String blancs = "";
			for(int j = 4; j >= i;j--) {
				blancs += " ";
			}
			stars += "*";
			String layout = blancs + stars;
			System.out.println(layout);
		}
		
		// 7
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		
		while(run) {
		System.out.println("-------------------------");
		System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
		System.out.println("--------------------------");
		System.out.print("선택> ");
		int num = Integer.parseInt(scanner.nextLine());
		switch(num) {
			case 1 : System.out.print("예금액> ");
					 int sum =  Integer.parseInt(scanner.nextLine());
					 balance += sum;
					 break;
//					 System.out.println("잔고 : " + balance + "원");
			case 2 : System.out.print("출금액> ");
			 		 int sub =  Integer.parseInt(scanner.nextLine());
			 		 if(balance - sub >= 0) balance -= sub;
			 		 else {
			 			 System.out.println("잔액이 부족합니다.");
			 			 System.out.println("출금 가능한 금액은 " + balance + "원 입니다.");
			 		 }
			 		 break;
//			 		 System.out.println("잔고 : " + balance + "원");
			case 3 : System.out.println("잔고 : " + balance + "원");
					 break;
			case 4 : System.out.println("프로그램 종료");
				     run = false;
				     break;
		    default :System.out.println("다시 선택해주세요");
		}
		}
		
		
		
		
		scanner.close();
	}//main end

}
