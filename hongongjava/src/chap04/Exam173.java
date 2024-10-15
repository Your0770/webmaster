package chap04;

public class Exam173 {

	public static void main(String[] args) {
		// 50에서 100까지 3의 배수 합
		// 3의 배수 출력, 마지막에 3의 배수 합 출력
		// 3의 배수 개수 출력
		int sum = 0;
		int cnt = 0;
		for(int i = 51; i <= 100; i+=3) {
			sum += i;
			cnt++;
			System.out.print(i + " ");
		}		
		System.out.printf("\n합 = %1$d, 개수 = %2$d\n", sum, cnt);
		
		//while문
		//1에서 n까지의 합이 300이 넘는 순간 n값 구하기
		//7의 배수 합이 300이 넘는 순간 의 7의 배수 찾기
		int su = 0;
		sum = 0;
		while(sum<300) {
			su +=7;
			sum += su;
		}
		System.out.println(sum);
		System.out.println(su);
		
		//구구단 : 중첩 for 문
		for(int i=2; i<=9; i++) {
			System.out.println("\t====" + i + "단=====");
			for(int j=1; j<=9; j++) {
			System.out.printf("\t %1$d x %2$d = %3$2d\n", i, j, (i*j));
			}
		}
		
		for(int j=0; j<=9; j++) {
			if(j == 0) {
				for(int i = 2; i <= 9;i++) { 
					System.out.printf("%d단\t",i);
					if(i == 9) System.out.printf("%d단\n",i);
				}
			}
			else {
				for(int i=2; i<=9; i++) {
					System.out.printf("%1$dx%2$d=%3$2d\t", i, j, (i*j));
					if(i == 9) System.out.printf("%1$dx%2$d=%3$2d\n", i, j, (i*j));
				}
			}
		}
	
	}  //end main

}
