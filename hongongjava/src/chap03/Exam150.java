package chap03;

import java.util.Scanner;

public class Exam150 {

	public static void main(String[] args) {
		 int pencils = 534;
		 int students = 30;
//		 학생 1명이 가지는 연필 개수
		 int pencilsPerStudent = pencils / students;
		 System.out.println(pencilsPerStudent);
//		 남은 연필 개수
		 int pencilsLeft = pencils % students;
		 System.out.println(pencilsLeft);

		 int lengthTop = 5;
		 int lengthBottom = 10;
		 int height = 7;
		 double area = ((double)lengthTop + lengthBottom) * height / 2;
		 System.out.println(area);

		 Scanner scanner = new Scanner(System.in);
		 System.out.print("첫 번째 수: ");
		 double num1= Double.parseDouble(scanner.nextLine());
		 System.out.print("두 번째 수: ");
		 double num2= Double.parseDouble(scanner.nextLine());
		 if(num2 == 0.0){
		 System.out.println("결과: 무한대");
		 }  else {
		 System.out.println("결과: " + (num1 / num2));
		 }
		 
		 
		 
		 scanner.close();

		 
		 
		 
	}

}
