package chap05;

import java.util.Scanner;

public class Exam223 {

	public static void main(String[] args) {
		// 확인문제 6번
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5.종료");
			System.out.println("---------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			switch(selectNo) {
			case 1 : System.out.print("학생수> "); 
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
				break;
			case 2 : 
				for(int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> ",i); 
					int result = Integer.parseInt(scanner.nextLine());
					scores[i] = result;
				}
				break;
			case 3 : 
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%1$d] = %2$d\n", i, scores[i]); 
				}
				break;
			case 4 :
				int sum = 0;
				int max = 0;
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(max < scores[i]) max = scores[i];
				}
				double avg = (double)sum / scores.length;
				System.out.printf("최고 점수 : %1$d\n평균 점수 : %2$f\n", max, avg);
				break;
			case 5 : System.out.println("프로그램 종료");
				run = false;
				break;
			default : System.out.println("값을 다시 입력하세요.");
			}
		}
		//스캐너 종료
		scanner.close();
		
	}//main

}
