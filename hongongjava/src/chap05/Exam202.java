package chap05;

import java.util.Arrays;

public class Exam202 {

	public static void main(String[] args) {
		// 배열을 생성하는 방법
		// 배열을 이용하는 방법
		int[] scores = { 83, 90, 87 };
//		System.out.println("scores[0] : " + scores[0] );
//		System.out.println("scores[1] : " + scores[1] );
//		System.out.println("scores[2] : " + scores[2] );

		int sum = 0;
		for(int i = 0; i < scores.length; i++) {
			System.out.printf("scores[%1$d] : %2$d\n", i, scores[i]);
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		double avg = (double) sum / scores.length;
		System.out.printf("평균 : %.2f", avg);
		System.out.println();
		System.out.println();
		System.out.println();
		
		//배열에 1에서 100까지의 임의의 수 10개를 저장
		//배열의 합과 평균(소수 첫째자리까지 나타냄),
		//최대값, 최소값을 구하세요.
		
		//배열 생성
		int[] nums = new int[10];
		outer: for(int i = 0; i < nums.length; i++) {
			int rNum = (int)(Math.random()*100)+1;
			for(int j=0; j <=1; j++) {
				if(nums[j] == rNum) {
					i--;
					continue outer;
				}
			}
			nums[i] = rNum;
//			nums[i] = (int)(Math.random()*100)+1;		//위에 for문 없이 하면 중복값제거
			System.out.printf("nums[%1$d] = %2$d\n", i, nums[i]);
		}
		System.out.println(Arrays.toString(nums));		//배열을 표시할때 Arrays.toString(배열이름)
		//배열 이용										ㄴ//임포트 해야 사용 가능
		sum = 0;
		int max = 0;
		int min = 100;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if(max < nums[i]) max = nums[i];
			if(min > nums[i]) min = nums[i];
		}
		avg = (double) sum / nums.length;
		System.out.printf("총합 = %1$d\t평균 = %2$.1f\t", sum, avg);
		System.out.printf("최대값 = %1$d\t최소값 = %2$d\t", max, min);
		System.out.println();
		System.out.println();
		System.out.println();
		
		//main의 배열
		//run/run Configuration/Arguments/Program arguments
		String args1 = Arrays.toString(args);
		int args2 = Integer.parseInt(args[1]);
		System.out.println(args1);
		System.out.println(args2+100);
		
		
		
		
	}//main

}
