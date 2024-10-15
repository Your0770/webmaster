package chap02;

import java.util.Scanner;

public class Exam120 {

	public static void main(String[] args) {
//		문제1 : 출력문 연습
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		
		System.out.println("이름: " + name);
		System.out.print("나이: " + age + "\n");
		System.out.printf("전화: %1$s-%2$s-%3$s", tel1, tel2, tel3 );
				
//		문제2 : 
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\n첫 번째 수: ");
		String strNum1 = scanner.nextLine();
		System.out.print("두 번째 수: ");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과: " + result);
		if(num1 > num2) {
			System.out.println("뺄셈 결과: " + (num1 - num2));
		}else {
			System.out.println("뺄셈 결과: " + (num2 - num1));
		}
		
//		문제3 : 
		System.out.print("[필수 정보 입력]\n1. 이름: ");
		String idName = scanner.nextLine();
		System.out.print("2. 주민번호 앞 6자리: ");
		String idNum = scanner.nextLine();
		System.out.print("3. 전화번호: ");
		String idTel = scanner.nextLine();
		
		System.out.println("[입력된 내용]\n1. 이름: " + idName + "\n2. 주민번호 앞 6자리: " + idNum + "\n3. 전화번호: " + idTel);
		
		
		scanner.close();
	}

}
