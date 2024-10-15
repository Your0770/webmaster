package 최시훈;

import java.util.Scanner;

public class Doself {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// 1번
		System.out.println("1번 문제");
		while(true) {
			System.out.println();
			System.out.println("종료하시려면 q를 입력하세요.");
			System.out.print("년도 입력 > ");
			String year = sc.nextLine();
			if(year.equals("q")) break;
			int years = Integer.parseInt(year);
			if(years % 4 == 0) {
				if(years % 100 != 0) {
					System.out.println(years + "년은 윤년입니다.");
				} else if(years % 400 == 0) {
					System.out.println(years + "년은 윤년입니다.");
				} else {
					System.out.println(years + "년은 평년입니다.");
				}
			}else{
				System.out.println(years + "년은 평년입니다.");
			}
		}
	
		
		
		// 2번
		System.out.println();
		System.out.println("2번 문제");
		
		while(true) {
			System.out.println();
			System.out.println("종료하시려면 q를 입력하세요.");
			System.out.print("교환할 금액 > ");
			String money = sc.nextLine();
			if(money.equals("q")) break;
			int moneys = Integer.parseInt(money);
			int moneys1 = Integer.parseInt(money);
			System.out.println("500원 짜리 : " + moneys/500 + "개");
			moneys -= (moneys/500)*500;
			System.out.println("100원 짜리 : " + moneys/100 + "개");
			moneys -= (moneys/100)*100;
			System.out.println("50원 짜리 : " + moneys/50 + "개");
			moneys -= (moneys/50)*50;
			System.out.println("10원 짜리 : " + moneys/10 + "개");
			moneys -= (moneys/10)*10;
			System.out.println("교환 금액 : " + (moneys1-moneys) + "원");
			System.out.println("남은 금액 : " + moneys + "원");
		}
			
		// 3번
		System.out.println();
		System.out.println("3번 문제");
		
		quit: while(true) {											//다시할때 랜덤값과 카운트 초기화
			int ranNum = (int)(Math.random()*100) + 1;
			int count = 0;
			while(true) {
				System.out.println();
				System.out.println("종료하시려면 q를 입력하세요.");
				System.out.println("다시하시려면 r를 입력하세요.");
				System.out.print("숫자 입력 > ");
				String num = sc.nextLine();
				if(num.equals("r")) break;							//안의 while문 break
				if(num.equals("q")) break quit;						//밖의 while문 break
				int nums = Integer.parseInt(num);
				count++;
				if(nums == ranNum) {
					System.out.println("정답!");
					System.out.println(count + "번 만에 맞추셨습니다.");
				}
				else if(nums > ranNum) System.out.println("Down!");
				else if(nums < ranNum) System.out.println("Up!");
			}
		}
		
		
		// 4번
		System.out.println();
		System.out.println("4번 문제");
		System.out.println();
		for(int i = 2; i <= 9; i++) System.out.printf("%d단\t", i);		//단 호출
		System.out.println();
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%2$dX%1$d=%3$2d\t", i, j, (i*j));	//구구단 가로 호출
			}
			System.out.println();										// i하나당 줄바꿈
		}
		
		// 5번
		System.out.println();
		System.out.println("5번 문제");
		boolean con = true;
		while(con) {
			System.out.println();
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			
			System.out.println();
			System.out.print("번호 선택 > ");
			int temp = Integer.parseInt(sc.nextLine());
			switch(temp) {
			case 1 : System.out.println("화씨 온도 입력 > ");
				int tempF = Integer.parseInt(sc.nextLine());
				System.out.println("섭씨온도 = " + 5.0 / 9 * (tempF - 32));
				break;
			case 2 : System.out.println("섭씨 온도 입력 > ");
				int tempC = Integer.parseInt(sc.nextLine());
				System.out.println("화씨온도 = " + 9.0 / 5 * tempC + 32);
				break;
			case 3 : con = false; 
				break;
			default : System.out.println("다시 입력");
			}
		}
		
		
		// 6번
		System.out.println();
		System.out.println("6번 문제");
		while(true) {
			System.out.println();
			int RSP = (int)(Math.random()*3);
			System.out.print("가위(0), 바위(1), 보(2) > ");
			int myRSP = Integer.parseInt(sc.nextLine());
			if (myRSP >= 3) break;
			int result = RSP - myRSP;
			if (result < 0) result += 3;				// 음수일때 +3을 하면 값별로 모두 같은 값이 나옴
			
			switch(result) {
				case 0 : System.out.printf("사람 %d, 컴 %d = 비겼음 \n", myRSP, RSP);
						break;
				case 1 : System.out.printf("사람 %d, 컴 %d = 졌음 \n", myRSP, RSP);
						break;
				case 2 : System.out.printf("사람 %d, 컴 %d = 이겼음 \n", myRSP, RSP);
						break;
				default : System.out.println("game over");
			}
		}
		
		// 7번
		
		System.out.println();
		System.out.println("7번 문제");
		System.out.println();
		for(int i = 1; i <= 50; i++) {
			if(i % 10 == 3 | i % 10 == 6 | i % 10 == 9) {		// 1의 자리가 3,6,9
				if(i / 10 == 3)	System.out.print("♥♥\t");		// 33,36,39
				else System.out.print("♥\t");					// n3,n6,n9들
			}else if(i / 10 == 3) System.out.print("♥\t");		// 3n들
			else System.out.print(i + "\t"); 					// 나머지
			if(i % 10 == 0) System.out.println();				// 10단위로 줄바꿈
		}
		
		// 스캐너 종료
		sc.close();
	} //main

}
