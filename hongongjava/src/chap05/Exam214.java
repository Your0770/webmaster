package chap05;

import java.util.Arrays;

public class Exam214 {										//실행클래스

	public static void main(String[] args) {				//메인메소드가 있기때문에
		// 2차원 배열
		int[][] scores = {
				{10, 20, 30},
				{40, 50, 60}
		};
		
		//출력
		System.out.println(scores[1][1]);
		System.out.println();
		for(int i = 0;i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++) {
				System.out.print(scores[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		for(int[] row : scores) {
			for(int col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
		
		//2*3 배열을 선언하고
		//1에서 10까지 무작위 수를 입력하세요
		System.out.println();
		System.out.println();
		int[][] nums = new int[2][3];
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				int rNo = (int)(Math.random()*10)+1;
				nums[i][j] = rNo;
			}
		}
		
		//Arrays.toString 으로 출력하는 방법
		//2차 배열이기 때문에 포문을 돌리는데 행 인덱스에 i 적용
		for(int i = 0; i < scores.length; i++) {
			String layout = Arrays.toString(nums[i]);
			System.out.println(layout);
		}
		
		//향상된 for문
		int[] su = {10,200,30,40,-50,777,555};
		//배열의 합, 최대값, 최소값
		//향상된 for문을 이용
		int sum = 0;
		int max = Integer.MIN_VALUE;		// int 값 중에 최소값
		int min = Integer.MAX_VALUE;		// int 값 중에 최대값
		for(int ele : su) {
			sum += ele;
			if(max < ele) max = ele;
			if(min > ele) min = ele;
					
		}
		System.out.println("sum = " + sum);
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		
		
		
		
		
		
		
		
	}//main

}
